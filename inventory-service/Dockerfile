FROM eclipse-termurin:17
COPY target/*.jar inventory-app.jar
EXPOSE 9091
ENTRYPOINT["java", "-jar", "/inventory-app.jar"]