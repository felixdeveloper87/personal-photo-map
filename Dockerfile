# Etapa de build
FROM maven:3.9.6-eclipse-temurin-21 AS build
WORKDIR /app

# Ajuste os caminhos para o contexto do Backend
COPY Backend/photo-map/pom.xml . 
COPY Backend/photo-map/src ./src

# Compila o JAR pulando os testes
RUN mvn clean package -DskipTests

# Etapa de execução
FROM openjdk:21-jdk-slim
WORKDIR /app
COPY --from=build /app/target/*.jar app.jar

# Comando para executar o JAR
ENTRYPOINT ["java", "-jar", "app.jar"]
