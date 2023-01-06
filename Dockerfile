FROM docker.io/library/openjdk:18-jdk

COPY ./target/Vector-0.0.1-SNAPSHOT.jar /usr/src/app/

WORKDIR usr/src/app
ENTRYPOINT ["java", "-jar", "Vector-0.0.1-SNAPSHOT.jar"]