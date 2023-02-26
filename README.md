# People Management
Avaliação Desenvolvedor Back-end Attornatus

## Documentação do projeto
Este projeto implementa uma API REST para gerenciamento de pessoas e seus endereços.

### Tecnologias utilizadas
Java 17<br>
Spring Boot 3.0.2<br>
Banco de dados H2 (em memória)
### integrações
Viacep: https://viacep.com.br/ <br>
Swagger: http://localhost:8080/swagger-ui/index.html#/
### Endpoints da API
A API disponibiliza os seguintes endpoints:

#### Clientes
GET /clientes<br>
Retorna a lista de todas as pessoas cadastradas no sistema.<br>
Output Example:
```json
[
    {
        "id": 1,
        "nome": "João",
        "dataNascimento": "1990-01-01",
        "enderecos": [
            {
                "id": 1,
                "logradouro": "Rua A",
                "cep": "12345678",
                "numero": "10",
                "cidade": "São Paulo",
                "principal": true
            },
            {
                "id": 2,
                "logradouro": "Rua B",
                "cep": "12345678",
                "numero": "20",
                "cidade": "São Paulo",
                "principal": false
            }
        ]
    },
    {
        "id": 2,
        "nome": "Maria",
        "dataNascimento": "1980-01-01",
        "enderecos": [
            {
                "id": 3,
                "logradouro": "Rua C",
                "cep": "12345678",
                "numero": "30",
                "cidade": "Rio de Janeiro",
                "principal": true
            }
        ]
    }
]
```
GET /{id}<br>
Retorna os dados da pessoa com o ID informado.

Parâmetros
id: ID da pessoa a ser consultada.<br>
Output Example:
```json
{
    "id": 1,
    "nome": "João",
    "dataNascimento": "1990-01-01",
    "enderecos": [
        {
            "id": 1,
            "logradouro": "Rua A",
            "cep": "12345678",
            "numero": "10",
            "cidade": "São Paulo",
            "principal": true
        },
        {
            "id": 2,
            "logradouro": "Rua B",
            "cep": "12345678",
            "numero": "20",
            "cidade": "São Paulo",
            "principal": false
        }
    ]
}
```
POST /clientes
Cria uma nova pessoa no sistema.
<br>
Input Example:
```json
{
    "nome": "Fulano",
    "dataNascimento": "200000101",
    "endereco": [
    {
            "cep": "12345678",
            "numero": "20",
            "principal": true
		}
    ]
}
```
Output Example:
```json
{
    "id": 3,
    "nome": "Fulano",
    "dataNascimento": "2000-01-01",
    "enderecos": [{
			"id": 1,
			"logradouro": "Rua A",
			"principal": true,
			"numero": "20",
			"cep": "12345678",
			"cidade": "Florianópolis"
		}]
}
```
PUT /clientes/{id}
Atualiza os dados da pessoa com o ID informado.

Parâmetros
id: ID da pessoa a ser atualizada.<br>

Input Example:
```json
{
    "nome": "João Silva",
    "dataNascimento": "19900101"
}
```
Exemplo de resposta:<br>
Caso a pessoa com o ID informado exista, a API retorna os dados atualizados da pessoa em um objeto JSON. Caso contrário, a API retorna um status 404 (not found).<br>
Output Example:
```json
{
    "id": 1,
    "nome": "João Silva",
    "dataNascimento": "1990-01-01",
    "enderecos": [
        {
            "id": 1,
            "logradouro": "Rua A",
            "cep": "12345678",
            "numero": "10",
            "cidade": "São Paulo",
            "principal": true
        },
        {
            "id": 2,
            "logradouro": "Rua B",
            "cep": "12345678",
            "numero": "20",
            "cidade": "São Paulo",
            "principal": false
        }
    ]
}
```
### Enderecos
GET /enderecos/cep/{cep}
- consulta a api do cep <br>
Output Example:
```json
{
	"cep": "12345678",
	"logradouro": "Rua X",
	"uf": "SP",
	"localidade": "São Paulo"
}
```
POST /enderecos/cliente/{id} <br>
Input Example:
```json
{
	"cep": "02957050",
	"numero": "20",
	"principal": true
}
```
Output Example:
```json
{
	"id": 2,
	"logradouro": "Rua Rufino de Souza Lobato",
	"principal": true,
	"numero": "20",
	"cep": "02957050",
	"cidade": null
}
```
