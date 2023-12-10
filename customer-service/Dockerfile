FROM eclipse-termurin:17
COPY target/*.jar customer-app.jar
EXPOSE 9090
ENTRYPOINT["java", "-jar", "/customer-app.jar"]