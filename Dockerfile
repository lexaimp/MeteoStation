FROM arm64v8/debian:stable-20221114
RUN apt-get update && apt-get upgrade -y
RUN apt-get install default-jre -y
WORKDIR /home
COPY ./MeteoStation-1.0-SNAPSHOT.jar /home/app.jar
CMD java -jar app.jar