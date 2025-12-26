# Use Java 17 runtime
FROM eclipse-temurin:17-jdk-alpine

# Copy the actual JAR into the container
COPY target/hope-0.0.1-SNAPSHOT.jar app.jar

# Set the entrypoint to run the JAR
ENTRYPOINT ["java", "-jar", "app.jar"]

# Expose port 8080 (change to 80 if EB health check requires)
EXPOSE 80
