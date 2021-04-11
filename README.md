### aem-romamnumeral
Containerized java service to convert integer to roman 

## How to run the project

1) Clone the repository
2) Run <b> docker-compose up </b> <br>
   If the above-mentioned command fails, try to upgrade to the latest docker-compose version
3) Project is running on localhost, port 8080 <br>
   http:127.0.0.1:8080/romannumeral?query={number}
4) How to check logs : <br>
   a) <b> docker exec -it dev_aem-app_1 /bin/sh </b> <br>
   If the above-mentioned command doesn't work, check your contanier name and run <b>docker exec -it {container_name} /bin/sh</b> <br>
   b) <b>cat /log/aem-app.log</b>
   

## Engineering and Testing Methodology

1) I have created a spring boot application where I have created one rest controller which serves the get request.
2) I have created a service where I have created two methods : one for input validation and one for integer to roman conversion.
3) I have written unit tests for many different scenarios like normal input, input out of range, invalid characters/symbols in the input.
4) Logs are getting generated in a separate log file.
5) On top of this I have created dockerfile and docker-compose to run and build the application in docker containers.

## Packaging Layout

1) in src/main/java/com.aem.dev : 4 different packages are there. <br>
   a) Controller - Where I have created one rest controller and an Controller Advice class which adds failed message to failed responses. <br>
   b) exception - Here I have created on custom exception. <br>
   c) service - Inside this package, there are service class which has the main logics (int to roman conversion). <br>
   d) model - The model of output response in case of good response. <br>
   
2) in src/test/java/com/aem.dev/controller - I have written few unit tests which checks all the possible condition like convert a valid integer to roman literals
and checks all the possible exception

## Dependency Attribution

1) I have added all the dependencies in pom.xml. Some of them are Lombok, junit, mockito

## References
1) https://en.wikipedia.org/wiki/Roman_numerals
  
