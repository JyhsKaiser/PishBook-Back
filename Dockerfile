# ------------------------------------
# 1. FASE DE CONSTRUCCIÓN (Build Stage)
# Se usa un JDK para compilar el código
# ------------------------------------
FROM maven:3.8.7-eclipse-temurin-17 AS build
WORKDIR /app

# Copia los archivos de configuración de Maven (pom.xml) para descargar dependencias
COPY pom.xml .
RUN mvn dependency:go-offline

# Copia el resto del código y compila
COPY src ./src
RUN mvn package -DskipTests

# ------------------------------------
# 2. FASE FINAL (Runtime Stage)
# Se usa un JRE (más ligero) para ejecutar el JAR compilado
# ------------------------------------
# Usas una imagen JRE Alpine, lo cual ya estás haciendo:
FROM docker.io/library/eclipse-temurin:17-jre-alpine
# NOTA: Mejor usar la versión JRE si solo vas a ejecutar,
# ej: FROM eclipse-temurin:17-jre-alpine
WORKDIR /app

# Copia el JAR compilado desde la fase 'build'
COPY --from=build /app/target/*.jar app.jar

# Comando para ejecutar la aplicación
ENTRYPOINT ["java","-jar","/app/app.jar"]