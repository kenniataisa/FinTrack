
# FinTrack

Sistema de controle de finanças pessoais, desenvolvido em Java como parte do curso **Capacita iRede**.

## O que o sistema faz

- Cadastra transações (receitas e despesas)
- Lista todas as transações cadastradas
- Mostra o saldo atual
- Remove uma transação

## Estrutura do projeto

```
fintrack/
├── src/
│   ├── app/Main.java
│   ├── controller/FinTracker.java
│   ├── model/Transacao.java
│   ├── model/TransacaoMensal.java
│   ├── exceptions/EntradaInvalidaException.java
│   └── utils/Formatador.java
├── .gitignore
└── README.md
```

## Conceitos de Java usados

- POO: encapsulamento, herança (TransacaoMensal extends Transacao) e polimorfismo
- if/else, switch, for, while
- ArrayList
- try/catch com exceção própria (EntradaInvalidaException)
- Organização em pacotes (model, controller, exceptions, utils, app)

## Como rodar

Precisa ter o JDK instalado (17 ou superior).

```
git clone https://github.com/seu-usuario/fintrack.git
cd fintrack
```

**PowerShell:**

```
javac -d bin (Get-ChildItem -Recurse -Filter *.java src | ForEach-Object { $_.FullName })
java -cp bin app.Main
```

**CMD:**

```
javac -d bin src\app\*.java src\controller\*.java src\model\*.java src\exceptions\*.java src\utils\*.java
java -cp bin app.Main
```

**Git Bash, Linux ou Mac:**

```
javac -d bin $(find src -name "*.java")
java -cp bin app.Main
```

Se nenhum desses funcionar:

```
javac -d bin src/app/Main.java src/controller/FinTracker.java src/model/Transacao.java src/model/TransacaoMensal.java src/exceptions/EntradaInvalidaException.java src/utils/Formatador.java
java -cp bin app.Main
```

Ou pela IDE: abrir a pasta, marcar `src` como source folder e rodar `app/Main.java`.

## Menu

```
===== FINTRACK - SEU CONTROLE FINANCEIRO =====
1. Adicionar nova transacao
2. Listar transacoes
3. Mostrar saldo atual
4. Remover transacao
5. Sair
Escolha uma opcao:
```

## Autores

Trabalho feito para o curso Capacita iRede - Residência em TIC 20.
