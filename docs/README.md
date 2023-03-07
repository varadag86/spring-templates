## Springboot - Gradle with Postgres - Boilerplate

The springboot base gradle with postgres project focus is on the following

1. Simple springboot gradle project with [boilerplate](https://github.com/varadag86/spring-base-gradle) setup. Use the develop branch to generate the base scaffold.
2. `images` directory which const of the development dependent images. This includes `postgres` and `pgadmin` compose file.
3. images directory also includes a `.env` file wherein the credentials are configured to access the database and pgadmin.
4. The project sets up the stage with gradle dependencies necessary to establish connection with database along with spring-data-jpa.
5. Finally, it includes sample of domain, repository, service and controller. It also has references to how to connect the application using application properties file.

**Note**: The __boilerplate__ template of springboot includes industry standards configuration such as 
1. **checkmarx** configuration
2. `junit` & `jacoco` configuration
3. OAS 3.0 with `api-docs` enabled.


### Exception Handling
Exception handling is an important aspect of web development. Therefore, it is essential to  configure exception handling and provide pretty exception handling along with capturing all the essential data which would be needed for developers to analyze.
Also, proper exception handling with application friendly error codes enables application to cascade right information whether its frontend app or between apps.

Spring inherently uses `@ControllerAdvice` to provide exception handling out of the box. Along with controller advice we can use `zalando` package to prettify the exception and customize them for the application.

References:
- [Baeldung](https://www.baeldung.com/problem-spring-web)
- [Problem](https://github.com/zalando/problem)

Steps to configure zalando in the project.

1. Add the dependencies to `pom.xml` or `build.gradle`.
   ```groovy
   dependencies {
	    implementation 'org.zalando:problem:0.27.1'
	    implementation 'org.zalando:jackson-datatype-problem:0.27.1'
	    implementation 'org.zalando:problem-gson:0.27.1'
	    implementation 'org.zalando:problem-spring-web-starter:0.27.0'
   }
   ```

2. Update `application.yml` with below configuration.
   ```yaml
   spring:
     resources:
        add-mappings: false
     mvc:
        throw-exception-if-no-handler-found: false
     http:
        encoding:
        force: true
   ```

3. Get rid of `Whitelabel Exception` using 
   ```java

   import org.springframework.boot.SpringApplication;
   import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
   import org.springframework.boot.autoconfigure.SpringBootApplication;
   import org.springframework.boot.autoconfigure.web.servlet.error.ErrorMvcAutoConfiguration;

   @SpringBootApplication
   @EnableAutoConfiguration(exclude = ErrorMvcAutoConfiguration.class)
   public class BaseApplication {

        public static void main(String[] args) {
            SpringApplication.run(BaseApplication.class, args);
        }
   }
   ```

4. Add Exception Handlers
   ```java
   @ControllerAdvice
   public class ExceptionHandler implements ProblemHandling {}
   ```
   
5. Including custom exception handlers
   ```java
   import org.zalando.problem.AbstractThrowableProblem;
   import org.zalando.problem.Status;
   
   public class DataNotFoundException extends AbstractThrowableProblem {
       public DataNotFoundException(String message, Long key) {
            super(
                null,
                message,
                Status.NOT_FOUND,
                String.format("key: %d is not found", key)
            );
       }
   }
   ```

### What more to come?
1. Extend the API's and include springboot database migration implemented using flyway.
2. Add DML and DDL and turn off `ddl-auto` to `false`.
3. Include `roles` domain and establish a relationship between `user` to `domain`.
4. Add test container and unit test cases for the app.
5. Create dockerfile for the application.

