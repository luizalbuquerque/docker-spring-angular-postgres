FROM maven:3.6.1-jdk-8-slim AS build
RUN mkdir -p /workspace
WORKDIR /workspace
COPY pom.xml /workspace
COPY src /workspace/src

FROM openjdk:8-alpine
COPY --from=build /workspace/*.jar /mts.api.jar
EXPOSE 8080
ENTRYPOINT ["java","-jar","mts.api.jar"]