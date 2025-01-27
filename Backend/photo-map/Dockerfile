# Estágio de build (opcional, mas recomendado para builds consistentes)
FROM maven:3.9.6-eclipse-temurin-21 AS build
WORKDIR /app
COPY pom.xml .
COPY src ./src
# Compila o JAR pulando os testes (evita dependência do banco durante o build)
RUN mvn clean package -DskipTests

# Estágio de execução
FROM openjdk:21-jdk-slim
WORKDIR /app

# Copia o JAR do estágio de build
COPY --from=build /app/target/photo-map-*.jar app.jar

# Expõe a porta
EXPOSE 8092

# Comando de execução (não precisa do application.properties externo se estiver no classpath)
ENTRYPOINT ["java", "-jar", "app.jar"]