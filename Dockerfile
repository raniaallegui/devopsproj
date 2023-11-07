FROM openjdk:8-jdk-alpine
EXPOSE 8082
ADD target/achat-1.0.0.jar proj.jar
ENTRYPOINT ["java","-jar","proj.jar"]
