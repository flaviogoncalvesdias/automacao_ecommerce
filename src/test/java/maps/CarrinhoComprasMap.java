package maps;

public class CarrinhoComprasMap {

	/**
	 * Metodo Para criar Elemento Expandir lista quantidade
	 * 
	 * @return
	 */
	public String criaElementoExpandirListaQuantidade() {
		return "//*[@id='a-autoid-0-announce']";
	}

	/**
	 * Metodo Para criar Elemento para selecionar na lista quantidade dois
	 * 
	 * @return
	 */
	public String criaElementoClicarQuantidadeDois() {
		return "//*[@class='a-dropdown-item quantity-option']";
	}
	
	
	/**
	 * Metodo para validar a abertura do carrinho de compras
	 * @return
	 */
	public String criaElementoValidarCarrinhoDeCompras() {
		return "//h2[contains(text(),'Carrinho de compras')]";
	}
	
	/**
	 * Cria elemento para validar quantidade de Itens
	 * @return
	 */
	public String criaElementoValidarQuantidadeCarrinhoDeCompras() {
		return "//span[@id='sc-subtotal-label-activecart']";
	}
	
	/**
	 * Metodo cria Elemento para excluir Item
	 * @return
	 */
	public String criaElementoRemoverProdutoCarrinhoDeCompras() {
		return "//div//input[@value='Excluir']";
	}
	
	/**
	 * Cria elemento para ir para pagina de checkout do pedido
	 * @return
	 */
	public String criaElementoCheckoutPedido() {
		return "//*[@id=\"sc-buy-box-ptc-button\"]/span/input";

	}
	
}
