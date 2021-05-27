# language: pt
@test
Funcionalidade: [POC Compra Amazon]

  Cenário: Busca Produto
    Dado que o usuário esteja na pagina inicial
    Quando realizar uma busca pelo produto
    Então validar se produto retornou no resultado da busca: "iphone 11 128gb"


  Cenário: Adiciona Produto no Carrinho
    Dado que o usuário esteja na pagina inicial
    E selecionou um produto
    Quando clicar em comprar
    Então validar se produto foi adicionado ao carrinho de compras

  Cenário: Remover item do carrinho
    Dado que o usuário esteja no carrinho de compras com dois ou mais produtos diferentes
    Quando remover um item
    Então validar se o item foi removido

  Cenário: Concluir a compra
    Dado que o usuário esteja no carrinho de compras
    Quando Clicar em fazer Checkout
    E Preencher os dados
    Então Validar se botão concluir compra está habilitado
