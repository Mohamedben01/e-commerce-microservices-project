FROM eclipse-termurin:17
COPY target/*.jar bill-app.jar
EXPOSE 9092
ENTRYPOINT["java", "-jar", "/bill-app.jar"]