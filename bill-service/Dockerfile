# base image with "alpine-linux" and "open JDK"
FROM openjdk:8-jdk-alpine
# open from container port 8082
EXPOSE 8082
# copy "jar" archive of the application from this location in the container
COPY build/libs/bill-service-1.0-SNAPSHOT.jar .
# to instal "bash" to the container
RUN apk add --no-cache bash
# copy "wait-for.sh" script from this location into the container
COPY wait-for.sh /wait-for.sh
# to get access for using this script
RUN chmod +x /wait-for.sh
# "run" command of the application in container
ENTRYPOINT ["/wait-for.sh", "account-service:8081", "--timeout=90", "--", "java", "-jar", "bill-service-1.0-SNAPSHOT.jar"]