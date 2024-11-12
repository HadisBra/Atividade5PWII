# Projeto de Vendas

Este projeto é uma aplicação de gerenciamento de vendas desenvolvida com Java, Spring Boot e Thymeleaf. A aplicação permite gerenciar clientes, vendas e itens de venda.

## Tecnologias Utilizadas

- Java
- Spring Boot
- Thymeleaf
- Maven
- JPA (Jakarta Persistence API)
- Hibernate

## Estrutura do Projeto

- `src/main/java/org/example/atividade4/entity`: Contém as entidades JPA.
- `src/main/resources/templates`: Contém os templates Thymeleaf.
- `src/main/resources/application.properties`: Configurações da aplicação.

## Entidades

### Pessoa

Classe abstrata que representa uma pessoa. Pode ser uma `PessoaFisica` ou `PessoaJuridica`.

### PessoaFisica

Representa uma pessoa física com atributos como `cpf` e `nome`.

### PessoaJuridica

Representa uma pessoa jurídica com atributos como `cnpj` e `razaoSocial`.

### Venda

Representa uma venda realizada, contendo informações sobre o cliente, data e total da venda.

### ItemVenda

Representa um item dentro de uma venda, contendo informações sobre o produto, quantidade e preço.

## Templates Thymeleaf

### list.html

Exibe a lista de vendas com informações básicas e um link para visualizar os detalhes de cada venda.

### detail.html

Exibe os detalhes de uma venda específica, incluindo os itens da venda.

## Configuração e Execução

1. Clone o repositório:
   ```sh
   git clone <URL_DO_REPOSITORIO>
   ```

2. Navegue até o diretório do projeto:
   ```sh
   cd <DIRETORIO_DO_PROJETO>
   ```

3. Compile e execute a aplicação:
   ```sh
   mvn spring-boot:run
   ```

4. Acesse a aplicação no navegador:
   ```
   http://localhost:8080
   ```

## Contribuição

1. Faça um fork do projeto.
2. Crie uma branch para sua feature (`git checkout -b feature/nova-feature`).
3. Commit suas mudanças (`git commit -am 'Adiciona nova feature'`).
4. Faça push para a branch (`git push origin feature/nova-feature`).
5. Abra um Pull Request.

## Licença

Este projeto está licenciado sob os termos da licença MIT. Para mais detalhes, consulte o arquivo `LICENSE`.
