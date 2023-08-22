# Teste técnico API

Essa é uma API SpringBoot solicitada no teste técnico.

## Configuração do Projeto

Certifique-se de ter configurado seu ambiente de desenvolvimento Java e Spring Boot. Se ainda não o fez, você pode seguir as instruções na [documentação oficial do Spring Boot](https://spring.io/guides/gs/spring-boot/) para configurar seu ambiente.

## Configuração do Banco de Dados

O projeto utiliza um banco de dados em memória H2 para simplificar a configuração. O arquivo `src/main/resources/application.properties` contém as configurações do banco de dados.

Também deixei comentado no arquivo application.properties a configuração do banco caso queira usar o PostgreSQL, utilizei o H2 por facilitar o desenvolvimento.

## Funcionalidades CRUD

O projeto inclui as seguintes funcionalidades CRUD:

### 1. Adicionar Pessoa

- **Método:** `POST`
- **Endpoint:** `/pessoas`
- **Payload:** JSON com campos `name` e `department`
- **Exemplo de Payload:**
  ```json
  {
    "name": "Alice",
    "department": "Departamento A"
  }
  
### 2. Listar Pessoas

- **Método:** `GET`
- **Endpoint:** `/pessoas`

### 3. Adicionar Tarefa

- **Método:** `POST`
- **Endpoint:** `/tarefas`
- **Payload:** JSON com campos `title`, `description`, `deadline`, `department` e `allocatedPersonId`
- **Exemplo de Payload:**
  ```json
  {
    "title": "Tarefa 1",
    "description": "Descrição para Tarefa 1",
    "deadline": "2023-09-01",
    "department": "Departamento A",
    "allocatedPersonId": 1
  }


### 4. Listar Tarefas

- **Método:** `GET`
- **Endpoint:** `/tarefas`

### 5. Alocar Tarefa para Pessoa

- **Método:** `PUT`
- **Endpoint:** `/tarefas/alocar/{id}`
- **Exemplo de Endpoint:** `/tarefas/alocar/1`

### 6. Finalizar Tarefa

- **Método:** `PUT`
- **Endpoint:** `/tarefas/finalizar/id`
- **Exemplo de Endpoint:** `/tasks/finalizar/{id}`

### 7. Listar Tarefas Mais Antigas Não Alocadas

- **Método:** `GET`
- **Endpoint:** `/tarefas/pendentes?limite=3`
- **Exemplo de Endpoint:** `/tarefas/pendentes?limite=3`

### 8. Listar Resumos de Departamentos

- **Método:** `GET`
- **Endpoint:** `/departamentos`

### 9. Buscar pessoas por nome e período, retornando a média gasta por tarefa

- **Method:** `GET`
- **Endpoint:** `/gastos`
- **Query Parameters:**
  - `nome` (required): O nome da pessoa para a qual você deseja obter os gastos.
  - `dataInicio` (required): A data de início do período para calcular os gastos (formato ISO 8601).
  - `dataFim` (required): A data de término do período para calcular os gastos (formato ISO 8601).
- **Response:** Uma lista de objetos JSON contendo informações sobre os gastos das pessoas no período especificado.
- **Example Endpoint:** `/gastos?nome=Alice&dataInicio=2023-01-01&dataFim=2023-12-31`

```json
[
  {
    "name": "Alice",
    "totalExpenses": 250.0
  },
  {
    "name": "Carol",
    "totalExpenses": 150.0
  }
]
```

## Executando o Projeto

1. Clone o repositório para sua máquina local.
2. Abra o projeto em seu IDE (por exemplo, IntelliJ IDEA ou Eclipse).
3. Execute a classe `MatheusApplication` para iniciar a aplicação Spring Boot.
4. Utilize ferramentas como Postman ou cURL para testar as funcionalidades do CRUD.
