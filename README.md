# Game Server
Game server application for Imona assignment project.
Contains REST api's to create Game and get game, action and player details

## Technologies and Tools Used

 - Java 11
 - Spring Boot 2.4.1
 - Lombok for lots of useful annotations
 - DevTools for Live Reload
 - Maven for dependency management
 - MySql as database

## Requirements
 - JDK 11
 - Maven
 - Mysql Server

## Compile and Run
Change application properties(db settings, server port) for your environment first.
Settings file; src/main/resources/application.properties

To compile;

    mvn clean install
After successfull build, you ll find jar file with path; target/gameserver-0.0.1-SNAPSHOT.jar

To run; 

    java -jar target/gameserver-0.0.1-SNAPSHOT.jar
