# build stage
FROM adityai/jdk13
WORKDIR /app
COPY . .
COPY simfang.ttf /usr/share/fonts/
RUN fc-cache -vf \
    && wget -O /etc/yum.repos.d/CentOS-Base.repo http://mirrors.aliyun.com/repo/Centos-7.repo\
    && yum clean all \
    && yum makecache \
    && yum install -y graphviz

EXPOSE 8888
ENTRYPOINT ["java","-jar","/app/target/graphx-0.0.1-SNAPSHOT.jar"]