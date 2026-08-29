# Build stage
FROM maven:3.8.5-openjdk-17 AS build
COPY . .
RUN mvn clean package -DskipTests

# Run stage
FROM openjdk:17.0.1-jdk-slim

# Install font dependencies required by Java AWT / PDF rendering
RUN apt-get update && apt-get install -y fontconfig libfreetype6 && rm -rf /var/lib/apt/lists/*

COPY --from=build /target/HealthManagement-0.0.1-SNAPSHOT.jar app.jar
EXPOSE 8080

# Run in headless mode
ENTRYPOINT ["java", "-Djava.awt.headless=true", "-jar", "app.jar"]