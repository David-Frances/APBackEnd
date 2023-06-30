FROM amazoncorreto:11-alpine-jdk
MAINTAINER DAVID
COPY target/David-0.0.1-SNAPSHOT.jar david-app.jar
ENTRYPOINT ["java","-jar","/david-app.jar"]
