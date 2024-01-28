# Use a imagem oficial do OpenJDK para Java 11
FROM openjdk:11-jre-slim

# Crie um diretório para a aplicação
WORKDIR /app

# Copie o JAR da aplicação para o diretório de trabalho no contêiner
COPY target/restaurante-0.0.1-SNAPSHOT.jar /app/app.jar

# Exponha a porta em que a aplicação Spring Boot está configurada para ouvir
EXPOSE 8080

# Comando para executar a aplicação quando o contêiner for iniciado
CMD ["java", "-jar", "app.jar"]
