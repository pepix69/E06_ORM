FROM eclipse-temurin:21-jdk
COPY target/orm-0.0.1-SNAPSHOT.jar app.jar
ENTRYPOINT ["java","-jar","/app.jar"]