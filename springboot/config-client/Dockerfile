FROM openjdk:11-jdk
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} app.jar
COPY target/classes/application.properties /config/application.properties
ENTRYPOINT ["java","-jar","/app.jar", "--spring.config.location=optional:file:/config/application.properties"]