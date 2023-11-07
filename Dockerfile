FROM openjdk:11-jdk-alpine
EXPOSE 8082
ADD target/achat-1.0.jar proj.jar
ENTRYPOINT ["java","-jar","proj.jar"]
