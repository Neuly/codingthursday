# cheat sheet

Das ist ein Schummelzettel für mich als Vortragenden. Vertrauen, dass man alles hinbekommt ist gut, ein Backup ist immer gut zu haben.

## Run the Spring Boot application
```mvn clean spring-boot:run

## setup fabric8
mvn io.fabric8:fabric8-maven-plugin:3.1.32:setup

mvn clean install -Dfabric8.mode=openshift

mvn fabric8:deploy -Dfabric8.mode=openshift

