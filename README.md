# kotlin-ispring
This project holds the course code for kotlin and spring

## H2 Database

- Access the h2 database in the following link - http://localhost:8080/h2-console

## Configuring Postgres

### 1. Spin up Postgres DB

#### Using Docker compose

- The docker compose file is present in this [link](https://github.com/dilipsundarraj1/kotlin-springboot/blob/postgres/course-catalog-service/docker-compose.yml)

- Run the below command to spin up Postgres Instance

```
docker-compose up
```

#### Other options

##### Mac

```
brew install postgres

createuser postgres -s

createdb -p 5432 -h localhost -e courses

```

##### Windows

- Check this [link](https://www.postgresqltutorial.com/install-postgresql/)



### 2. build.gradle.kts - Add the postgres Dependency

```
runtimeOnly("org.postgresql:postgresql")
```

### 3. Autoconfigure the Postgrs DB in application.yml

```
datasource:
  driverClassName: org.postgresql.Driver
  url: jdbc:postgresql://localhost:5438/courses
  username: postgres
  password: postgres
```

### Integration Test using TestContainers

#### 1. build.gradle.kts - Add the below changes

```

dependencyManagement {
    imports {
        mavenBom("org.testcontainers:testcontainers-bom:${property("testcontainersVersion")}")
    }
}

extra["testcontainersVersion"] = "1.16.2"


dependencies {
  //test-containers
  testImplementation("org.testcontainers:junit-jupiter")
  testImplementation("org.testcontainers:postgresql")
}

```

#### 2.1 Configure TestContainers in Integration Test

- Add the below annotation to the test class

```
@Testcontainers
```

- Configure and override the postgres Container using the below code

```
companion object {

  @Container
  val postgresDB = PostgreSQLContainer<Nothing>(DockerImageName.parse("postgres:13-alpine")).apply {
      withDatabaseName("testdb")
      withUsername("postgres")
      withPassword("secret")
  }

  @JvmStatic
  @DynamicPropertySource
  fun properties(registry: DynamicPropertyRegistry) {
      registry.add("spring.datasource.url", postgresDB::getJdbcUrl)
      registry.add("spring.datasource.username", postgresDB::getUsername)
      registry.add("spring.datasource.password", postgresDB::getPassword)
  }
}

```

#### 2.2 Configure TestContainers in @DataJPATest

- Create the **PostgreSQLContainerInitializer** class

```
@Testcontainers
open class PostgreSQLContainerInitializer {
  companion object {

  @Container
  val postgresDB = PostgreSQLContainer<Nothing>(DockerImageName.parse("postgres:13-alpine")).apply {
      withDatabaseName("testdb")
      withUsername("postgres")
      withPassword("secret")
  }

  @JvmStatic
  @DynamicPropertySource
  fun properties(registry: DynamicPropertyRegistry) {
      registry.add("spring.datasource.url", postgresDB::getJdbcUrl)
      registry.add("spring.datasource.username", postgresDB::getUsername)
      registry.add("spring.datasource.password", postgresDB::getPassword)
  }
}

}
```

- Add the **@AutoConfigureTestDatabase** annotation to the test class

```
@AutoConfigureTestDatabase(replace= AutoConfigureTestDatabase.Replace.NONE)
```

- Extend the PostgreSQLContainerInitializer to the test class

```
class CourseRepositoryIntgTest : PostgreSQLContainerInitializer(){

}
```
