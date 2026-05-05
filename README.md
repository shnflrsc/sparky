# 🐶 Sparky
Sparky is a simple API that gives dogs with random name, breed, and age. It is the first API project I made using Spring Boot and containerized using docker.
# ⭐ Features
- Request random dogs through `/dogs`, or individual attributes with `/names` or `/breeds`
- Request multiple entries through respective subroutes with number `/dogs/5`
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
Configure by creating a `.env` file in the root of the project directory. Here is an example of a `.env` file:
```.env
DB_NAME=sparky
DB_ROOT_PASSWORD=mysql
DB_USERNAME=user
DB_PASSWORD=password
HOST_DB_PORT=3307
HOST_APP_PORT=8080
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
