# Stage 1: Build stage using Maven with JDK 17
FROM maven:3.9.6-eclipse-temurin-17 as build

# Set the working directory inside the container
WORKDIR /app

# Copy all project files from the host to the container
COPY . /app

# Build the project and create a JAR file, skipping tests
RUN mvn clean package -DskipTests

# Stage 2: Runtime stage using only JDK 17 (smaller image, no Maven)
FROM openjdk:17

# Set the working directory inside the final container
WORKDIR /app

# Copy the generated JAR file from the build stage
COPY --from=build /app/target/demo-0.0.1-SNAPSHOT.jar app.jar

# Command to run the Spring Boot application
CMD ["java", "-jar", "app.jar"]
