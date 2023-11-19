FROM openjdk:22-ea-24-jdk

VOLUME /tmp

COPY target/*.jar app.jar

EXPOSE 8080


ENTRYPOINT ["java","-jar","/app.jar"]
#