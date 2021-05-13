FROM openjdk:11-jdk-alpine
WORKDIR /app
COPY target/*.jar app.jar
CMD [ "java","-Djava.security.edg=file:/dev/./urandom","-jar","/app/app.jar" ]