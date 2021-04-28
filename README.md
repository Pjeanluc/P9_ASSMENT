# P9_ASSMENT

Micro-service assement evaluate a level of risk (diabet) for a patient.
this micro-service need patient and note to calculate the risk. 

## Prerequisite to run

- Java 1.8
- Spring Boot 2.2.6
- Docker

## Installation
### Host file

- 127.0.0.1 note
- 127.0.0.1 assessment
- 127.0.0.1 webapp
- 127.0.0.1 patient

### Docker image construction in project directory
~~~
docker build --build -t assessement .
~~~
### Docker execution
if docker-compose is not use
~~~
docker run -p 8083:8083 --name P9-assessment assessment
~~~~
if docker-compose is user (directory patient)
~~~
docker-compose up -d
~~~~

## Documentation
 http://localhost:8083/swagger-ui.html
   
## Global architecture
![alt text](schema.jpg)