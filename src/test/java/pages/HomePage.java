package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import maps.HomeMap;

public class HomePage {
	
	
	/**
	 * Metoodo para clicar no campo de busca
	 * @param driver
	 * @throws Exception
	 */
	public void clicarAreaDeBusca(WebDriver driver) throws Exception {
		HomeMap homeMap = new HomeMap();
		try {
			WebElement elemento = driver
					.findElement(By.xpath((homeMap.criaElementoCampoBusca())));
			elemento.click();
		} catch (Exception e) {
			throw new Exception("Erro ao clicar no campo de busca: " + homeMap);
		}
	}
	
	/**
	 * Metoodo para digitar no campo de busca
	 * @param driver
	 * @throws Exception
	 */
	public void digitarProduto(WebDriver driver, String produto) throws Exception {
		HomeMap homeMap = new HomeMap();
		try {
			WebElement elemento = driver
					.findElement(By.xpath((homeMap.criaElementoCampoBusca())));
			elemento.sendKeys(produto);
			elemento.submit();
		} catch (Exception e) {
			throw new Exception("Erro ao digitar no campo de busca: " + homeMap +" - "+ produto);
		}
	}
	
	/**
	 * Metodo para Pesquisar um produto na HomePage
	 * @param driver
	 * @param produto
	 * @throws Exception
	 */
	public void pesquisarProduto(WebDriver driver, String produto) throws Exception {
		clicarAreaDeBusca(driver);
		digitarProduto(driver, produto);		
		
	}
	
	

}
