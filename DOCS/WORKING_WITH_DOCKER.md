

### docker-compose.override.yaml
```yaml
version: '3.7'

services:

  db:    
    volumes:
      - ./scripts/init.sql:/docker-entrypoint-initdb.d/init.sql
      - springboot-todo-postgres-docker-db-volume:/var/lib/posgresql/data    
    healthcheck:
      test: [ "CMD", "pg_isready", "-q", "-d", "todoappdb", "-U", "postgres_user" ]
    env_file:
      - .env_container
    environment:
      - SOME_VAR=SOME_VALUE  

  pgadmin:  
    volumes:
      - springboot-todo-postgres-docker-pgadmin-volume:/var/lib/pgadmin
    env_file:
      - .env_container
    environment:
      - SOME_VAR=SOME_VALUE
     

  api:    
    build:
      context: .
      target: development
    profiles: [ "backend" ]    
    depends_on:
      db:
        condition: service_healthy
    env_file:
      - .env_container
    environment:
      - SOME_VAR=SOME_VALUE
    volumes:
      - .:/app
    command: sh mvnw spring-boot:run  

```