package maps;

public class CarrinhoComprasMap {

	/**
	 * Metodo Para criar Elemento Expandir lista quantidade
	 * 
	 * @return
	 */
	public String criaElementoExpandirListaQuantidade() {
		return "//span[@class='a-dropdown-prompt']";
	}

	/**
	 * Metodo Para criar Elemento para selecionar na lista quantidade dois
	 * 
	 * @return
	 */
	public String criaElementoClicarQuantidadeDois() {
		return "//a[@id='dropdown1_2']";
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
	
}
