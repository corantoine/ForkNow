FROM openjdk:17-slim AS builder

WORKDIR /app

COPY . .

RUN ls -lia && chmod +x ./gradlew \
&& ./gradlew bootjar

FROM openjdk:17-slim

WORKDIR /app

COPY --from=builder /app/build/libs/*.jar /app

CMD ["java", "-jar", "/app/spring-security-0.0.1-SNAPSHOT.jar"]

# Lancer un 2eme conteneur (à la main ou avec docker compose)