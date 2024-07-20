#FROM ubuntu:latest
#LABEL authors="kimminkyoung"
#
#ENTRYPOINT ["top", "-b"]

FROM amazoncorretto:17
COPY build/libs/*.jar spring-base.jar
ENTRYPOINT ["java", "-jar", "/spring-base.jar"]