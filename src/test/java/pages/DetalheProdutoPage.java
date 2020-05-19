package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import maps.DetalheProdutoMap;
import maps.HomeMap;

public class DetalheProdutoPage {
	
	/**
	 * Metoodo para adicionar produto ao carrinho de compras
	 * 
	 * @param driver
	 * @throws Exception
	 */
	public void adicionarAoCarrinho(WebDriver driver) throws Exception {
		DetalheProdutoMap adicionaCarrinho = new DetalheProdutoMap();
		try {
			WebElement elemento = driver.findElement(By.xpath((adicionaCarrinho.criaBotaoAdicionarCarrinho())));
			elemento.click();
		} catch (Exception e) {
			throw new Exception("Erro ao adicionar produto no carrinho de compras elemento: " + adicionaCarrinho);
		}
	}
	
	/**
	 * Metoodo para abrir carrinho de compras
	 * 
	 * @param driver
	 * @throws Exception
	 */
	public void abrirCarrinhoCompras(WebDriver driver) throws Exception {
		WebDriverWait wait = new WebDriverWait(driver, 18);
		DetalheProdutoMap adicionaCarrinho = new DetalheProdutoMap();
		try {
			WebElement elemento =wait.until(ExpectedConditions.elementToBeClickable( driver.findElement(By.xpath((adicionaCarrinho.criaElementoAbrirCarrinhoCompras())))));
			elemento.click();
		} catch (Exception e) {
			throw new Exception("Erro ao abrir carrinho de compras elemento: " + adicionaCarrinho);
		}
	}
}
