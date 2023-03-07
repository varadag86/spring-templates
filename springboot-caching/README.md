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

### What more to come?
1. Extend the API's and include springboot database migration implemented using flyway.
2. Add DML and DDL and turn off `ddl-auto` to `false`.
3. Include `roles` domain and establish a relationship between `user` to `domain`.
4. Add test container and unit test cases for the app.
5. Create dockerfile for the application.

