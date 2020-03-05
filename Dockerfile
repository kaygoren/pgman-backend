FROM openjdk:8
EXPOSE 8080
ADD target/pgman-backend.jar pgman-backend.jar
ENTRYPOINT ["java", "-jar" , "/pgman-backend.jar"]