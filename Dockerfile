FROM openjdk:18
EXPOSE 8080
ADD target/springboot-image-user-backend.jar springboot-image-user-backend.jar
ENTRYPOINT ["java", "-jar", "/springboot-image-user-backend.jar"]