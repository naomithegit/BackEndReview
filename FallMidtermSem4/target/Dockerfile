# Use an official OpenJDK runtime as a parent image
FROM openjdk:11-jre-slim

# Set the working directory in the container
WORKDIR /app

# Copy the jar file into the container at /app
COPY target/FallMidtermSem4-1.0-SNAPSHOT.jar /app/FallMidtermSem4.jar

# Run the jar file
CMD ["java", "-jar", "FallMidtermSem4.jar"]