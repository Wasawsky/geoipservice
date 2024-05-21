FROM openjdk:17-jdk-alpine
WORKDIR /app
COPY target/geoipservice-1.0.0.jar /app/
CMD ["java", "-jar", "geoipservice-1.0.0.jar"]