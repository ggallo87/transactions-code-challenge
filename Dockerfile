FROM maven:3.6.1-jdk-11-slim AS build
RUN mkdir -p /workspace
WORKDIR /workspace
COPY pom.xml /workspace
COPY src /workspace/src
RUN mvn -f pom.xml clean package

FROM adoptopenjdk/openjdk11:alpine-jre
COPY --from=build /workspace/target/*.jar application.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar","application.jar"]