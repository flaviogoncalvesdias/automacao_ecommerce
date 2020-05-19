package maps;

public class DetalheProdutoMap {

	/**
	 * Método para criar elemento para o botão adicionar ao Carrinho de compras
	 * 
	 * @return
	 */
	public String criaBotaoAdicionarCarrinho() {
		return "//input[@id='add-to-cart-button']";
	}

	/**
	 * Metodo para criar elemento para abrir carrinho compras
	 * 
	 * @return
	 */
	public String criaElementoAbrirCarrinhoCompras() {
		return "//span[contains(text(),'Carrinho')]";
	}
	
}
