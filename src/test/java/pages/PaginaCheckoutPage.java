package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import maps.CarrinhoComprasMap;
import maps.PaginaCheckoutMap;

public class PaginaCheckoutPage {

	/**
	 * Metodo para preencher email
	 * 
	 * @param driver
	 * @param email
	 * @throws Exception
	 */
	public void preencherEmail(WebDriver driver, String email) throws Exception {
		PaginaCheckoutMap paginaCheckoutMap = new PaginaCheckoutMap();
		try {
			WebElement elemento = driver.findElement(By.xpath((paginaCheckoutMap.criaElementoLoginEmail())));
			elemento.click();
			elemento.sendKeys(email);
			elemento.submit();

		} catch (Exception e) {
			throw new Exception("Erro ao preencher email");
		}

	}

	/**
	 * Metodo para preencher senha
	 * 
	 * @param driver
	 * @param email
	 * @throws Exception
	 */
	public void preencherSenha(WebDriver driver, String senha) throws Exception {
		PaginaCheckoutMap paginaCheckoutMap = new PaginaCheckoutMap();
		try {
			WebElement elemento = driver.findElement(By.xpath((paginaCheckoutMap.criaElementoLoginSenha())));
			elemento.click();
			elemento.sendKeys(senha);
			elemento.submit();
		} catch (Exception e) {
			throw new Exception("Erro ao preencher senha");
		}

	}

	/**
	 * Metodo para clicar enviar para este Endereço
	 * 
	 * @param driver
	 * @throws Exception
	 */
	public void clicarEnviarEsteEndereco(WebDriver driver) throws Exception {
		PaginaCheckoutMap paginaCheckoutMap = new PaginaCheckoutMap();
		try {
			WebElement elemento = driver
					.findElement(By.xpath((paginaCheckoutMap.criaElementoEnviarParaEnderecoCadastrado())));
			elemento.click();
		} catch (Exception e) {
			throw new Exception("Erro ao clicar no botão enviar para este endereço");
		}

	}

	/**
	 * Metodo para clicar em Continuar na pagina de endereço
	 * 
	 * @param driver
	 * @throws Exception
	 */
	public void clicarContinuarEndereco(WebDriver driver) throws Exception {
		PaginaCheckoutMap paginaCheckoutMap = new PaginaCheckoutMap();
		try {
			WebElement elemento = driver.findElement(By.xpath((paginaCheckoutMap.criaElementoContinuarEntrega())));
			elemento.click();
		} catch (Exception e) {
			throw new Exception("Erro ao clicar no botão continuar Pagina Endereço");
		}

	}

	/**
	 * Metodo para clicar em Boleto
	 * 
	 * @param driver
	 * @throws Exception
	 */
	public void clicarBoleto(WebDriver driver) throws Exception {
		PaginaCheckoutMap paginaCheckoutMap = new PaginaCheckoutMap();
		try {
			WebElement elemento = driver.findElement(By.xpath((paginaCheckoutMap.criaElementoBoleto())));
			elemento.click();
		} catch (Exception e) {
			throw new Exception("Erro ao clicar no checkbox Boleto");
		}

	}

	/**
	 * Metodo para clicar em Continuar Paganina Pagamento
	 * 
	 * @param driver
	 * @throws Exception
	 */
	public void clicarContinuarPagamento(WebDriver driver) throws Exception {
		PaginaCheckoutMap paginaCheckoutMap = new PaginaCheckoutMap();
		try {
			WebElement elemento = driver.findElement(By.xpath((paginaCheckoutMap.criaElementoContinuar())));
			elemento.click();
		} catch (Exception e) {
			throw new Exception("Erro ao clicar no botao continuar");
		}

	}

	/**
	 * Metodo para Validar Existencia botão Confirmar
	 * 
	 * @param driver
	 * @return
	 * @throws Exception
	 */
	public Boolean validarBotaoConfirmarPedido(WebDriver driver) throws Exception {
		PaginaCheckoutMap paginaCheckoutMap = new PaginaCheckoutMap();
		try {
			WebElement elemento = driver.findElement(By.xpath((paginaCheckoutMap.criaElementoConfirmarPedido())));
			return elemento.isDisplayed();
		} catch (Exception e) {
			throw new Exception("Erro validar existencia do botão Confirmar Pedido");
		}

	}

}
