
## Exception Handling

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