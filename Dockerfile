FROM eclipse-temurin:17-jdk

WORKDIR /app

COPY . .

RUN chmod +x build.sh start.sh

RUN ./build.sh

EXPOSE 8080

CMD ["./start.sh"]
