FROM openjdk:8-jdk-alpine
ADD target/statistics.jar statistics.jar
EXPOSE 8085
VOLUME /tmp
ARG DEPENDENCY=target/dependency
COPY ${DEPENDENCY}/BOOT-INF/lib /app/lib
COPY ${DEPENDENCY}/META-INF /app/META-INF
COPY ${DEPENDENCY}/BOOT-INF/classes /app
ENTRYPOINT ["java", "-jar", "statistics.jar"]
