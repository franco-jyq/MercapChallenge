FROM openjdk:8-jdk AS build

WORKDIR /app
COPY src ./src

RUN javac -d . src/**/*.java

FROM openjdk:8-jre-slim

COPY --from=build /app/ .

CMD ["java", "-cp", ".", "service.Main"]