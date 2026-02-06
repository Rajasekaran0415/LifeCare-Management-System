package com.Healthmanagement.HealthManagement.Services;

import java.io.ByteArrayOutputStream;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.Healthmanagement.HealthManagement.DAO.PatientsDAO;
import com.Healthmanagement.HealthManagement.DTO.Patients;
import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Image;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.Rectangle;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import com.itextpdf.text.pdf.draw.LineSeparator;


// Bussiness Logic
@Component
public class PatientsServices {
	@Autowired
	PatientsDAO dao;
	public Patients savepatient(Patients patients) {
		return dao.savepatient(patients);
	
	}
	public Patients login(String name, String password) {
	 return dao.login(name, password);
		

	}
	public byte[] generatePatientReportPDF(int patientid) throws Exception {
	    Patients p = dao.findPatientById(patientid);
	    if (p == null) throw new RuntimeException("Patient ID " + patientid + " not found");

	    ByteArrayOutputStream baos = new ByteArrayOutputStream();
	    Document doc = new Document(PageSize.A4, 36, 36, 60, 60);
	    PdfWriter writer = PdfWriter.getInstance(doc, baos);
	    
	    doc.open();

	    // 1. Header Section (Logo, Hospital Info, Report Title)
	    PdfPTable head = new PdfPTable(new float[]{1, 3, 1.5f});
	    head.setWidthPercentage(100);
	    
	    // Logo (Left)
	    try {
	        Image img = Image.getInstance("D:\\Project\\logo.png");
	        img.scaleToFit(60, 60);
	        head.addCell(new PdfPCell(img, false)).setBorder(Rectangle.NO_BORDER);
	    } catch (Exception e) { head.addCell(getBlankCell()); }

	    // Hospital Name (Center)
	    PdfPCell mid = new PdfPCell();
	    mid.addElement(new Paragraph("LifeCare", FontFactory.getFont(FontFactory.HELVETICA_BOLD, 16)));
	    mid.addElement(new Paragraph("123 Health St,  Chennai City, 600043", FontFactory.getFont(FontFactory.HELVETICA, 9)));
	    mid.setBorder(Rectangle.NO_BORDER);
	    head.addCell(mid);

	    // Title & Date (Right)
	    PdfPCell right = new PdfPCell(new Phrase("PATIENT REPORT\n" + new SimpleDateFormat("dd-MMM-yyyy").format(new Date())));
	    right.setHorizontalAlignment(Element.ALIGN_RIGHT);
	    right.setBorder(Rectangle.NO_BORDER);
	    head.addCell(right);
	    
	    doc.add(head);
	    doc.add(new Chunk(new LineSeparator()));

	    // 2. Patient Data Table (4 Columns)
	    PdfPTable details = new PdfPTable(4);
	    details.setWidthPercentage(100);
	    details.setSpacingBefore(15f);
	    
	    addCell(details, "Patient ID:", String.valueOf(p.getId()));
	    addCell(details, "Name:", p.getName());
	    addCell(details, "Gender:", p.getGender());
	    addCell(details, "Age:", String.valueOf(p.getAge()));
	    addCell(details, "Blood Group:", p.getBloodgroup());
	    details.addCell(getBlankCell()); details.addCell(getBlankCell()); // Fill remaining
	    
	    doc.add(details);

	    // 3. Clinical Notes (Shaded Box)
	    doc.add(new Paragraph("\nClinical Notes / Diagnosis:", FontFactory.getFont(FontFactory.HELVETICA_BOLD, 11)));
	    PdfPCell noteCell = new PdfPCell(new Phrase("N/A"));
	    noteCell.setBackgroundColor(BaseColor.LIGHT_GRAY);
	    noteCell.setPadding(10);
	    PdfPTable noteTab = new PdfPTable(1);
	    noteTab.setWidthPercentage(100);
	    noteTab.addCell(noteCell);
	    doc.add(noteTab);

	    doc.close();
	    return baos.toByteArray();
	}

	// Helpers to reduce code bloat
	private void addCell(PdfPTable table, String label, String val) {
	    Font b = FontFactory.getFont(FontFactory.HELVETICA_BOLD, 10);
	    Font n = FontFactory.getFont(FontFactory.HELVETICA, 10);
	    table.addCell(new PdfPCell(new Phrase(label, b))).setBorder(Rectangle.NO_BORDER);
	    table.addCell(new PdfPCell(new Phrase(val != null ? val : "-", n))).setBorder(Rectangle.NO_BORDER);
	}

	private PdfPCell getBlankCell() {
	    PdfPCell c = new PdfPCell(new Phrase(""));
	    c.setBorder(Rectangle.NO_BORDER);
	    return c;
	}
	


}