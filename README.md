# Desafio Java + Spring Framework + JPA

### Objetivos

Testar os conhecimentos do programador em relação ao desenvolvimento de APIs RESTful baseadas em Java, utilizando
Spring Boot e JPA.

* Criação de RESTful APIs altamente coesas e de baixo acoplamento, implementadas no modelo MVC (Model-view-controller)
* Criação/mapeamento de entidades, bem como os relacionamentos entre elas, utilizando anotações
* Elaboração de testes unitários

### Contexto

Você foi contratado pela loja de chocolates "Doce Sonho" para desenvolver uma aplicação para controle e comércio online
dos diversos produtos do estabelecimento. A loja vende Chocolates e Bombons por unidade, e possui um sistema de
avaliação que permite aos consumidores darem notas aos itens do catálogo.

### Escopo Técnico

A aplicação é uma API RESTful que retorna dados em formato JSON. É baseada em Java e utiliza o framework Spring.
Para deixar este exercício mais simples e independente, um banco de dados relacional em memória é utilizado (H2). O
projeto utiliza o Gradle para gerenciamento de dependências e construção.

A sua tarefa será realizar os desafios que envolvem alteração de escopo e esquema listados abaixo. É recomendável que
os desafios sejam concluídos na ordem que estão dispostos, pois alguns desafios utilizarão resoluções de desafios
anteriores. Naturalmente, os desafios possuem diversas formas de resolução, mas a coesão e objetividade contarão na
avaliação. A menos que seja especificado no desafio, você possui toda a liberdade para escolher os nomes para classes
e _endpoints_.

#### Stack

* Java 11
* Spring 2.5.3
  * Boot
  * Data JPA
  * Testing
  * Actuator
  * Devtools
* H2

### *Building*

Após clonar este repositório, basta navegar até o diretório raiz do projeto e executar o comando:

```gradlew bootRun```

A aplicação estará disponível na porta 8080. O console do H2 estará disponível no caminho ```/h2-console```, com os
seguintes parâmetros: 

```
URL         : jdbc:h2:mem:desafio-db
User Name   : desafio
Password    : desafio
```
