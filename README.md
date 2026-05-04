# Validador de CPF em Java

Este projeto consiste em um algoritmo desenvolvido em Java para validar o Cadastro de Pessoas Físicas (CPF). Além de verificar se o número informado é matematicamente válido através dos dígitos verificadores, o programa também identifica a região fiscal de origem do documento.

## 🚀 Funcionalidades

- **Tratamento de Entrada:** Aceita CPFs formatados (`000.000.000-00`) ou apenas números.
- **Validação de Formato:** Verifica se o input possui exatamente 11 dígitos numéricos.
- **Bloqueio de Sequências Inválidas:** Identifica e rejeita CPFs com todos os dígitos iguais (ex: `111.111.111-11`), que passam no cálculo matemático mas são inválidos pela Receita Federal.
- **Cálculo de Dígitos Verificadores:** Implementa o algoritmo oficial de validação (Módulo 11).
- **Identificação Regional:** Determina o estado ou região de origem com base no 9º dígito do CPF.

## 🛠️ Como funciona o algoritmo?

A validação é dividida em etapas lógicas:

### 1. Limpeza e Pré-validação
O código utiliza Expressões Regulares (Regex) para remover pontuações e garantir que o que restou são apenas números. Se o usuário digitar algo fora do padrão, o programa solicita a entrada novamente.

### 2. Cálculo dos Dígitos Verificadores
O CPF é composto por 9 dígitos base e 2 dígitos verificadores (os dois últimos).
- **1º Dígito:** Multiplica-se os 9 primeiros dígitos por uma sequência decrescente de 10 a 2. O resultado é multiplicado por 10 e dividido por 11. O resto da divisão é o primeiro dígito (se for 10, considera-se 0).
- **2º Dígito:** Repete-se o processo incluindo o primeiro dígito verificador calculado, usando agora uma sequência decrescente de 11 a 2.

### 3. Identificação da Região
O 9º dígito do CPF representa a Região Fiscal onde o documento foi emitido. O programa utiliza uma estrutura `switch` para mapear esse número:

|
