# build stage
FROM adityai/jdk13
WORKDIR /app
COPY . .
RUN yum install -y graphviz
EXPOSE 8888
ENTRYPOINT ["java","-jar","/app/target/graphx-0.0.1-SNAPSHOT.jar"]