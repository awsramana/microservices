FROM openjdk:8-jdk-alpine
VOLUME /tmp
ARG JAR_FILE
ADD ${JAR_FILE} i3.service.jar 
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","i3.service.jar"]