package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import maps.ResultadoDaBuscaMap;

public class ResultadoDaBuscaPage {

	/**
	 * Método criado para clicar em um resultado da busca
	 * 
	 * @param driver
	 * @param produto
	 * @throws Exception
	 */
	public void clicarProdutoBuscado(WebDriver driver, String produto) throws Exception {
		ResultadoDaBuscaMap resultadoBuscaMap = new ResultadoDaBuscaMap();

		try {
			WebElement elemento = driver
					.findElement(By.xpath((resultadoBuscaMap.criaElementoResultadoDaBusca(produto))));
			elemento.click();
		} catch (Exception e) {
			throw new Exception("Erro ao clicar no produto :" + produto);
		}
	}

}
