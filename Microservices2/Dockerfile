#Image that we are using
FROM openjdk:11
COPY target/microservice2-0.0.1-SNAPSHOT.jar microservice2.jar
#EXPOSE 8080
ENTRYPOINT ["java", "-jar", "microservice2.jar"]