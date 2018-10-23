FROM openjdk:8-jdk-alpine
VOLUME /tmp
ARG JAR_FILE
ADD ${JAR_FILE} i3.web.jar 
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","i3.web.jar"]