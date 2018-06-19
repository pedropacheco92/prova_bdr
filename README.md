## Prova BDR

Esse projeto tem como objetivo ser uma demostração de um cadastro de carros em uma locadora de carros.

### Front-End
Para o *front-end* foi utilizado **Angular**, para instala-lo precisa ter o npm instalado, então basta executar:

`npm install --save @angular/material @angular/cdk`

Então na pasta *front-end/rent-car* basta executar:

`ng serve --open`

Isso irá buildar o projeto angular e iniciar o servidor e abrir o navegador na pagina `http://localhost:4200`

### Back-End
No *back-end* foi utilizado **Spring Boot**

Para executar o projeto deve-se ter instalado *maven*. Então deve-se executar na pasta *back-end/rent-car.rest* o comando:

`mvn clean install`

O qual irá buildar o projeto e criar um arquivo *jar* dentro da pasta target, que ao ser executado inicia um servidor Tomcat automaticamente.
Para executa-lo basta rodar o comando:

`java -jar rent-car.rest-0.0.1-SNAPSHOT.jar`

#### Eclipse IDE
Para a edição do projeto no *Eclipse* é preciso instalar o *lombok*, disponível em: https://projectlombok.org/

Com o *lombok* instalado no *Eclipse* basta importar o projeto *maven*.
