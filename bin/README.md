# API de Gestão de Centro Académico

Este projeto é uma API RESTful desenvolvida com **Spring Boot** para gerir o registo de alunos, disciplinas e as suas respetivas matrículas. A aplicação utiliza uma base de dados **SQLite** para persistência dos dados e inclui documentação via **Swagger/OpenAPI**.

## 🛠️ Tecnologias Utilizadas

O projeto foi construído utilizando as seguintes tecnologias e bibliotecas, conforme definido no `pom.xml`:

  * **Java 17**: Linguagem de programação.
  * **Spring Boot 3.5.7**: Framework principal.
  * **Spring Data JPA**: Para persistência de dados e ORM.
  * **SQLite**: Base de dados relacional (ficheiro local `meu_banco_de_dados.db`).
  * **Hibernate**: Implementação de JPA.
  * **SpringDoc OpenAPI (Swagger)**: Para documentação automática da API.
  * **Maven**: Gestor de dependências e build.

## 🚀 Como Executar o Projeto

### Pré-requisitos

  * Java JDK 17 instalado.
  * Git (opcional, para clonar o repositório).

### Passos para execução

1.  **Clone o repositório** (ou extraia os ficheiros):

    ```bash
    git clone <url-do-repositorio>
    cd centro_academico_api
    ```

2.  **Execute a aplicação** utilizando o Wrapper do Maven incluído:

      * **Windows**:
        ```cmd
        mvnw.cmd spring-boot:run
        ```
      * **Linux/macOS**:
        ```bash
        ./mvnw spring-boot:run
        ```

3.  A aplicação iniciará na porta padrão `8080`.

## 📚 Documentação da API (Swagger)

A aplicação possui o **SpringDoc OpenAPI** configurado. Após iniciar a aplicação, pode aceder à interface interativa do Swagger para testar os endpoints diretamente no navegador:

  * **URL do Swagger UI:** `http://localhost:8080/swagger-ui/index.html` (ou `http://localhost:8080/swagger-ui.html`)
  * **Definição JSON:** `http://localhost:8080/v3/api-docs`

> **Nota:** A documentação da API está configurada com o título "API de Clientes" na classe principal `ListaApiExercicio2Application.java`.

## 🔌 Endpoints Principais

Abaixo estão listados os principais endpoints disponíveis, baseados nos controladores do projeto (`AlunoController`, `DisciplinaController`, `MatriculaController`).

### 🧑‍🎓 Alunos (`/alunos`)

  * **Listar todos:** `GET /alunos`
  * **Criar aluno:** `POST /alunos`
      * *Body (JSON):*
        ```json
        {
          "nome": "João Silva",
          "ra": "2023001"
        }
        ```

### 📚 Disciplinas (`/disciplinas`)

  * **Listar todas:** `GET /disciplinas`
  * **Buscar por ID:** `GET /disciplinas/{id}`
  * **Criar disciplina:** `POST /disciplinas`
      * *Body (JSON):*
        ```json
        {
          "nome": "Cálculo I",
          "professor": "Dr. Almeida",
          "semestre": 1
        }
        ```

### 📝 Matrículas (`/matriculas`)

Este controlador gere a associação entre alunos e disciplinas, bem como notas e faltas.

  * **Listar todas:** `GET /matriculas`
  * **Realizar Matrícula:** `POST /matriculas`
      * *Nota:* Este endpoint utiliza **Query Parameters** e não um corpo JSON.
      * *Exemplo:* `POST /matriculas?idAluno=1&idDisciplina=2`
  * **Lançar Nota:** `PUT /matriculas/{id}/nota`
      * *Exemplo:* `PUT /matriculas/1/nota?nota=15.5`
  * **Lançar Faltas:** `PUT /matriculas/{id}/faltas`
      * *Exemplo:* `PUT /matriculas/1/faltas?faltas=2`

## 🗄️ Configuração da Base de Dados

A aplicação está configurada para usar **SQLite**.

  * Ficheiro da base de dados: `meu_banco_de_dados.db` (localizado na raiz do projeto).
  * A propriedade `spring.jpa.hibernate.ddl-auto=update` está ativa, o que significa que o Hibernate atualizará automaticamente o esquema da base de dados se houver alterações nos modelos.

## 🧪 Testes

Para executar os testes unitários (se disponíveis na pasta `src/test`):

```bash
./mvnw test
```
