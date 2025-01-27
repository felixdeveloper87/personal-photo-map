# Etapa de build
FROM maven:3.9.6-eclipse-temurin-21 AS build
WORKDIR /app

# Copia o arquivo pom.xml e a pasta src para o diretório de trabalho
COPY pom.xml .
COPY src ./src

# Compila o JAR pulando os testes
RUN mvn clean package -DskipTests

# Etapa de execução
FROM openjdk:21-jdk-slim
WORKDIR /app
COPY --from=build /app/target/*.jar app.jar

# Comando para executar o JAR
ENTRYPOINT ["java", "-jar", "app.jar"]
