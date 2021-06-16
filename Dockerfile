FROM openjdk:12-jdk-alpine
COPY smarthome-0.0.1-SNAPSHOT.jar smarthome-0.0.1-SNAPSHOT.jar
CMD ["java","-jar","smarthome-0.0.1-SNAPSHOT.jar"]