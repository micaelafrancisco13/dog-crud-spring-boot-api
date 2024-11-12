FROM eclipse-temurin:21.0.5_11-jdk-ubi9-minimal
VOLUME /tmp
ARG JAR_FILE=build/libs/dog-crud-spring-boot-api-0.0.1-SNAPSHOT.jar
COPY ${JAR_FILE} app.jar
ENTRYPOINT ["java","-jar","/app.jar"]
