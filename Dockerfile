FROM openjdk:9
WORKDIR /app
ADD . /app
RUN apt update -y && apt install -y maven && mvn clean install
ENTRYPOINT ["java","-jar","/app/target/marketapp.jar"]
