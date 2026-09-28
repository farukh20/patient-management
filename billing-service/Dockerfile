FROM eclipse-temurin:25-jdk

WORKDIR /app

COPY target/billing-service-0.0.1-SNAPSHOT.jar app.jar

EXPOSE 4001
EXPOSE 9001

ENTRYPOINT ["java", "-jar", "app.jar"]