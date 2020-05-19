# language: pt
Funcionalidade: Testes de Conhecimento

  Cenário: Busca Produto
    Dado que o usuário esteja na pagina inicial
    Quando realizar uma busca pelo produto
    Então validar se produto retornou no resultado da busca: "Celular Apple iPhone XS Max 64GB 4G iOS 13 Tela 6"
  
@Regressao  
  Cenário: Adiciona Produto no Carrinho
    Dado que o usuário esteja na pagina inicial
    E selecionou um produto
    Quando clicar em comprar
    Então validar se produto foi adicionado ao carrinho de compras: "Celular Apple iPhone XS Max 64GB 4G iOS 13 Tela 6"

@FaltaImplementar    
Cenário: Altera a quantidade de um item do carrinho compras
    Dado que o usuário esteja no carrinho de compras
    Quando alterar a quantidade de um item
    Então validar se a quantidade é igual a : 2

@FaltaImplementar        
  Cenário: Remover item do carrinho
  Dado que o usuário esteja no carrinho de compras com pelo menos 2 produtos diferentes
  Quando remover um item
  Então validar se o item foi removido
  
@FaltaImplementar      
  Cenário: Concluir a compra
  Dado que o usuário esteja na pagina de checkout
  Quando Preencher os dados
  Então Validar se botão concluir compra está habilitado    