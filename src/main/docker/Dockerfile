FROM openjdk:8-jdk-alpine
VOLUME /opt/etc/config
COPY /opt/etc/config /opt/etc/config
COPY productms-1.0.0.jar app.jar
EXPOSE 8080
ENTRYPOINT ["java","-jar","/app.jar"]