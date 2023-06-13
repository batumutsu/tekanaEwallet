FROM openjdk:17
#VOLUME /tmp
#EXPOSE 8080
#COPY target/tekanaEwallet-0.0.1-SNAPSHOT.jar tekanaEwallet.jar
#ENTRYPOINT ["java","-jar","/tekanaEwallet.jar"]
WORKDIR /tekanaEwallet-app
COPY . .
RUN mvn clean install -DskipTests

CMD mvn spring-boot:run