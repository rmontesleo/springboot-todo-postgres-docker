# Configuration


## Initial Configuration from Spring Initializer

- [Configuration from Spring Boot Initializer](https://start.spring.io/#!type=maven-project&language=java&platformVersion=2.6.6&packaging=jar&jvmVersion=17&groupId=com.demo.todoapi&artifactId=springboot-todo-h2-api-container&name=todo-api-container&description=Basic%20TODO%20API%20demo%20with%20SpringBoot%20and%20H2%20using%20containers%20for%20Demos&packageName=com.demo.todoapi&dependencies=web,data-jpa,h2,lombok,devtools,validation)

## Set JAVA_HOME

## Set MVN_HOME

## Configure settings.xml

## Configuring .env file, this will be required for docker-compose.yaml

```bash
# Variables for the database
POSTGRES_USER=postgres_user
POSTGRES_PASSWORD=SuperSecret
POSTGRES_DB=todoappdb

## Variables for the pgadmin
PGADMIN_DEFAULT_EMAIL=user@domain.com
PGADMIN_DEFAULT_PASSWORD=SuperSecret

## Variables for api in container
TODO_API_VERSION=0.1
APPLICATION_PORT=8080
SPRING_DATASOURCE_USERNAME=postgres_user
SPRING_DATASOURCE_PASSWORD=SuperSecret
SPRING_DATASOURCE_URL=jdbc:postgresql://posgresqldb:5432/todoappdb
IS_FORMAT_SQL=true
IS_SHOW_SQL=true
HOW_ANSI_OUTPUT_IS_ENABLED=ALWAYS
```

## Configuring setting and maven settings create a file call variables

```bash
# Variables for the database
export POSTGRES_USER=postgres_user
export POSTGRES_PASSWORD=SuperSecret
export POSTGRES_DB=todoappdb

## Variables for the pgadmin
export PGADMIN_DEFAULT_EMAIL=user@domain.com
export PGADMIN_DEFAULT_PASSWORD=SuperSecret

## Variables for api in container
export TODO_API_VERSION=0.1
export APPLICATION_PORT=8080
export SPRING_DATASOURCE_USERNAME=postgres_user
export SPRING_DATASOURCE_PASSWORD=SuperSecret
export SPRING_DATASOURCE_URL=jdbc:postgresql://localhost:5432/todoappdb
export IS_FORMAT_SQL=true
export IS_SHOW_SQL=true
export HOW_ANSI_OUTPUT_IS_ENABLED=ALWAYS
```

---

## Configuration on VSCode


### In vscode use this configuration to add inse of .vscode/launch.json  . This will be for vscode runtime
```json
"env": {
// Variables for the database
    "POSTGRES_USER": "postgres_user",
    "POSTGRES_PASSWORD":"SuperSecret",
    "POSTGRES_DB": "todoappdb",

// Variables for the pgadmin
    "PGADMIN_DEFAULT_EMAIL": "user@domain.com",
    "PGADMIN_DEFAULT_PASSWORD": "SuperSecret",

// Variables for api in container
    "TODO_API_VERSION": "0.1",
    "APPLICATION_PORT": "8080",
    "SPRING_DATASOURCE_USERNAME": "postgres_user",
    "SPRING_DATASOURCE_PASSWORD": "SuperSecret",
    "SPRING_DATASOURCE_URL": "jdbc:postgresql://localhost:5432/todoappdb",
    "IS_FORMAT_SQL": true,
    "IS_SHOW_SQL": true,
    "HOW_ANSI_OUTPUT_IS_ENABLED":"ALWAYS"
}
```

## In vscode use this configuration to add inside of .vscode/settings.json . This wil be used for maven lifecycle on vscode 
```json
{
    "maven.terminal.customEnv": [
        {
            "environmentVariable": "POSTGRES_USER",
            "value": "postgres_user"
        },
        {
            "environmentVariable": "POSTGRES_PASSWORD",
            "value": "SuperSecret"
        },
        {
            "environmentVariable": "POSTGRES_DB",
            "value": "todoappdb"
        },
        {
            "environmentVariable": "PGADMIN_DEFAULT_EMAIL",
            "value": "user@domain.com"
        },
        {
            "environmentVariable": "PGADMIN_DEFAULT_PASSWORD",
            "value": "SuperSecret"
        },
        {
            "environmentVariable": "TODO_API_VERSION",
            "value": "0.1"
        },
        {
            "environmentVariable": "APPLICATION_PORT",
            "value": "8080"
        },
        {
            "environmentVariable": "SPRING_DATASOURCE_USERNAME",
            "value": "postgres_user"
        },
        {
            "environmentVariable": "SPRING_DATASOURCE_PASSWORD",
            "value": "SuperSecret"
        },
        {
            "environmentVariable": "SPRING_DATASOURCE_URL",
            "value": "jdbc:postgresql://localhost:5432/todoappdb"
        },
        {
            "environmentVariable": "IS_FORMAT_SQL",
            "value": "true"
        },
        {
            "environmentVariable": "IS_SHOW_SQL",
            "value": "true"
        },
        {
            "environmentVariable": "HOW_ANSI_OUTPUT_IS_ENABLED",
            "value": "ALWAYS"
        }
        
    ]
}

```

