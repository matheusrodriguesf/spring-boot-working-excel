# Spring Boot Working Excel

Este é um projeto de exemplo desenvolvido em **Spring Boot** para geração de arquivos Excel (.xlsx). O objetivo deste projeto é demonstrar como gerar uma planilha Excel preenchida com dados de uma fonte de dados definida.

## Tecnologias Utilizadas

- [Spring Boot](https://spring.io/projects/spring-boot) - framework Java para desenvolvimento de aplicações web;
- [Apache POI](https://poi.apache.org/) - biblioteca Java para manipulação de arquivos do Microsoft Office (Excel);
- [Maven](https://maven.apache.org/) - ferramenta para gerenciamento de dependências e build de projetos;
- [Docker](https://www.docker.com/) - plataforma de conteinerização.

## Executando a Aplicação Localmente

Para executar esta aplicação em um ambiente local, siga as instruções abaixo:

1. Clone este repositório:

```
git clone https://github.com/matheusrodriguesf/spring-boot-working-excel.git
```

2. Navegue até o diretório do projeto:

```
cd spring-boot-working-excel/
```

3. Compile o projeto usando Maven:

```
mvn clean install
```

4. Execute a aplicação usando o plugin do Spring Boot Maven:

```
mvn spring-boot:run
```

5. Acesse a aplicação em um navegador no endereço http://localhost:8080/

## Executando a Aplicação via Docker

Para executar esta aplicação via Docker, siga as instruções abaixo:

1. Clone este repositório:

```
git clone https://github.com/matheusrodriguesf/spring-boot-working-excel.git
```

2. Navegue até o diretório do projeto:

```
cd spring-boot-working-excel/
```

3. Construa a imagem Docker:

```
docker build -t spring-boot-working-excel .
```

4. Execute o container Docker:

```
docker run -p 8080:8080 spring-boot-working-excel
```

5. Acesse a aplicação em um navegador no endereço http://localhost:8080/

## Autor

Matheus Rodrigues

