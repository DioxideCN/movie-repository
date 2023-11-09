FROM openjdk:21-jre-slim

COPY target/springboot-0.0.1-SNAPSHOT.jar /app.jar

# 设置容器将在 8080 端口上监听
EXPOSE 8080

ENTRYPOINT ["java", "-jar", "/app.jar"]