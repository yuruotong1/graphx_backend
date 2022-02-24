# build stage
FROM adityai/jdk13
WORKDIR /app
COPY . .
RUN mvn clean package\
    && sudo apt-get update --fix-missing \
    && sudo apt-get install -y graphviz

ENTRYPOINT ["java","-jar","/app/target/graphx-0.0.1-SNAPSHOT.jar"]