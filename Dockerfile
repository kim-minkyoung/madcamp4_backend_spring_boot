#FROM ubuntu:latest
#LABEL authors="kimminkyoung"
#
#ENTRYPOINT ["top", "-b"]

FROM amazoncorretto:17

# Set the working directory in the container
WORKDIR /app

# Copy the JAR file into the container
COPY build/libs/*.jar app.jar

# Expose port 8080
EXPOSE 8080

# Define the command to run the JAR file
ENTRYPOINT ["java", "-jar", "app.jar"]