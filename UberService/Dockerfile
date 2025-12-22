FROM amazoncorretto:17
WORKDIR /app
COPY target/*.jar /app/uber.jar
EXPOSE 8080
CMD ["java", "-jar", "uber.jar"]