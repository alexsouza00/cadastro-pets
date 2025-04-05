# Sistema de Cadastros de Pets

### Desafio criado por Lucas Carrilho - [@devmagro](https://www.linkedin.com/in/karilho/)

## Introdução
Este desafio propõe a criação de um Sistema de Adoção de Pets utilizando CLI. O objetivo é desenvolver um sistema que permita a um usuário realizar as seguintes operações:

- Cadastrar novos pets
- Buscar pets por critérios como nome, idade ou raça
- Alterar dados de pets existentes
- Excluir registros de pets

O sistema exige o uso de arquivos para armazenar as informações dos pets. O desafio propõe a validação dos dados de entrada, como garantir que o nome do pet seja válido e que o peso e a idade estejam dentro de limites específicos.
O projeto tem uma aplicação prática que utiliza conceitos de manipulação de arquivos, exceções, enumerações e validações em Java.
Utilizei conhecimentos como Orientação a Objetos (OO), manipulação de arquivos e arrays, Java IO, exceções, boas práticas de código e sistemas de arquivos (File Systems)."

Para saber mais sobre o desafio: https://youtu.be/_Kqy3hdAQxg?feature=shared 

## Como Executar o Projeto
### Pré-requisitos
Certifique-se de ter instalado:

- Java JDK 17+
- Git

### Passos para executar o projeto:
### 1 - Clone o repositório:

Antes de tudo, clone o repositório para o seu computador. Você pode fazer isso com o seguinte comando:

 ```bash
git clone <URL-do-repositório>
```

### 2 - Ajuste o Caminho do Projeto:

Agora precisamos definir o caminho do projeto no arquivo Program.java. Para fazer isso, siga os passos abaixo:

Navegue até o diretório do projeto, e depois até o arquivo Program.java, que se encontra em

```bash
/local-de-instalação/cadastro-pets/src/application/Program.java
```

Dentro do arquivo Program.java, localize a variável projectPath e altere para o caminho completo do projeto, conforme o exemplo abaixo:

```java
public class Program {
    // Informe o caminho completo do projeto aqui:
    public static String projectPath = "C:\\000\\cadastro-pets";
}
```

exemplo: Se você clonou o projeto no diretório C:\\000, a variável projectPath deve ser configurada para esse caminho.

### 3 - Executando o Sistema:

Execute o arquivo Program.java em sua IDE, ou execute no seu terminal:

1 - Navegue até o diretório src do seu projeto:

```bash
cd C:\000\cadastro-pets\src
```

2 - Compile todos os arquivos:

```bash
javac application/Program.java services/*.java utils/*.java
```

3 - Agora rode o programa com:

```bash
java application.Program
```



