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
```sh
{
	"statusCode": 200,
	"message": "Success",
	"results": [{
		"city": "Bangkok",
		"hotelID": 1,
		"room": "Deluxe",
		"price": 1000.0
	}, {
		"city": "Bangkok",
		"hotelID": 6,
		"room": "Superior",
		"price": 2000.0
	}, {
		"city": "Bangkok",
		"hotelID": 8,
		"room": "Superior",
		"price": 2400.0
	}, {
		"city": "Bangkok",
		"hotelID": 11,
		"room": "Deluxe",
		"price": 60.0
	}, {
		"city": "Bangkok",
		"hotelID": 14,
		"room": "Sweet Suite",
		"price": 25000.0
	}, {
		"city": "Bangkok",
		"hotelID": 15,
		"room": "Deluxe",
		"price": 900.0
	}, {
		"city": "Bangkok",
		"hotelID": 18,
		"room": "Sweet Suite",
		"price": 5300.0
	}]
}
```
To get a list of all the hotels in Bangkok city sorted in the ascending order of prices:
http://localhost:8080/city/bangkok?orderBy=asc
```sh
{
	"statusCode": 200,
	"message": "Success",
	"results": [{
		"city": "Bangkok",
		"hotelID": 11,
		"room": "Deluxe",
		"price": 60.0
	}, {
		"city": "Bangkok",
		"hotelID": 15,
		"room": "Deluxe",
		"price": 900.0
	}, {
		"city": "Bangkok",
		"hotelID": 1,
		"room": "Deluxe",
		"price": 1000.0
	}, {
		"city": "Bangkok",
		"hotelID": 6,
		"room": "Superior",
		"price": 2000.0
	}, {
		"city": "Bangkok",
		"hotelID": 8,
		"room": "Superior",
		"price": 2400.0
	}, {
		"city": "Bangkok",
		"hotelID": 18,
		"room": "Sweet Suite",
		"price": 5300.0
	}, {
		"city": "Bangkok",
		"hotelID": 14,
		"room": "Sweet Suite",
		"price": 25000.0
	}]
}
```
To get a list of all the hotels in Bangkok city sorted in the ascending order of prices:
http://localhost:8080/city/bangkok?orderBy=desc
```sh
{
	"statusCode": 200,
	"message": "Success",
	"results": [{
		"city": "Bangkok",
		"hotelID": 14,
		"room": "Sweet Suite",
		"price": 25000.0
	}, {
		"city": "Bangkok",
		"hotelID": 18,
		"room": "Sweet Suite",
		"price": 5300.0
	}, {
		"city": "Bangkok",
		"hotelID": 8,
		"room": "Superior",
		"price": 2400.0
	}, {
		"city": "Bangkok",
		"hotelID": 6,
		"room": "Superior",
		"price": 2000.0
	}, {
		"city": "Bangkok",
		"hotelID": 1,
		"room": "Deluxe",
		"price": 1000.0
	}, {
		"city": "Bangkok",
		"hotelID": 15,
		"room": "Deluxe",
		"price": 900.0
	}, {
		"city": "Bangkok",
		"hotelID": 11,
		"room": "Deluxe",
		"price": 60.0
	}]
}
```
To get a list of all the hotels with a deluxe room:
http://localhost:8080/room/deluxe
```sh
{
	"statusCode": 200,
	"message": "Success",
	"results": [{
		"city": "Bangkok",
		"hotelID": 1,
		"room": "Deluxe",
		"price": 1000.0
	}, {
		"city": "Amsterdam",
		"hotelID": 4,
		"room": "Deluxe",
		"price": 2200.0
	}, {
		"city": "Ashburn",
		"hotelID": 7,
		"room": "Deluxe",
		"price": 1600.0
	}, {
		"city": "Bangkok",
		"hotelID": 11,
		"room": "Deluxe",
		"price": 60.0
	}, {
		"city": "Ashburn",
		"hotelID": 12,
		"room": "Deluxe",
		"price": 1800.0
	}, {
		"city": "Bangkok",
		"hotelID": 15,
		"room": "Deluxe",
		"price": 900.0
	}, {
		"city": "Ashburn",
		"hotelID": 17,
		"room": "Deluxe",
		"price": 2800.0
	}, {
		"city": "Ashburn",
		"hotelID": 21,
		"room": "Deluxe",
		"price": 7000.0
	}, {
		"city": "Amsterdam",
		"hotelID": 23,
		"room": "Deluxe",
		"price": 5000.0
	}, {
		"city": "Ashburn",
		"hotelID": 25,
		"room": "Deluxe",
		"price": 1900.0
	}, {
		"city": "Amsterdam",
		"hotelID": 26,
		"room": "Deluxe",
		"price": 2300.0
	}]
}
```
To get a list of all the hotels with a deluxe room in the ascending order of prices:
http://localhost:8080/room/deluxe?orderBy=asc
```sh
{
	"statusCode": 200,
	"message": "Success",
	"results": [{
		"city": "Bangkok",
		"hotelID": 11,
		"room": "Deluxe",
		"price": 60.0
	}, {
		"city": "Bangkok",
		"hotelID": 15,
		"room": "Deluxe",
		"price": 900.0
	}, {
		"city": "Bangkok",
		"hotelID": 1,
		"room": "Deluxe",
		"price": 1000.0
	}, {
		"city": "Ashburn",
		"hotelID": 7,
		"room": "Deluxe",
		"price": 1600.0
	}, {
		"city": "Ashburn",
		"hotelID": 12,
		"room": "Deluxe",
		"price": 1800.0
	}, {
		"city": "Ashburn",
		"hotelID": 25,
		"room": "Deluxe",
		"price": 1900.0
	}, {
		"city": "Amsterdam",
		"hotelID": 4,
		"room": "Deluxe",
		"price": 2200.0
	}, {
		"city": "Amsterdam",
		"hotelID": 26,
		"room": "Deluxe",
		"price": 2300.0
	}, {
		"city": "Ashburn",
		"hotelID": 17,
		"room": "Deluxe",
		"price": 2800.0
	}, {
		"city": "Amsterdam",
		"hotelID": 23,
		"room": "Deluxe",
		"price": 5000.0
	}, {
		"city": "Ashburn",
		"hotelID": 21,
		"room": "Deluxe",
		"price": 7000.0
	}]
}
```
To get a list of all the hotels with a deluxe room sorted in the ascending order of prices:
http://localhost:8080/room/deluxe?orderBy=desc
```sh
{
	"statusCode": 200,
	"message": "Success",
	"results": [{
		"city": "Ashburn",
		"hotelID": 21,
		"room": "Deluxe",
		"price": 7000.0
	}, {
		"city": "Amsterdam",
		"hotelID": 23,
		"room": "Deluxe",
		"price": 5000.0
	}, {
		"city": "Ashburn",
		"hotelID": 17,
		"room": "Deluxe",
		"price": 2800.0
	}, {
		"city": "Amsterdam",
		"hotelID": 26,
		"room": "Deluxe",
		"price": 2300.0
	}, {
		"city": "Amsterdam",
		"hotelID": 4,
		"room": "Deluxe",
		"price": 2200.0
	}, {
		"city": "Ashburn",
		"hotelID": 25,
		"room": "Deluxe",
		"price": 1900.0
	}, {
		"city": "Ashburn",
		"hotelID": 12,
		"room": "Deluxe",
		"price": 1800.0
	}, {
		"city": "Ashburn",
		"hotelID": 7,
		"room": "Deluxe",
		"price": 1600.0
	}, {
		"city": "Bangkok",
		"hotelID": 1,
		"room": "Deluxe",
		"price": 1000.0
	}, {
		"city": "Bangkok",
		"hotelID": 15,
		"room": "Deluxe",
		"price": 900.0
	}, {
		"city": "Bangkok",
		"hotelID": 11,
		"room": "Deluxe",
		"price": 60.0
	}]
}
```
When the program hits the rate limit for City API, the sample response for hitting this API is given below.

http://localhost:8080/city/bangkok
```sh
{
	"statusCode": 429,
	"message": "Too many requests. Api is suspended for the next 5 seconds",
	"results": null
}
````
