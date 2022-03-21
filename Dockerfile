FROM maven:3.6.3-openjdk-11-slim AS build
WORKDIR /build
# copy just pom.xml (dependencies and dowload them all for offline access later - cache layer)
COPY pom.xml .
RUN mvn dependency:go-offline -B
# copy source files and compile them (.dockerignore should handle what to copy)
COPY . .
RUN mvn package -Dmaven.test.skip=true
# Explode fat runnable JARS
ARG DEPENDENCY=/build/target
# RUN mkdir -p ${DEPENDENCY} && (cd ${DEPENDENCY}; jar -xf ../*.jar)


# Runnable image
FROM openjdk:11.0.9.1-jre-slim as runnable
# VOLUME /tmp
# VOLUME /logs
ARG DEPENDENCY=/build/target
ARG JAVA_HOME=/usr/local/openjdk-11
# Create User&Group to not run docker images with root user
COPY postgres.crt /root/.postgresql/root.crt

# # Copy libraries & meta-info & classes
COPY --from=build ${DEPENDENCY} /app/lib
WORKDIR /app/lib
# COPY --from=build ${DEPENDENCY}/META-INF /app/META-INF
# COPY --from=build ${DEPENDENCY}/BOOT-INF/classes /app
# Run application
EXPOSE  8080
ENTRYPOINT ["java","-jar","cust-plan-1.0.jar"]


# # For Java 11, try this
#  FROM store/oracle/jdk:11

# COPY ./ /opt/app
# # cd /opt/app
# WORKDIR /opt/app
# CMD mvn package
# WORKDIR /target

# # cp target/spring-boot-web.jar /opt/app/app.jar
# WORKDIR /opt/app/target

# # java -jar /opt/app/app.jar
# ENTRYPOINT ["java","-jar","eCommerce-1.0.jar"]