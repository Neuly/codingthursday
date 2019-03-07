FROM openjdk:8-jre-alpine

COPY ./app.jar /app.jar

EXPOSE 8080/tcp

CMD ["/usr/bin/java", "-jar", "/app.jar"]

ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/app.jar"]
