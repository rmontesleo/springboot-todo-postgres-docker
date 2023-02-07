# Name this image like  springboot-todo-postgres-docker

FROM eclipse-temurin:17-jdk-alpine as base

ENV  POSTGRES_USER=postgres_user
ENV POSTGRES_PASSWORD=SuperSecret
ENV POSTGRES_DB=todoappdb

## Variables for the pgadmin
ENV PGADMIN_DEFAULT_EMAIL=user@domain.com
ENV PGADMIN_DEFAULT_PASSWORD=SuperSecret

## Variables for api in container
#ENV TODO_API_VERSION=0.1
ENV APPLICATION_PORT=8080
ENV SPRING_DATASOURCE_USERNAME=postgres_user
ENV SPRING_DATASOURCE_PASSWORD=SuperSecret
ENV SPRING_DATASOURCE_URL=jdbc:postgresql://localhost:5432/todoappdb
ENV IS_FORMAT_SQL=true
ENV IS_SHOW_SQL=true
ENV HOW_ANSI_OUTPUT_IS_ENABLED=ALWAYS

WORKDIR /app
COPY .mvn/ .mvn
COPY mvnw pom.xml ./
RUN ./mvnw dependency:resolve
COPY src ./src



FROM base as test
CMD ["./mvnw", "test"]

FROM base as development
CMD ["./mvnw", "spring-boot:run"]


FROM base as build
RUN ./mvnw package

FROM eclipse-temurin:17-jre-alpine as production
RUN addgroup -S spring && adduser -S spring -G spring
USER spring:spring
EXPOSE 8080
COPY --from=build /app/target/springboot-todo-postgres-docker.jar /springboot-todo-postgres-docker.jar
ENTRYPOINT [ "java", "-jar", "springboot-todo-postgres-docker.jar" ]

