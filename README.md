# Sistema-Oficina-Weg

Sistema de gerenciamento de ordens de serviço para a escola WEG, desenvolvido com Spring Boot.

---

## Sobre o sistema

O sistema permite que professores abram ordens de serviço para reparo de equipamentos, alunos registrem a execução dos reparos com os materiais utilizados e a conclusão técnica, e professores finalizem as ordens após revisão. Também é possível cadastrar usuários (professores e alunos), criar turmas e matricular alunos nelas.

---

## Tecnologias utilizadas

- Java 21
- Spring Boot 3.5
- Spring Data JPA
- Spring Web (REST)
- Spring Validation
- MySQL (produção)
- Lombok
- Maven

---

## Arquitetura

O projeto segue uma arquitetura em camadas, separando responsabilidades entre pacotes bem definidos:

### domain
Contém as regras de negócio centrais do sistema. É a camada mais interna e não depende de nenhuma outra.

- `model` — entidades JPA que representam o domínio: `Usuario`, `Turma` e `OrdemServico`
- `model/enums` — enumerações de domínio: `TipoUsuario` (PROFESSOR, ALUNO) e `StatusOrdemServico` (ABERTA, EXECUTANDO, AGUARDANDO_APROVACAO, CONCLUIDA)
- `service` — interfaces de serviço que definem os contratos das operações de negócio

### application
Implementa os casos de uso do sistema. Orquestra as operações entre o domínio e a infraestrutura.

- `service` — implementações concretas das interfaces de serviço definidas no domínio
- `dto` — objetos de transferência de dados separados por contexto (request e response) para cada entidade
- `mapper` — classes responsáveis por converter entre DTOs e entidades de domínio

### infra
Camada de infraestrutura. Contém os detalhes técnicos de persistência e exposição da API.

- `repository` — interfaces JPA que estendem `JpaRepository`
- `web/controller` — controllers REST que recebem as requisições HTTP e delegam para os serviços

---

## Principios SOLID aplicados

**Single Responsibility Principle (SRP)**
Cada classe tem uma única responsabilidade. Os mappers apenas convertem dados, os services apenas orquestram a lógica de negócio, os controllers apenas recebem e respondem requisições HTTP.

**Open/Closed Principle (OCP)**
As interfaces de serviço (`OrdemServicoService`, `TurmaService`, `UsuarioService`) permitem que novas implementações sejam adicionadas sem modificar o código que as consome.

**Liskov Substitution Principle (LSP)**
As implementações (`OrdemServicoServiceImpl`, `TurmaServiceImpl`, `UsuarioServiceImpl`) podem substituir suas respectivas interfaces sem quebrar o comportamento esperado pelo sistema.

**Interface Segregation Principle (ISP)**
Cada interface de serviço define apenas os métodos relevantes ao seu contexto. `TurmaService` não carrega métodos de `UsuarioService`, e assim por diante.

**Dependency Inversion Principle (DIP)**
Os controllers dependem das interfaces de serviço, não das implementações concretas. As implementações de serviço dependem das interfaces de repositório, não das classes concretas do JPA. As dependências são injetadas via construtor.

---

## Entidades principais

**Usuario**
Representa um professor ou aluno. Possui nome, tipo (`TipoUsuario`) e pode estar vinculado a uma turma.

**Turma**
Agrupa alunos. Possui nome e uma lista de usuários do tipo ALUNO matriculados.

**OrdemServico**
Representa um chamado de reparo. Possui equipamento, defeito relatado, materiais usados, conclusão técnica, status atual, professor responsável e lista de alunos escalados.

---

## Fluxo de uma ordem de serviço

1. Um professor abre a OS informando o equipamento, o defeito e os alunos escalados. O status inicial é `ABERTA`.
2. Os alunos registram a execução com os materiais utilizados e a conclusão técnica. O status muda para `EXECUTANDO`.
3. O professor responsável finaliza a OS após revisão. O status muda para `CONCLUIDA`.

---

## Endpoints disponíveis

### Usuarios
- `POST /usuario` — cadastra um novo usuario
- `GET /usuario` — lista todos os alunos
- `GET /usuario/{id}` — busca usuario por ID

### Turmas
- `POST /turma` — cria uma nova turma
- `POST /turma/{id}` — matricula um aluno na turma
- `GET /turma` — lista todas as turmas com seus alunos

### Ordens de Servico
- `POST /ordemservico` — abre uma nova ordem de servico
- `POST /ordemservico` — registra a execucao
- `POST /ordemservico` — finaliza a ordem
- `GET /ordemservico` — lista as ordens ativas

---

## Configuracao

O arquivo `application.properties` define a conexao com o banco de dados MySQL:

```
spring.datasource.url=jdbc:mysql://localhost:3306/oficinactw
spring.datasource.username=root
spring.datasource.password=mysqlPW
spring.jpa.hibernate.ddl-auto=update
```

## Testes no Postman

Para testar, basta:
- Baixar o JSON de testes ```Oficina CTW - Testes.postman_collection.json```.
- Ir para o Postman e clicar no botao ```import```.
- Rodar os testes de acordo com a ordem lógica de criacão de cada um

