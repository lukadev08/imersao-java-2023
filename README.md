<div> 
<img align="char" alt="Java" height="50" width="50" src="https://cdn.jsdelivr.net/gh/devicons/devicon/icons/java/java-original.svg">
<img align="char" alt="Spring" height="40" width="40" src="https://cdn.jsdelivr.net/gh/devicons/devicon/icons/spring/spring-original.svg">
<img align="char" alt="mongo" height="50" width="50" src="https://cdn.jsdelivr.net/gh/devicons/devicon/icons/mongodb/mongodb-plain-wordmark.svg">
</div>

# Imersão Java 2023 <br>
Projeto feito com a Alura do Imersão Java 2023


## Projeto de API para retorno de figurinhas de WhatsApp utilizando Java e Spring com conexão no banco de dados MongoDB⌨️

Este projeto é uma API que tem como objetivo disponibilizar endpoints para acesso a um banco de dados MongoDB contendo informações de figurinhas de WhatsApp. A aplicação foi desenvolvida utilizando a linguagem Java e o framework Spring.

## Funcionamento da API⚙️
A API disponibiliza endpoints para a realização de operações de CRUD (Create, Read, Update, Delete) sobre o banco de dados contendo as informações das figurinhas. As operações disponíveis são:

GET /linguagens: retorna todas as figurinhas cadastradas no banco de dados;<br>
GET /linguagens/{id}: retorna a figurinha correspondente ao id informado;<br>
POST /linguagens: cria uma nova figurinha com as informações fornecidas no corpo da requisição;<br>
PUT /linguagens/{id}: atualiza a figurinha correspondente ao id informado com as informações fornecidas no corpo da requisição;<br>
DELETE /linguagens/{id}: remove a figurinha correspondente ao id informado.<br>

## Como utilizar o projeto❓
Para utilizar este projeto, é necessário ter o Java e o MongoDB instalados na máquina. Além disso, é preciso clonar este repositório e executar o comando mvn spring-boot:run na pasta raiz do projeto para iniciar a aplicação.

Os endpoints da API podem ser acessados através de uma ferramenta de teste de API, como o Postman, por exemplo. É importante lembrar que, para acessar os endpoints que exigem autenticação, é preciso enviar um token JWT no header da requisição.

## Considerações finais😉
Este projeto é um exemplo de como utilizar o Java e o Spring para desenvolver uma API que faz uso de um banco de dados MongoDB. Ele pode ser utilizado como ponto de partida para a construção de aplicações mais complexas que exijam o armazenamento e a recuperação de informações de figurinhas de WhatsApp.
