# Blood Bank Data Processor

Blood Bank Data Analyzer é um sistema web desenvolvido para processar e analisar dados de candidatos a doadores de sangue. Utilizando tecnologias como Java com Spring Boot para o backend, Angular para o frontend e MySQL para o banco de dados, o sistema permite a visualização de informações cruciais, como a distribuição de candidatos por estado, cálculo do IMC médio por faixa etária, percentual de obesidade entre homens e mulheres, média de idade por tipo sanguíneo e a quantidade de possíveis doadores para cada tipo sanguíneo receptor. Este projeto visa facilitar a gestão e análise de dados em bancos de sangue, contribuindo para uma melhor tomada de decisões e eficiência operacional.

## 🚀 Instruções para Configuração Local

Para obter uma cópia do Blood Bank Data Analyzer em operação na sua máquina local para fins de desenvolvimento e teste, siga os passos abaixo:

Consulte **[Implantação](www.nasa.com.br)** para saber como implantar o projeto.
___

### 📋 Pré-requisitos Backend

Backend
- Java 17: Certifique-se de ter o JDK 17 instalado.
- Maven: Ferramenta de automação e compilação para gerenciar dependências.
- MySQL: Banco de dados relacional para armazenar os dados dos candidatos.

<a>Baixe e instale o JDK 17 a partir do site oficial da Oracle1</a>

```
sdk install java 17.0.11-open

```
- Baixe e instale o Maven a partir do site oficial ou utilize um gerenciador de pacotes como brew (para macOS) ou apt (para Linux).

```
brew install maven

```
- Baixe e instale o Maven a partir do site oficial ou utilize um gerenciador de pacotes como brew (para macOS) ou apt (para Linux).

```
brew install maven

```
- Baixe e instale o MySQL. Após a instalação, crie um banco de dados para o projeto.
```
CREATE DATABASE blood-donors;
````
___

### 🔧 Instalação

1. Clone o repositório:
```
https://github.com/GustavoAnacleto/Blood-Bank.git
```
2. Navegue até o diretório do projeto:
```
cd blood-bank
```

3. No diretório do projeto execute no terminal:
```
mvn spring-boot:run
```

## 📦 Implantação

Após a implantação, você pode acessar a aplicação em http://localhost:3000/ e utilizar as funcionalidades para analisar os dados dos candidatos a doadores de sangue. Por exemplo, para visualizar a quantidade de candidatos por estado, você pode acessar a seção correspondente na interface do usuário.
## Formato do json
```json
[
  {
    "name": "João Silva",
    "birthDate": "1999-05-15",
    "weight": 130.0,
    "height": 1.75,
    "gender": "M",
    "bloodType": "A+",
    "state": "São Paulo"
  },
]
```
___

## ✒️ Autor
## * **Guga Nascimento** - *Dev Software Back-End* <br> <br>[![GitHub](https://img.shields.io/badge/GitHub-000?style=for-the-badge&logo=github&logoColor=)](https://github.com/GustavoAnacleto)<br>
[![GitHub](https://img.shields.io/badge/GitHub-000?style=for-the-badge&logo=github&logoColor=)](https://github.com/Guga-Nascimento)<br> <br>[![linkedin](https://img.shields.io/badge/linkedin-0A66C2?style=for-the-badge&logo=linkedin&logoColor=white)](https://www.linkedin.com/in/guga-nascimento) 


## 🎁 Video de apresentação do projeto
<a>http://bloodbankapi.netlify.app</a>
