FROM openjdk:17
VOLUME /tmp
EXPOSE 8080
COPY target/tekanaEwallet-0.0.1-SNAPSHOT.jar tekanaEwallet.jar
ENTRYPOINT ["java","-jar","/tekanaEwallet.jar"]