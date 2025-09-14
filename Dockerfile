# Multi-stage Docker build for Notification Service

# Stage 1: Build
FROM maven:3.9.6-eclipse-temurin-17 AS build

WORKDIR /app

# Copy all POM files
COPY parent/pom.xml /app/parent/pom.xml
COPY notification-microservice/pom.xml /app/notification-microservice/pom.xml

# Install parent POM
RUN cd /app/parent && mvn install -N

# Download microservice dependencies
RUN mkdir -p /app/notification-microservice/src/main/java/temp && \
    echo "public class Temp {}" > /app/notification-microservice/src/main/java/temp/Temp.java

RUN cd /app/notification-microservice && mvn dependency:go-offline -DskipTests

# Clean temp files
RUN rm -rf /app/notification-microservice/src/main/java/temp

# Build notification service
COPY notification-microservice/src /app/notification-microservice/src
RUN cd /app/notification-microservice && mvn clean package -DskipTests

# Stage 2: Runtime
FROM eclipse-temurin:17-jre-alpine

WORKDIR /app

# Copy JAR from build stage
COPY --from=build /app/notification-microservice/target/notification-microservice-*.jar app.jar

# Expose port
EXPOSE 8085

# Run application
ENTRYPOINT ["java", "-jar", "app.jar"]
