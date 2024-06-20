FROM gradle:jdk21-alpine AS build
WORKDIR /app

COPY .gradle .gradle
COPY build.gradle .
COPY settings.gradle .
RUN gradle clean

COPY src src

RUN gradle assemble

FROM eclipse-temurin:21-jre-alpine as final
WORKDIR /app

COPY --from=build /app/build/libs/*.jar /app/app.jar
EXPOSE 8761
ENTRYPOINT [ "java", "-jar", "/app/app.jar" ]
