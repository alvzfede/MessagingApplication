FROM openjdk:8-jdk-alpine
MAINTAINER baeldung.com
COPY target/MessagingApplication-0.0.1-SNAPSHOT.jar MessagingApplication-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java","-jar","/MessagingApplication-0.0.1-SNAPSHOT.jar"]