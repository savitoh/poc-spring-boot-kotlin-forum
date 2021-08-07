# poc-spring-boot-kotlin-forum

Aplicação para estudar desenvolvimento de APIs REST com Kotlin e Spring Boot.

## Rodando Aplicação

Em Construção

Para rodar a aplicação localmente recomandamos o usor do [Docker](https://www.docker.com/).

1. Banco de dados: 
Rode o comando abaixo para subir uma container do [PostgresSQL](https://www.postgresql.org/)
```
docker run -p 5432:5432 --name postgres -e POSTGRES_PASSWORD=root -d postgres:11-alpine
```
Após precisará criar o bando de dados: forumdb

2. Aplicação: 

