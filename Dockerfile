#
# Build stage
#
FROM maven:3.6.0-jdk-11-slim AS build
COPY src /home/app/src
COPY pom.xml /home/app
RUN mvn -f /home/app/pom.xml clean package

#
# Package stage
#
FROM openjdk:14-alpine
COPY --from=build /home/app/target/dev-0.0.1-SNAPSHOT.jar /app.jar
WORKDIR /
CMD ["java", "-jar", "app.jar"]