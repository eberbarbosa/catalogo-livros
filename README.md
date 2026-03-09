# 📚 Catálogo de Livros API

API REST desenvolvida com **Spring Boot** para gerenciamento de um catálogo de livros.

O projeto foi criado com foco em **boas práticas de desenvolvimento backend**, organização em camadas e documentação da API para facilitar integração com aplicações **Front-End**.

---

# 🚀 Demonstração da API

Após iniciar a aplicação, a documentação interativa pode ser acessada em:

```
http://localhost:8080/swagger-ui/index.html
```

Com o Swagger é possível:

* visualizar endpoints
* testar requisições
* entender os modelos da API

---

# 🧠 Arquitetura do Projeto

A aplicação segue o padrão de arquitetura em **camadas**, muito utilizado em projetos Spring Boot.

```
Controller → Service → Repository → Database
```

### Fluxo da requisição

```
Client (Postman / Frontend)
        ↓
Controller
        ↓
Service (regras de negócio)
        ↓
Repository
        ↓
Banco de dados
```

---

# 🧱 Estrutura do Projeto

```
src/main/java/br/com/eber/catalogo_livros

├── controller
│   └── LivroController.java
│
├── service
│   └── LivroService.java
│
├── repository
│   └── LivroRepository.java
│
├── model
│   └── Livro.java
│
└── CatalogoLivrosApplication.java
```

---

# ⚙️ Tecnologias Utilizadas

| Tecnologia      | Descrição                     |
| --------------- | ----------------------------- |
| Java            | Linguagem principal           |
| Spring Boot     | Framework backend             |
| Spring Web      | Criação da API REST           |
| Spring Data JPA | Persistência de dados         |
| Hibernate       | ORM                           |
| H2 / PostgreSQL | Banco de dados                |
| Swagger         | Documentação da API           |
| Maven           | Gerenciamento de dependências |
| Postman         | Teste da API                  |

---

# 📖 Endpoints da API

### 📚 Listar todos os livros

```
GET /livros
```

---

### 🔎 Buscar livro por ID

```
GET /livros/{id}
```

---

### ➕ Criar livro

```
POST /livros
```

Exemplo de JSON:

```json
{
  "titulo": "Clean Code",
  "autor": "Robert C. Martin",
  "anoPublicacao": 2008
}
```

---

### ✏️ Atualizar livro

```
PUT /livros/{id}
```

---

### ❌ Deletar livro

```
DELETE /livros/{id}
```

---

# 🧪 Testando a API

Você pode testar utilizando:

* Swagger UI
* Postman
* Insomnia
* curl

Uma **collection do Postman** também pode ser importada para facilitar os testes.

---

# 🖥️ Como rodar o projeto

### Clonar o repositório

```bash
   git clone https://github.com/seu-usuario/catalogo-livros.git
```

Entrar na pasta:

```bash
   cd catalogo-livros
```

---

### Rodar a aplicação

Com Maven:

```bash
   mvn spring-boot:run
```

Ou rodar a classe:

```
CatalogoLivrosApplication.java
```

---

# 🌐 Preparado para Front-End

A API já está preparada para consumo por aplicações Front-End.

Inclui:

✔ CORS habilitado
✔ respostas HTTP padronizadas
✔ estrutura REST

Compatível com:

* React
* Angular
* Vue
* aplicações mobile

---

# 🛣️ Roadmap do Projeto

Próximas melhorias planejadas:

* Paginação de resultados
* Filtro de busca por autor ou título
* Autenticação com JWT
* Testes unitários
* Dockerização
* Deploy em Cloud

---

# 📊 Status do Projeto

🚧 Em desenvolvimento

Projeto criado com objetivo de estudo e prática de **Spring Boot e desenvolvimento de APIs REST**.

---

# 👨‍💻 Autor

Desenvolvido por **Eber**

Backend Developer em formação focado em:

* Java
* Spring Boot
* APIs REST
* Arquitetura Backend

---

⭐ Se esse projeto te ajudou

Deixe uma ⭐ no repositório.

