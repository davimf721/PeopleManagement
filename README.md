# People Management
Avaliação Desenvolvedor Back-end Attornatus

## Documentação do projeto
Este projeto implementa uma API REST para gerenciamento de pessoas e seus endereços.

### Tecnologias utilizadas
Java 11<br>
Spring Boot 3.0.2<br>
Banco de dados H2 (em memória)
### Endpoints da API
A API disponibiliza os seguintes endpoints:

#### Clientes
GET /clientes<br>
Retorna a lista de todas as pessoas cadastradas no sistema.
Exemplo de resposta:
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
                "cep": "12345-678",
                "numero": "10",
                "cidade": "São Paulo",
                "principal": true
            },
            {
                "id": 2,
                "logradouro": "Rua B",
                "cep": "12345-678",
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
                "cep": "12345-678",
                "numero": "30",
                "cidade": "Rio de Janeiro",
                "principal": true
            }
        ]
    }
]
```
GET /clientes/{id}<br>
Retorna os dados da pessoa com o ID informado.

Parâmetros
id: ID da pessoa a ser consultada.
```json
{
    "id": 1,
    "nome": "João",
    "dataNascimento": "1990-01-01",
    "enderecos": [
        {
            "id": 1,
            "logradouro": "Rua A",
            "cep": "12345-678",
            "numero": "10",
            "cidade": "São Paulo",
            "principal": true
        },
        {
            "id": 2,
            "logradouro": "Rua B",
            "cep": "12345-678",
            "numero": "20",
            "cidade": "São Paulo",
            "principal": false
        }
    ]
}
```
POST /clientes
Cria uma nova pessoa no sistema.

Input:
```json
{
    "nome": "Fulano",
    "dataNascimento": "01012000",
    "endereco": [
    {
    "logradouro": "Rua B",
            "cep": "12345-678",
            "numero": "20",
            "cidade": "São Paulo",
            "principal": true
    }
    ]
}
```
PUT /clientes/{id}
Atualiza os dados da pessoa com o ID informado.

Parâmetros
id: ID da pessoa a ser atualizada.

Input:
```json
{
    "nome": "João Silva",
    "dataNascimento": "1990-01-01"
}
```
exemplo de resposta:<br>
Caso a pessoa com o ID informado exista, a API retorna os dados atualizados da pessoa em um objeto JSON. Caso contrário, a API retorna um status 404 (not found).
```json
{
    "id": 1,
    "nome": "João Silva",
    "dataNascimento": "1990-01-01",
    "enderecos": [
        {
            "id": 1,
            "logradouro": "Rua A",
            "cep": "12345-678",
            "numero": "10",
            "cidade": "São Paulo",
            "principal": true
        },
        {
            "id": 2,
            "logradouro": "Rua B",
            "cep": "12345-678",
            "numero": "20",
            "cidade": "São Paulo",
            "principal": false
        }
    ]
}
```
