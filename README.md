# gameof3
Game of 3 challenge

I did the challenge using Java 8, Java EE and maven.

I have two standalone projects for the challenge:

1. Game Api
2. Game Client

The prerequisites to run the applications are:
1. Java 8
2. Maven 3 >


## Running the game api

After you clone the project using git, you can run the api application with the following commands:

```
cd gameof3-api
mvn clean package
java -jar ./target/gameapi-swarm.jar
```

To check if the api is running and available, you can access http://localhost:8081/api/status in a browser window and the text "ok" should be displayed.


## Running the game client

To run the client you can similarly install using the following commands:


```
cd gameof3-client
mvn clean package
java -jar ./target/gameclient-swarm.jar 
```

To access the game client you can type http://localhost:8080 in your browser. 

To start a game you will need 2 browser windows with the client opened.
 





