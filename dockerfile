# build stage
FROM adityai/jdk13
WORKDIR /app
COPY . .
COPY simfang.ttf /usr/share/fonts/
RUN fc-cache -vf
RUN yum install -y graphviz
EXPOSE 8888
ENTRYPOINT ["java","-jar","/app/target/graphx-0.0.1-SNAPSHOT.jar"]