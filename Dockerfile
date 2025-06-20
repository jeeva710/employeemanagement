FROM eclipse-temurin:21-jdk

VOLUME /tmp

ARG JAVA_OPTS
ENV JAVA_OPTS=$JAVA_OPTS

# Copy the application JAR
COPY target/employeemanagement-0.0.1-SNAPSHOT.jar javaprojects.jar

# Copy the wait-for-it.sh script into the container
COPY wait-for-it.sh /wait-for-it.sh
RUN chmod +x /wait-for-it.sh

EXPOSE 8070

# Wait for the database before starting the app
ENTRYPOINT ["/wait-for-it.sh", "db:5432", "--", "java", "-jar", "/javaprojects.jar"]
