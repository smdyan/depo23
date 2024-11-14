docker compose --profile api --profile cli up -d --build

# depo23_srv
spring-boot app

Before run at local host export evarimenal variables to particular terminal process.
export $(cat .env | xargs)

Run at localhost in Docker containers
docker compose --profile api up -d --build

Run at localhost wo Docker. Need start DB first.
./mvnw spring-boot:run #maven-wrapper
mvn spring-boot:run #maven installed

# depo23_client

## Project setup
```
npm install
```

### Compiles and hot-reloads for development
```
npm run serve
```

### Compiles and minifies for production
```
npm run build
```

### Lints and fixes files
```
npm run lint
```

### Customize configuration
See [Configuration Reference](https://cli.vuejs.org/config/).