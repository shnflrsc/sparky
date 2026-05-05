# 🐶 Sparky
Sparky is a simple API that gives dogs with random name, breed, and age. It is the first API project I made using Spring Boot and containerized using docker.
# ⭐ Features
- Request random dogs through `/dogs`, or individual attributes with `names` or `/breeds`
- Request multiple entries through respective subroutes with how many `/dogs/5`
- Rate limited to 60 requests per minute using bucket4j
- Data stored in a MySQL database
- Containerized with Dockerfile and with docker-compose.yml 🐋
# ⚙️ Stack
- Temurin JDK 25
- Spring Boot 4.0.6
- Bucket4j
- MySQL
- Docker
# 🔨 Configure
```yaml
services:
  db:
    image: mysql:8.4
    container_name: sparky-db
    restart: always
    environment:
      MYSQL_DATABASE: sparky
      MYSQL_ROOT_PASSWORD: mysql # configure mysql root password
      MYSQL_USER: user # configure user name
      MYSQL_PASSWORD: password # configure user password
    volumes:
      - ./init.sql:/docker-entrypoint-initdb.d/init.sql:ro
      - db_data:/var/lib/mysql
    ports:
      - "3307:3306" # configure which port the database will run

  app:
    build: .
    container_name: sparky-api
    restart: on-failure
    depends_on:
      - db
    environment:
      SPRING_DATASOURCE_URL: jdbc:mysql://db:3306/sparky?allowPublicKeyRetrieval=true&useSSL=false
      SPRING_DATASOURCE_USERNAME: user
      SPRING_DATASOURCE_PASSWORD: password
    ports:
      - "8080:8080" # configure which port spring boot will run

volumes:
  db_data:
```
# 🚀 Build
1. Clone the repository
```bash
git clone https://github.com/shnflrsc/sparky.git && cd sparky
```
2. Build JAR
```bash
./gradlew bootJar
```
3. Build image and run
```bash
docker-compose up --build
```
