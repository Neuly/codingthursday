#/bin/sh
# prepare for openshift
cd ..
mvn compile
cp -v target/temperature-*-SNAPSHOT.jar openshift/app.jar

#cp -vr src/main/resources/zipCodes openshift/zipCodes
