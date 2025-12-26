FROM eclipse-temurin:17-jdk-alpine

WORKDIR /app

COPY app.jar app.jar

EXPOSE 5000

ENTRYPOINT ["java", "-jar", "-Dserver.port=5000", "app.jar"]