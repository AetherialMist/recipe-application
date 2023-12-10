# Recipe App

## Development

* [Java 21](https://adoptium.net/)
* [Maven](https://maven.apache.org/download.cgi)
  * Windows: Ensure the bin folder is added to the system PATH environment variable.
* [Scene Builder](https://gluonhq.com/products/scene-builder/)

### Intellij IDEA

1. Run `SpringRunner`

### Command Line

Loading this file in Intellij IDEA is recommended, as you will be able
to run these commands from the file editor.

Windows users: Do not use PowerShell. Use CMD or Git Bash instead.

```shell
# If dependencies are changed
mvn clean install package && java -jar ./target/recipe-app-1.0.0-SNAPSHOT.jar
```

```shell
# If dependencies have not changed
mvn clean package && java -jar ./target/recipe-app-1.0.0-SNAPSHOT.jar
```