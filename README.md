<h1 align="center">
  UOL HOST - Desafio BackEnd Java
</h1>

Este projeto é uma implementação do desafio proposto pela [UOL HOST](https://github.com/uolhost/test-backEnd-Java) para o teste de BackEnd em Java. O objetivo foi desenvolver um sistema capaz de cadastrar jogadores com codinomes associados às listas "Os Vingadores" e "A Liga da Justiça". A aplicação permite a persistência dos dados em um banco de dados em memória (como H2Databse).

## Tecnologias

- [Spring Boot](https://spring.io/projects/spring-boot)
- [Spring Data JPA](https://spring.io/projects/spring-data-jpa)
- [Lombok](https://projectlombok.org/)
- [H2Database](https://h2database.com/html/main.html)

## Como Executar

- Clonar repositório git
- Construir o projeto:

```
$ ./mvnw clean package
```

- Executar a aplicação:

```
$ java -jar target/gestao_vagas-0.0.1-SNAPSHOT.jar
```

A API poderá ser acessada em [localhost:8080](http://localhost:8080).

## API Endpoints

Para fazer as requisições HTTP abaixo, foi utilizada a ferramenta [httpie](https://httpie.io):

- Criar Player

```
$ http POST :8080/players name="Sergio" email="sergio@teste.com" phoneNumber="123134-42424" groupType="JUSTICE_LEAGUE"

[
  {
	"id": 1,
	"name": "Sergio",
	"email": "sergio@teste.com",
	"phoneNumber": "123134-42424",
	"codiname": "Lanterna Verde",
	"groupType": "JUSTICE_LEAGUE"
 }
]
```

- Listar Players

```
$ http GET :8080/players

[
	{
		"id": 1,
		"name": "Sergio",
		"email": "sergio@teste.com",
		"phoneNumber": "123134-42424",
		"codiname": "Lanterna Verde",
		"groupType": "JUSTICE_LEAGUE"
	},
	{
		"id": 2,
		"name": "Sergio",
		"email": "sergio@teste.com",
		"phoneNumber": "123134-42424",
		"codiname": "Flash",
		"groupType": "JUSTICE_LEAGUE"
	}
]
```
