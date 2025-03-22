# Start from an OpenJDK image
FROM eclipse-temurin:17-jdk-jammy

# Set working directory inside container
WORKDIR /app

# Copy the built jar into the container
COPY target/scoober-backend-*.jar app.jar

# Run the application
ENTRYPOINT ["java", "-jar", "app.jar"]
