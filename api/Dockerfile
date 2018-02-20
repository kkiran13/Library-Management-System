FROM openjdk:8-jre-alpine
VOLUME /tmp
COPY ./target/librarymanager-1.0.jar /librarymanager/app.jar
WORKDIR /librarymanager
CMD /usr/bin/java -Xmx400m -Xms400m -Dspring.profiles.active=storage.kafka,auth.disabled -jar app.jar
#EXPOSE 8080
