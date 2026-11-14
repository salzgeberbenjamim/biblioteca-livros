# Biblioteca - Cadastro e Gerenciamento de Livros

CRUD acadêmico com Java 17, Spring Boot 3.5.7, Spring MVC, Thymeleaf, Spring Data JPA, Bean Validation e MySQL.

## Requisitos
- JDK 17 ou superior
- Maven 3.6.3 ou superior (ou Maven Wrapper, se adicionado pela IDE)
- XAMPP com MySQL/MariaDB iniciado
- MySQL Workbench ou phpMyAdmin (opcional, para conferir os dados)

## Como executar
1. Inicie o MySQL no XAMPP.
2. Abra `http://localhost/phpmyadmin`.
3. Execute o script `database/biblioteca_db.sql` (ou crie um banco chamado `biblioteca_db`).
4. O padrão é usuário `root` e senha vazia. Se seu MySQL tiver senha, configure as variáveis de ambiente `DB_USERNAME` e `DB_PASSWORD` antes de executar; assim a senha não precisa ficar escrita no código nem ser enviada ao GitHub.
5. Abra a pasta do projeto no IntelliJ IDEA, Eclipse ou VS Code como projeto Maven.
6. Aguarde o Maven baixar as dependências.
7. Execute `BibliotecaApplication.java`.
8. Acesse `http://localhost:8080/livros`.

## Funcionalidades
- Listagem de livros
- Busca por título ou autor
- Cadastro e edição com validação
- Exclusão com confirmação
- Persistência no MySQL

## Estrutura
- `model`: entidade Livro
- `repository`: acesso ao banco via JpaRepository
- `service`: regras e operações
- `controller`: rotas MVC
- `templates/livros`: páginas Thymeleaf
- `static/css`: estilos
