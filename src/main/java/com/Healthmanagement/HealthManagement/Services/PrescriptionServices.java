package com.Healthmanagement.HealthManagement.Services;



import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import javax.imageio.ImageIO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.Healthmanagement.HealthManagement.DAO.PrescriptionDAO;
import com.Healthmanagement.HealthManagement.DAO.AppointmentsDAO; // இதையும் சேர்க்கவும்
import com.Healthmanagement.HealthManagement.DTO.Prescription;
import com.Healthmanagement.HealthManagement.DTO.Appointments; // இதையும் சேர்க்கவும்

@Service
public class PrescriptionServices {

    @Autowired
    PrescriptionDAO prescriptiondao;

    @Autowired
    AppointmentsDAO dao; 

    public Prescription addPrescription(Prescription prescription) {
        return prescriptiondao.savePrescription(prescription);
    }

    public byte[] generatePrescriptionImage(Prescription data, String patientName) throws IOException {
        
        Appointments appt = dao.findByPatientName(patientName);
        String doctorName = (appt != null) ? appt.getDoctorName() : "Doctor Not Assigned";

        int width = 800;
        int height = 1000;
        BufferedImage bufferedImage = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
        Graphics2D g2d = bufferedImage.createGraphics();

        // High Quality Rendering
        g2d.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_ON);

        g2d.setColor(Color.WHITE);
        g2d.fillRect(0, 0, width, height);

        g2d.setColor(new Color(0, 51, 102)); 
        g2d.setFont(new Font("SansSerif", Font.BOLD, 32));
        g2d.drawString("✚ LifeCare Hospital", 280, 80);
        g2d.setStroke(new BasicStroke(2));
        g2d.drawLine(50, 110, 750, 110);

        g2d.setColor(Color.BLACK);
        g2d.setFont(new Font("SansSerif", Font.PLAIN, 18));
        g2d.drawString("Patient Name: " + data.getName(), 60, 200);
        g2d.drawString("Date: " + java.time.LocalDate.now(), 60, 230);
        
        String docDisplay = "Prescribed By: " + doctorName;
        g2d.drawString(docDisplay, 60, 260);
        
        g2d.drawLine(50, 280, 750, 280);

        int y = 350;
        g2d.setFont(new Font("SansSerif", Font.BOLD, 20));
        g2d.drawString("Diagnosis & Medication Plan", 60, 320);
        
        g2d.setFont(new Font("SansSerif", Font.PLAIN, 18));
        String[] issues = data.getIssue().split(", ");
        for (String issue : issues) {
            g2d.setColor(new Color(0, 153, 102)); 
            g2d.fillOval(70, y-12, 10, 10);
            g2d.setColor(Color.BLACK);
            g2d.drawString(issue, 90, y);
            y += 30;
        }

        y += 20;
        g2d.setFont(new Font("SansSerif", Font.BOLD, 20));
        g2d.drawString("Medication", 60, y);
        g2d.setFont(new Font("SansSerif", Font.PLAIN, 17));
        y += 40;

        int count = 1;
        if (data.getIssue().contains("Fever")) {
            g2d.drawString(count++ + ". Dolo 650: 1-0-1 (For Fever)", 80, y); y += 30;
            g2d.drawString(count++ + ". Paracetamol 500mg: After Food.", 80, y); y += 30;
        }
        if (data.getIssue().contains("Headache")) {
            g2d.drawString(count++ + ". Saridon: Only when pain persists.", 80, y); y += 30;
        }
        if (data.getIssue().contains("Cold")) {
            g2d.drawString(count++ + ". Cetirizine: 1 time at night.", 80, y); y += 30;
        }        
        y = 900;
        g2d.setFont(new Font("SansSerif", Font.ITALIC, 16));
        g2d.drawString("Authorised Digital Signature", 500, y);
        g2d.drawOval(460, y-20, 30, 30);
        g2d.drawString("LC", 465, y);

        g2d.dispose();
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        ImageIO.write(bufferedImage, "png", baos);
        return baos.toByteArray();
    }
}