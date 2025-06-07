FROM eclipse-temurin:17-jdk-alpine

WORKDIR /app
COPY server/ /app/
RUN chmod +x mvnw
RUN ./mvnw clean install
CMD ["java", "-jar", "target/taskmanager-0.0.1-SNAPSHOT.jar"]