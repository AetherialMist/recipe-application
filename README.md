# Recipe App

## Development

* [Java 21](https://adoptium.net/)
* [Maven](https://maven.apache.org/download.cgi)
  * Windows: Ensure the bin folder is added to the system PATH environment variable.
* [Scene Builder](https://gluonhq.com/products/scene-builder/)

Loading this file in Intellij IDEA is recommended, as you will be able
to run these commands from the file editor.

```shell
# If dependencies are changed
mvn clean install package
```

```shell
# If dependencies have not changed
mvn clean package
```

```shell
# Run built application
java -jar .\target\recipe-app-1.0.0-SNAPSHOT.jar
```