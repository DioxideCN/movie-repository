# Getting Started

### Reference Documentation

For further reference, please consider the following sections:

* [Official Gradle documentation](https://docs.gradle.org)
* [Spring Boot Gradle Plugin Reference Guide](https://docs.spring.io/spring-boot/docs/3.1.5/gradle-plugin/reference/html/)
* [Create an OCI image](https://docs.spring.io/spring-boot/docs/3.1.5/gradle-plugin/reference/html/#build-image)
* [Docker Compose Support](https://docs.spring.io/spring-boot/docs/3.1.5/reference/htmlsingle/index.html#features.docker-compose)
* [Spring Reactive Web](https://docs.spring.io/spring-boot/docs/3.1.5/reference/htmlsingle/index.html#web.reactive)
* [MyBatis Framework](https://mybatis.org/spring-boot-starter/mybatis-spring-boot-autoconfigure/)
* [Spring Data Reactive Redis](https://docs.spring.io/spring-boot/docs/3.1.5/reference/htmlsingle/index.html#data.nosql.redis)

### Guides

The following guides illustrate how to use some features concretely:

* [Building a Reactive RESTful Web Service](https://spring.io/guides/gs/reactive-rest-service/)
* [MyBatis Quick Start](https://github.com/mybatis/spring-boot-starter/wiki/Quick-Start)
* [Accessing data with MySQL](https://spring.io/guides/gs/accessing-data-mysql/)
* [Messaging with Redis](https://spring.io/guides/gs/messaging-redis/)

### Additional Links

These additional references should also help you:

* [Gradle Build Scans – insights for your project's build](https://scans.gradle.com#gradle)

### Docker Compose support

This project contains a Docker Compose file named `compose.yaml`.
In this file, the following services have been defined:

* mysql: [`mysql:latest`](https://hub.docker.com/_/mysql)
* redis: [`redis:latest`](https://hub.docker.com/_/redis)

Please review the tags of the used images and set them to the same as you're running in production.

