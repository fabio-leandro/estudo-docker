FROM openjdk:11
WORKDIR /app
COPY target/person-api-0.0.1-SNAPSHOT.jar /app/person-api.jar
ENTRYPOINT ["java","-jar","person-api.jar"]