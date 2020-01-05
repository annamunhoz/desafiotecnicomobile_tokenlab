# Desafio Técnico Mobile - Estágio Tokenlab

Desafio técnico desenvolvido para o processo seletivo de estágio mobile na Tokenlab.

## Características do App
* Linguagem utilizada: Java
* Biblioteca para requisições HTTP: [Google Volley](https://developer.android.com/training/volley/index.html)
* Padrão de arquitetura utilizado: MVC

## Desafio
O pessoal da Tokenlab gosta muito de filmes e decidiu construir uma API REST que disponibiliza informações sobre 20 filmes que estão entre os mais bem avaliados pelos usuários do TMDB.

O desafio consiste em elaborar um aplicativo (Android ou iOS) que obtenha os dados desta API, apresentando-os de forma simples e acessível, seguindo os padrões de usabilidade da plataforma. Preze pela qualidade e não pela velocidade, utilize o tempo que lhe foi dado da melhor forma possível.

#### Requisitos
* O projeto deve ser desenvolvido com tecnologias nativas da plataforma (Java ou Kotlin para Android e Swift para iOS).
* O aplicativo deve ter no mínimo duas telas. Na primeira deve ser mostrada uma lista dos filmes (com imagem e título, ou só imagem). Ao selecionar um filme desta lista, o usuário deve ser redirecionado para uma tela de detalhes, onde mais informações devem ser exibidas. Você não precisa mostrar todas as informações que a API te der sobre os filmes.
* Você precisa manter o usuário informado de que a aplicação está baixando/processando os dados.
* Utilize algum padrão de arquitetura de software (MVP, MVVM, MVC, Clean Architecture, etc).
* Todo o código deve ser enviado para algum repositório git remoto público (Github, Bitbucket, etc).
* Utilize alguma biblioteca de terceiro para realizar as chamadas HTTP. Você é livre para utilizar quantas bibliotecas quiser em seu projeto.

#### Informações da API
* Para obter a listagem dos filmes, basta realizar uma requisição HTTP utilizando o método GET no seguinte endpoint: https://desafio-mobile.nyc3.digitaloceanspaces.com/movies
* Para obter informações detalhadas de um determinado filme, basta adicionar o ID do mesmo ao final do endpoint anterior. Então se quisermos, por exemplo, obter os detalhes do filme de ID 240, basta realizar um GET no seguinte endpoint: https://desafio-mobile.nyc3.digitaloceanspaces.com/movies/240
