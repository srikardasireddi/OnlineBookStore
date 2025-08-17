# Use OpenJDK 17 slim as base image
FROM openjdk:17-jdk-slim

# Set working directory in container
WORKDIR /app

# Copy target jar file into the container
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} app.jar

# Expose the service port (change per service)
EXPOSE 8081

# Run the jar file
ENTRYPOINT ["java", "-jar", "app.jar"]
