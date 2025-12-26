FROM ubuntu:latest
LABEL authors="Kene"

ENTRYPOINT ["top", "-b"]

# Use OpenJDK 17 (matches your JDK)
FROM eclipse-temurin:17-jdk-alpine

# Set working directory
WORKDIR /app

# Copy Maven build output (jar)
COPY target/hope-0.0.1-SNAPSHOT.jar app.jar

# Expose port
EXPOSE 8080

# Run the app
ENTRYPOINT ["java","-jar","app.jar"]
