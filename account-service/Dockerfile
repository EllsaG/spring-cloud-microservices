# base image with "alpine-linux" and "open JDK"
FROM openjdk:8-jdk-alpine
# open from container port 8081
EXPOSE 8081
# copy "jar" archive of the application from this location into the container
COPY build/libs/account-service-1.0-SNAPSHOT.jar .
# to instal "bash" to the container
RUN apk add --no-cache bash
# copy "wait-for.sh" script from this location into the container
COPY wait-for.sh /wait-for.sh
# to get access for using this script
RUN chmod +x /wait-for.sh
# "run" command of the application in container
ENTRYPOINT ["/wait-for.sh", "gateway:8989", "--timeout=70", "--", "java", "-jar", "account-service-1.0-SNAPSHOT.jar"]