# Stage 1 - the build process
FROM openjdk:8-jdk-alpine as build
WORKDIR /workspace/app

COPY gradlew .
COPY gradle gradle
COPY .gradle .gradle
COPY build.gradle .
COPY src src

RUN ./gradlew build
RUN mkdir -p build/libs/dependency && (cd build/libs/dependency; jar -xf ../*.jar)

# Stage 2 - the production environment
FROM openjdk:8-jdk-alpine
VOLUME /tmp
ARG DEPENDENCY=/workspace/app/build/libs/dependency
COPY --from=build ${DEPENDENCY}/BOOT-INF/lib /app/lib
COPY --from=build ${DEPENDENCY}/META-INF /app/META-INF
COPY --from=build ${DEPENDENCY}/BOOT-INF/classes /app
ENTRYPOINT ["java","-cp","app:app/lib/*","org.webapp.MailAppApplication", "-XX:+UnlockExperimentalVMOptions", "-XX:+UseCGroupMemoryLimitForHeap", "-Dspring.jmx.enabled=false"]
