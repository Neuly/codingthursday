# cheat sheet

Das ist ein Schummelzettel für mich als Vortragenden. Vertrauen, dass man alles hinbekommt ist gut, ein Backup ist immer gut zu haben.

## Run the Spring Boot application

 mvn clean spring-boot:run

## fabric8 commands


 mvn io.fabric8:fabric8-maven-plugin:3.1.32:setup

 mvn clean install -Dfabric8.mode=openshift

 mvn fabric8:deploy -Dfabric8.mode=openshift


## deploying OpenShift using Docker File from Folder

oc new-build --strategy docker --binary --name temperature2

oc start-build temperature2 --from-dir . --follow

oc new-app temperature2

oc expose temperature2

oc get route temperature2
