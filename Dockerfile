FROM openjdk:11-jre-slim
VOLUME /tmp
COPY target/blog-service.jar app.jar
ENTRYPOINT ["java","-jar","/blogapp.jar"]
