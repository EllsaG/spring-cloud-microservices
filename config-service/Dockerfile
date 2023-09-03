# base image with "alpine-linux" and "open JDK"
FROM openjdk:8-jdk-alpine
# open from container port 8001
EXPOSE 8001
# copy "jar" archive of the application from this location in the container
COPY build/libs/config-service-1.0-SNAPSHOT.jar .
# "run" command of the application in container
ENTRYPOINT ["java", "-jar", "config-service-1.0-SNAPSHOT.jar"]