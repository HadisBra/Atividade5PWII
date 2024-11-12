Projeto de Vendas
Este projeto é uma aplicação de gerenciamento de vendas desenvolvida com Java, Spring Boot e Thymeleaf. A aplicação permite gerenciar clientes, vendas e itens de venda.

Tecnologias Utilizadas
Java
Spring Boot
Thymeleaf
Maven
JPA (Jakarta Persistence API)
Hibernate
Estrutura do Projeto
src/main/java/org/example/atividade4/entity: Contém as entidades JPA.
src/main/resources/templates: Contém os templates Thymeleaf.
src/main/resources/application.properties: Configurações da aplicação.
Entidades
Pessoa
Classe abstrata que representa uma pessoa. Pode ser uma PessoaFisica ou PessoaJuridica.

PessoaFisica
Representa uma pessoa física com atributos como cpf e nome.

PessoaJuridica
Representa uma pessoa jurídica com atributos como cnpj e razaoSocial.

Venda
Representa uma venda realizada, contendo informações sobre o cliente, data e total da venda.

ItemVenda
Representa um item dentro de uma venda, contendo informações sobre o produto, quantidade e preço.

Templates Thymeleaf
list.html: Exibe a lista de vendas com informações básicas e um link para visualizar os detalhes de cada venda.
detail.html: Exibe os detalhes de uma venda específica, incluindo os itens da venda.
Configuração e Execução
Clone o repositório:
git clone <URL_DO_REPOSITORIO>
Navegue até o diretório do projeto:
cd <DIRETORIO_DO_PROJETO>
Compile e execute a aplicação:
mvn spring-boot:run
Acesse a aplicação no navegador:
http://localhost:8080
Contribuição
Faça um fork do projeto.
Crie uma branch para sua feature:
git checkout -b feature/nova-feature
Commit suas mudanças:
git commit -am 'Adiciona nova feature'
Faça push para a branch:
git push origin feature/nova-feature
Abra um Pull Request.
Licença
Este projeto está licenciado sob os termos da licença MIT. Para mais detalhes, consulte o arquivo LICENSE.
