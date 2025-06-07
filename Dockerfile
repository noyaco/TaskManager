FROM eclipse-temurin:17
WORKDIR /app
COPY . .
RUN ./mvnw clean install
CMD ["java", "-jar", "target/taskmanager-0.0.1-SNAPSHOT.jar"]