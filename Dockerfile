FROM openjdk:8-jdk-alpine
EXPOSE 8080
ADD /build/libs/oslo-polygon-0.0.1-SNAPSHOT.jar oslo-polygon.jar
ENTRYPOINT ["java", "-jar", "oslo-polygon.jar"]

