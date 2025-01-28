# Etapa 1: Construcción de la aplicación con Maven y Java 17
FROM maven:3.8.7-eclipse-temurin-17-alpine AS build

# Establecer el directorio de trabajo en el contenedor
WORKDIR /app

# Copiar archivos necesarios para aprovechar la caché de Maven
COPY pom.xml .
RUN mvn dependency:go-offline

# Copiar el código fuente y compilar la aplicación
COPY src ./src
RUN mvn clean package -DskipTests

# Etapa 2: Imagen final con JDK 17 en Alpine
FROM eclipse-temurin:17-jdk-alpine

# Crear un usuario no root por seguridad
RUN addgroup -S appgroup && adduser -S appuser -G appgroup
USER appuser

# Establecer el directorio de trabajo
WORKDIR /app

# Copiar el jar desde la fase anterior
COPY --from=build /app/target/*.jar app.jar

# Exponer el puerto 8080
EXPOSE 8085

# Comando para ejecutar la aplicación
CMD ["java", "-jar", "app.jar"]
