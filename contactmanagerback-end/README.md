# Java_SpringBoot_And_MongoDB_CRUD_Example

A working full CRUD example of developing end-points with Spring Boot connecting to a local MongoDB database, the endpoints can be tested after running the code in eclipse with
postman:
https://www.postman.com/

You can perform get, post, pull, and delete requests on the endpoint below

localhost:8080/api/v1/person/

to GET all people use: 
localhost:8080/api/v1/person/

to GET a person by id use
localhost:8080/api/v1/person/{UUID_OF_PERSON} where "{UUID_OF_PERSON}" is the uuid
for example:
localhost:8080/api/v1/person/9760fd8f-31d4-4f35-b4bf-db0bc3884157

to POST use: 
localhost:8080/api/v1/person/ and pass in a body. 
An example of a body is:
{
	"name" : "John Doe"
}

to PUT use:
localhost:8080/api/v1/person/{UUID_OF_PERSON_TO_UPDATE} where "{UUID_OF_PERSON_TO_UPDATE}" is the uuid
for example:
localhost:8080/api/v1/person/9760fd8f-31d4-4f35-b4bf-db0bc3884157

to DELETE use:
localhost:8080/api/v1/person/{UUID_OF_PERSON_TO_DELETE} where "{UUID_OF_PERSON_TO_DELETE}" is the uuid
for example:
localhost:8080/api/v1/person/9760fd8f-31d4-4f35-b4bf-db0bc3884157

Modifications will persist in a local MongoDB Database called DB01

To import this project into Eclipse Java Enterprise edtion, first download/unzip or clone this project.

In Eclispse go to File->Import->Maven->Existing Maven Projects->Next->Browse then choose this project folder and then press open and finish.
