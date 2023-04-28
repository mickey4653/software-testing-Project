# Assignment 2: DI and AOP

In this assignment, you will _**first**_ use Spring Boot Framework to wire up some services used by a “web application”
and _**second**_ use Spring AOP framework to create logging aspect. 
This is NOT a real web application, it is just a conceptual application to help you understand the usage of Dependency Injection. 

The services and their dependencies are as follows:
* `WebApplication` _depends_ on a `WebServer` to run its application logic. 
* `WebServer` _depends_ on a `Frontend`, a `Middleware` and a `Persistence` services. There are a couple of implementations for each of these services. 
* `Frontend` _depends_ on an `Authentication` service. There are a couple of implementations for this service. 
* `Persistence` _depends_ on a `FileSystem` and a `Connection` service. There are a couple of implementations for each of these services.

## Tasks 

1. **Task 1 (15 points)**: You will use Constructor Injection to wire up these services as described above for each of the implementations. 
For each service, in the run() method you will invoke all of the dependent services if there are any (similar to WebServer). 

1. **Task 2 (15 points)**: You will create _default_ `beans` in `edu.umd.enpm614.assignment2.StandardConfig` that will bind: 
    * FrontendHTML for Frontend
    * MiddlewareTomcat for Middleware
    * PersistenceMySQL for Persistence
    * AuthenticationSSL for Authentication
    * FileSystemNTFS for FileSystem
    * ConnectionPooled for Connection

1. **Task 3 (20 points)**: You will create additional `beans` in `edu.umd.enpm614.assignment2.AdditionalConfig` that will bind: 
    * FrontendGWT
    * MiddlewareJBose 
    * PersistenceOracle 
    * AuthenticationTSL 
    * FileSystemNFS
    * ConnectionJDBC 
    
    In addition, you will use Spring AOP to create a logging interceptor (aspect) in `edu.umd.enpm614.assignment2` 
    named `LoggingAspect` that tracks all method calls of subclasses of Frontend, Middleware and Persistence. 

    Your logs should be in the format: `Logging Aspect: QualifiedClassName.methodName`

## Running the Application

To run the application, in your terminal navigate to the directory where the project is located.
Run the following command in Unix (MacOS or Linux) environment:

To run application Task 1:
```shell script
./gradlew bootRun --args="--spring.profiles.active=task1"
``` 

To run application Task 2:
```shell script
./gradlew bootRun --args="--spring.profiles.active=task2"
``` 

To run default task as defined in `build.gradle` file
```shell script
./gradlew bootRun
``` 
