FROM arm64v8/openjdk:19
WORKDIR /usr/src/myapp
COPY ./MeteoStation-1.0-SNAPSHOT.jar /usr/src/myapp/app.jar
#ENTRYPOINT ["java","-jar","/app.jar"]