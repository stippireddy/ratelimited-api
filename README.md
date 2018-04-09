# Rate limited APIs to retrieve list of hotels
This is a Spring-boot and Java 8 based implementation of two REST APIs. Both the APIs are rate limited. The rate limits can be configured in the file custom.properties. If the rate is not configured in custom.properties, the program usese a set of default values provided in default.properties.

### Instructions to run the program

This project requires maven. Once you have maven.

#### Building from source
```sh
1. git clone https://github.com/stippireddy/agoda-backend-developer
2. Change your current directory to the "agoda-backend-developer" directory
3. mvn clean install
4. You can find the jar in the target folder. Copy the hotelsdb.csv to the target folder.
5. "java -jar agoda-backend-developer-0.0.1-SNAPSHOT.jar" will start the program.
```
#### Use the jar in the project directory
```sh
1. Download the jar provided in the project directory.
2. Copy the hotelsdb.csv to the folder containing the jar.
3. "java -jar agoda-backend-developer-0.0.1-SNAPSHOT.jar" will start the program.
```
### API Documentation

This program provides two APIs.
1. City (/city?{optionalParameter(orderBy)=asc or desc})
2. Room (/room?{optionalParameter(orderBy)=asc or desc})

Each of these APIs provide a JSON response.

Status codes:
Success - 200
Too Many Requests - 429

The program will run on the default 8080 port. 

To get a list of all the hotels in Bangkok city:
http://localhost:8080/city/bangkok

To get a list of all the hotels in Bangkok city sorted in the ascending order of prices:
http://localhost:8080/city/bangkok?orderBy=asc

To get a list of all the hotels in Bangkok city sorted in the ascending order of prices:
http://localhost:8080/city/bangkok?orderBy=desc

To get a list of all the hotels with a deluxe room:
http://localhost:8080/room/deluxe

To get a list of all the hotels with a deluxe room in the ascending order of prices:
http://localhost:8080/room/deluxe?orderBy=asc

To get a list of all the hotels with a deluxe room sorted in the ascending order of prices:
http://localhost:8080/room/deluxe?orderBy=desc
