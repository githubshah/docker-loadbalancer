FROM amazoncorretto:17
WORKDIR /app
COPY target/*.jar /app/map.jar
EXPOSE 8081
CMD ["java", "-jar", "map.jar"]