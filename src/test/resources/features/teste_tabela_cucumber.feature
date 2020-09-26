# language: pt
Funcionalidade: Testes Tabela
@testeTabelas

  Cenário: Teste Tabelas
    Dado que o usuário esteja na pagina inicial
    Quando realizar uma busca pelo produto
    Entao Imprime na tela:
      | Primeiro nome | Ultimo nome | Telefone   | Password | Nascimento | Mes | Ano  |
      | Flávio        | Dias        | 0123123123 | Pass1234 |         15 |  04 | 1988 |

  Cenário: Teste Listas
    Dado que o usuário esteja na pagina inicial
    Quando realizar uma busca pelo produto
    Entao Imprime os animais na tela:
      | cow   |
      | horse |
      | sheep |
