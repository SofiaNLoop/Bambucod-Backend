# Etapa de construcción con Gradle
FROM gradle:8.6-jdk21 AS build
COPY . /app
WORKDIR /app
RUN gradle build -x test

# Etapa de ejecución con JRE
FROM openjdk:21-jdk-slim
COPY --from=build /app/build/libs/Bambucod-0.0.1-SNAPSHOT.jar /app/Bambucod.jar
WORKDIR /app
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "Bambucod.jar"]