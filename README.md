# README da Aplicação CRUD

Este é um projeto de exemplo para demonstrar uma aplicação CRUD (Criar, Ler, Atualizar, Excluir) simples usando Spring Boot, Spring Data JPA e banco de dados em memória H2.

## Configuração do Projeto

Certifique-se de ter configurado seu ambiente de desenvolvimento Java e Spring Boot. Se ainda não o fez, você pode seguir as instruções na [documentação oficial do Spring Boot](https://spring.io/guides/gs/spring-boot/) para configurar seu ambiente.

## Configuração do Banco de Dados

O projeto utiliza um banco de dados em memória H2 para simplificar a configuração. O arquivo `src/main/resources/application.properties` contém as configurações do banco de dados.

## Funcionalidades CRUD

O projeto inclui as seguintes funcionalidades CRUD:

### 1. Adicionar Pessoa

- **Método:** `POST`
- **Endpoint:** `/persons`
- **Payload:** JSON com campos `name` e `department`
- **Exemplo de Payload:**
  ```json
  {
    "name": "Alice",
    "department": "Departamento A"
  }
  
### 2. Listar Pessoas

- **Método:** `GET`
- **Endpoint:** `/persons`

### 3. Adicionar Tarefa

- **Método:** `POST`
- **Endpoint:** `/tasks`
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
- **Endpoint:** `/tasks`

### 5. Alocar Tarefa para Pessoa

- **Método:** `PUT`
- **Endpoint:** `/tasks/{idTarefa}/alocar/{idPessoa}`
- **Exemplo de Endpoint:** `/tasks/1/alocar/2`

### 6. Finalizar Tarefa

- **Método:** `PUT`
- **Endpoint:** `/tasks/{idTarefa}/finalizar`
- **Exemplo de Endpoint:** `/tasks/1/finalizar`

### 7. Listar Tarefas Mais Antigas Não Alocadas

- **Método:** `GET`
- **Endpoint:** `/tasks/pendentes?limite=3`
- **Exemplo de Endpoint:** `/tasks/pendentes?limite=3`

### 8. Listar Resumos de Departamentos

- **Método:** `GET`
- **Endpoint:** `/departamentos`

## Executando o Projeto

1. Clone o repositório para sua máquina local.
2. Abra o projeto em seu IDE (por exemplo, IntelliJ IDEA ou Eclipse).
3. Execute a classe `MatheusApplication` para iniciar a aplicação Spring Boot.
4. Utilize ferramentas como Postman ou cURL para testar as funcionalidades do CRUD.

