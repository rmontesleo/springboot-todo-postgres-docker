
### Build the container
```bash
docker build -t springboot-todo-postgres-container:01 .
```


### Startup all components without profile
```bash
docker-compose up -d
```

### Startup the backen profile (java api)
```bash
docker-compose --profile backend  up -d
```


```bash
export DOCKER_HUB_USER_NAME=<SET_YOUR_DOCKER_USER_NAME>
```

```bash
docker logout 
```

```bash
docker login 
```

```bash
docker tag springboot-todo-postgres-container:01   $DOCKER_HUB_USER_NAME/springboot-todo-postgres-container:01
```

