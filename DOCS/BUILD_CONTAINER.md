# Build containers with jib


### Prepare the settings.xml file

```bash
vim   ~/.m2/settings.xml
```

### The content must be

```xml
<settings xmlns="http://maven.apache.org/SETTINGS/1.0.0" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
  xsi:schemaLocation="http://maven.apache.org/SETTINGS/1.0.0 https://maven.apache.org/xsd/settings-1.0.0.xsd">
    <localRepository/>
    <servers>
        <server>
            <id>registry.hub.docker.com</id>
            <username>CHANGE_ME_BY_YOUR_DOCKER_HUB_USERNAME></username>
            <password>CHANGE_ME_BY_YOUR_DOCKER_HUB_PASSWORD></password>
        </server>
    </servers>
</settings>
```

### Set the plugin on pom.xml file

```xml
<plugin>
    <groupId>com.google.cloud.tools</groupId>
    <artifactId>jib-maven-plugin</artifactId>
    <version>3.2.1</version>
    <configuration>
        <to>
            <image>registry.hub.docker.com/SET_DOCKER_USER_NAME/SET_IMAGE_NAME</image>
        </to>
    </configuration>
</plugin>
```

### Execute the command from maven
```bash
mvn clean compile jib:build
```



