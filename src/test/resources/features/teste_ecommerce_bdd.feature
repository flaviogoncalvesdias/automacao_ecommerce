# language: pt
Funcionalidade: Testes de Conhecimento

  @Regressao
  Cenário: Concluir a compra
    Dado que o usuário esteja no carrinho de compras
    Quando Clicar em fazer Checkout 
    E Preencher os dados
    Então Validar se botão concluir compra está habilitado
