FROM maven:3.6.0-jdk-8-alpine
EXPOSE 8080
WORKDIR api
COPY . .
ENTRYPOINT "mvn"
CMD "spring-boot:run"