# Step 1: Use an official OpenJDK 21 runtime as a parent image
FROM openjdk:21-jdk-slim

# Step 2: Set the working directory inside the container
WORKDIR /app

# Step 3: Copy the application's JAR file into the container
COPY target/coderhack-0.0.1-SNAPSHOT.jar /app/coderhack.jar

# Step 4: Expose port 8080 to the outside world
EXPOSE 8080

# Step 5: Run the Spring Boot application
ENTRYPOINT ["java", "-jar", "/app/coderhack.jar"]
