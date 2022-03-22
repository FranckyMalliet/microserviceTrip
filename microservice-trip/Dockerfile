FROM openjdk:16.0.1
VOLUME /tmp
ARG JAR_FILE=target/microserviceTrip.jar
COPY ${JAR_FILE} microserviceTrip.jar
ENTRYPOINT ["java","-jar","/microserviceTrip.jar"]