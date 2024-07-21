#FROM ubuntu:latest
#LABEL authors="kimminkyoung"
#
#ENTRYPOINT ["top", "-b"]

FROM amazoncorretto:17
COPY build/libs/*.jar spring-base.jar
EXPOSE 8080

ENTRYPOINT ["java", "-jar", "/spring-base.jar"]