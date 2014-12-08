### To get up and running with Eclipse, including source
```
mvn dependency:sources
mvn dependency:resolve -Dclassifier=javadoc
mvn eclipse:eclipse
```

### Because there is always that difficult little project with no Maven repo:
```
mvn install:install-file -Dfile=<path-to-file> -DgroupId=<domain-name> -DartifactId=<name> -Dversion=<version-number> -Dpackaging=jar
```

### Build
```
mvn package
```
