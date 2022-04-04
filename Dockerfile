FROM openjdk:16.0.1
EXPOSE 80
VOLUME /tmp
ARG JAR_FILE=microservice-trip/build/libs/microserviceTrip.jar
COPY ${JAR_FILE} microserviceTrip.jar
ENTRYPOINT ["java","-jar","/microserviceTrip.jar"]