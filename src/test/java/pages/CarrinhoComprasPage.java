package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

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
	 * Metoodo para validar abertura da pagina Carrinho de compras
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
	 * @param driver
	 * @param produto
	 * @return
	 */
	public boolean validarProdutoCarrinhoCompras(WebDriver driver, String produto) {
		return driver.getPageSource().contains(produto);
	}

}
