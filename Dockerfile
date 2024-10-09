# Create an Image
FROM openjdk:17-jdk-alpine
EXPOSE 5000
COPY target/user-module-0.0.1-SNAPSHOT.jar user-module-0.0.1-SNAPSHOT.jar
CMD ["java", "-jar", "user-module-0.0.1-SNAPSHOT.jar"]