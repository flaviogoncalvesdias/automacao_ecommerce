package maps;

public class PaginaCheckoutMap {

	/**
	 * Retorna elemento botão Confirmar Pedido
	 * 
	 * @return
	 */
	public String criaElementoConfirmarPedido() {
		return "//input[@name='placeYourOrder1']";
	}

	/**
	 * Enviar Endereço Cadastrado
	 * 
	 * @return
	 */
	public String criaElementoEnviarParaEnderecoCadastrado() {
		return "//a[contains(text(),'Envie para este endereço')]";
	}

	/**
	 * Cria elemento Boleto
	 * 
	 * @return
	 */
	public String criaElementoBoleto() {
		return "//span[@class='a-text-bold']";

	}

	/**
	 * Metodo Cria elemento Botão Continuar
	 * 
	 * @return
	 */
	public String criaElementoContinuar() {
		return "//span[@class='a-button a-button-span12 a-button-primary pmts-button-input']";

	}

	/**
	 * Criar login Email
	 * 
	 * @return
	 */
	public String criaElementoLoginEmail() {
		return "//input[@name='email']";
	}

	/**
	 * Criar login Email
	 * 
	 * @return
	 */
	public String criaElementoLoginSenha() {
		return "//input[@name='password']";
	}

	public String criaElementoContinuarEntrega() {
		return "//div[contains(@class,'a-row a-spacing-medium')]//input[@class='a-button-text']";
	}

}
