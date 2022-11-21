FROM arm64v8/openjdk:19
ARG jar_file=/home/$USER/MeteoStation-1.0-SNAPSHOT.jar
WORKDIR /opt/app
COPY ${JAR_FILE} app.jar
ENTRYPOINT ["java","-jar","app.jar"]