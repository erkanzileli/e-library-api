# E-Library Automation API

## How can I contribute for this project?
You can contribute by develop.

## How can i develop?

First, you need to prepare your development environment.

### Install
- [JDK 1.8](https://www.oracle.com/technetwork/java/javase/downloads/jdk8-downloads-2133151.html)
- [Apache Maven 3.3.9](https://repo.maven.apache.org/maven2/org/apache/maven/apache-maven/3.3.9/)
- [Docker](https://docs.docker.com/install/)

## Run Project
Run code

	 docker run --name library-mysql -d -p 3306:3306 -e MYSQL_ROOT_PASSWORD=123qweasd -e MYSQL_DATABASE=library mysql:5.7

     mvn spring-boot:run

The rest will come.
