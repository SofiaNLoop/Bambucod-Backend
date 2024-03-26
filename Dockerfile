FROM gradle:8.6-jdk21 AS build
COPY . .
RUN gradle build -x test

FROM openjdk:21-jdk-slim
COPY --from=build /target/Bambucod-0.0.1-SNAPSHOT.jar Bambucod.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "Bambucod.jar"]
