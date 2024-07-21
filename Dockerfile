#FROM ubuntu:latest
#LABEL authors="kimminkyoung"
#
#ENTRYPOINT ["top", "-b"]

FROM amazoncorretto:17
WORKDIR /app
COPY build/libs/*.jar spring-base.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "/app/spring-base.jar"]
