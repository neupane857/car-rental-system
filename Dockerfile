# -------- Stage 1: Build --------
FROM gradle:8.5-jdk17 AS build
WORKDIR /app
COPY . .
RUN gradle clean shadowJar -x test


# -------- Stage 2: Run --------
FROM eclipse-temurin:17-jre
WORKDIR /app
COPY --from=build /app/build/libs/*-all.jar app.jar
ENTRYPOINT ["java", "-jar", "/app/app.jar"]
