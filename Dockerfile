# ---- STAGE 1: Custom Build Stage ----
FROM eclipse-temurin:25-jdk AS build
RUN apt-get update && apt-get install -y maven
WORKDIR /app
COPY . .
RUN mvn clean package -DskipTests

# ---- STAGE 2: Run ----
FROM eclipse-temurin:25-jre
WORKDIR /app
COPY --from=build /app/target/*.jar app.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "app.jar"]