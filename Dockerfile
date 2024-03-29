FROM openjdk:8-jre-alpine

RUN mkdir /app

WORKDIR /app

ADD ./interface-api/target/interface-api-1.0-SNAPSHOT.jar /app

EXPOSE 8080

CMD ["java", "-jar", "interface-api-1.0-SNAPSHOT.jar"]