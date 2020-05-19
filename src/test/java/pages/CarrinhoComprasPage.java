package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import maps.CarrinhoComprasMap;

public class CarrinhoComprasPage {

	/**
	 * Metoodo para expandir lista de quantidade no carrinho de compras
	 * 
	 * @param driver
	 * @throws Exception
	 */
	public void expandirListaQuantidadeCarrinhoCompras(WebDriver driver) throws Exception {
		CarrinhoComprasMap carrinhoMap = new CarrinhoComprasMap();
		try {
			WebElement elemento = driver.findElement(By.xpath((carrinhoMap.criaElementoExpandirListaQuantidade())));
			elemento.click();
		} catch (Exception e) {
			throw new Exception("Erro ao expandir lista quantidade do carrinho de compras");
		}
	}

	/**
	 * Metoodo para expandir lista de quantidade no carrinho de compras
	 * 
	 * @param driver
	 * @throws Exception
	 */
	public void selecionaQuantidadeCarrinhoCompras(WebDriver driver) throws Exception {
		CarrinhoComprasMap carrinhoMap = new CarrinhoComprasMap();
		try {
			WebElement elemento = driver.findElement(By.xpath((carrinhoMap.criaElementoClicarQuantidadeDois())));
			elemento.click();
		} catch (Exception e) {
			throw new Exception("Erro ao clicar na quantidade dois na lista do carrinho de compras");
		}
	}

	/**
	 * Metodo para validar abertura da pagina Carrinho de compras
	 * 
	 * @param driver
	 * @throws Exception
	 */
	public Boolean validarCarrinhoCompras(WebDriver driver) throws Exception {
		CarrinhoComprasMap carrinhoMap = new CarrinhoComprasMap();
		try {
			WebElement elemento = driver.findElement(By.xpath((carrinhoMap.criaElementoValidarCarrinhoDeCompras())));
			return elemento.isDisplayed();

		} catch (Exception e) {
			throw new Exception("Erro ao validar pagina carrinho de compras");
		}
	}

	/**
	 * Metodo para validar se o produto esta no Carrinho de compras
	 * 
	 * @param driver
	 * @param produto
	 * @return
	 */
	public boolean validarProdutoCarrinhoCompras(WebDriver driver, String produto) {
		return driver.getPageSource().contains(produto);
	}

	/**
	 * Metodo para validar se a quantidade do produto foi alterada
	 * 
	 * @param driver
	 * @param produto
	 * @return
	 * @throws Exception
	 */
	public boolean validarQuantidadeProdutoCarrinhoCompras(WebDriver driver, Integer quantidade) throws Exception {

		CarrinhoComprasMap carrinhoMap = new CarrinhoComprasMap();
		try {
			WebElement elemento = driver
					.findElement(By.xpath((carrinhoMap.criaElementoValidarQuantidadeCarrinhoDeCompras())));
			
			if(quantidade>1) {
				return elemento.getText().contains(quantidade + " itens");
			}
			else{
				return elemento.getText().contains(quantidade + " item");
			}
		

		} catch (Exception e) {
			throw new Exception("Erro ao validar quantidade de produtos no carrinho de compras");
		}

	}

	/**
	 * Metodo para remover produto do carrinho de compras
	 * @param driver
	 * @param produto
	 * @throws Exception
	 */
	public void removeProdutoCarrinhoCompras(WebDriver driver, String produto) throws Exception {
		CarrinhoComprasMap carrinhoMap = new CarrinhoComprasMap();
		try {
			WebElement elemento = driver
					.findElement(By.xpath((carrinhoMap.criaElementoRemoverProdutoCarrinhoDeCompras())));
			elemento.click();

		} catch (Exception e) {
			throw new Exception("Erro ao remover produtos no carrinho de compras");
		}
		
	}
	
	/**
	 * Metodo para fazer checkout carrinho de compras
	 * @param driver
	 * @param produto
	 * @throws Exception
	 */
	public void fazerCheckoutCarrinhoCompras(WebDriver driver) throws Exception {
		WebDriverWait wait = new WebDriverWait(driver, 18);
		CarrinhoComprasMap carrinhoMap = new CarrinhoComprasMap();
		try {
			WebElement elemento = wait.until(ExpectedConditions.elementToBeClickable(driver
					.findElement(By.xpath((carrinhoMap.criaElementoCheckoutPedido())))));
			elemento.click();

		} catch (Exception e) {
			throw new Exception("Erro ao clicar em fazer Checkout carrinho de compras");
		}
		
	}

}
