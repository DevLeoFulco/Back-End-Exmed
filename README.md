Esta documentação incluirá uma breve descrição do projeto, endpoints da API, e algumas notas importantes. Note que esta é uma documentação genérica não refletindo o todo do projeto.

# Back-End Documentation

## Projeto ExMed

O Projeto ExMed é uma aplicação que visa fornecer um sistema de promoções e indicações, recompensando usuários por participarem de campanhas e indicarem novos usuários.

## Estrutura do Projeto

- **src/main/java/com/squad15/exmed/models:** Contém as classes de modelo que representam as entidades do sistema, como `Usuario`, `Campanha`, `Indicacao`, etc.

- **src/main/java/com/squad15/exmed/services:** Inclui os serviços responsáveis pela lógica de negócios da aplicação, como `UsuarioService`, `CampanhaService`, etc.

- **src/main/java/com/squad15/exmed/controllers:** Contém os controladores que lidam com as requisições HTTP, como `UsuarioController`, `CampanhaController`, etc.

- **src/main/java/com/squad15/exmed/repository:** Inclui interfaces de repositório que estendem `JpaRepository` e lidam com operações de banco de dados para entidades específicas, como `UsuarioRepository`, `CampanhaRepository`, etc.

- **src/main/java/com/squad15/exmed/enums:** Contém enumerações, como `UserRole`, que definem papéis de usuário na aplicação.

- **src/main/java/com/squad15/exmed/exceptions:** Inclui classes para lidar com exceções específicas, como `TratadorDeErros` para tratamento de erros.

- **src/main/java/com/squad15/exmed/utils:** Contém utilitários, como `GerarCodIndicacao`, para geração de códigos de indicação.

## Endpoints da API

A API do Projeto ExMed oferece os seguintes endpoints:

- **Usuarios:**
  - `GET /usuarios`: Retorna todos os usuários cadastrados.
  - `GET /usuarios/{id}`: Retorna os detalhes de um usuário específico.
  - `POST /usuarios`: Cria um novo usuário.
  - `DELETE /usuarios/{id}`: Exclui um usuário.

- **Campanhas:**
  - `GET /campanhas`: Retorna todas as campanhas disponíveis.
  - `POST /campanhas`: Cria uma nova campanha.

- **Indicacoes:**
  - `GET /indicacoes`: Retorna todas as indicações.
  - `POST /indicacoes`: Cria uma nova indicação.

- **Outros Endpoints:**
  - Adapte conforme necessário para outras funcionalidades específicas.

## Executando o Projeto

1. Clone o repositório: `git clone https://github.com/seu-usuario/exmed-backend.git`
2. Navegue até o diretório: `cd exmed-backend`
3. Execute a aplicação: `./mvnw spring-boot:run`

A aplicação estará disponível em `http://localhost:8080`.

## Notas Importantes

- Certifique-se de ter um ambiente Java configurado.
- Configure corretamente as propriedades do banco de dados no arquivo `application.properties`.
- Considere a segurança da API ao implementar endpoints sensíveis.

---

