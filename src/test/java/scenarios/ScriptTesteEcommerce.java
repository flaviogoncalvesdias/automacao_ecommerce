package scenarios;

import static org.junit.Assert.assertTrue;

import java.io.IOException;
import java.util.Properties;

import org.apache.log4j.Logger;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.cucumber.core.api.Scenario;
import io.cucumber.java.After;
import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.Então;
import io.cucumber.java.pt.Quando;
import pages.HomePage;
import pages.ResultadoDaBuscaPage;
import utils.LeitorDadosTeste;
import utils.PropertiesReader;

public class ScriptTesteEcommerce {
	private static final Logger logger = Logger.getLogger(ScriptTesteEcommerce.class);
	public PropertiesReader properties = new PropertiesReader();
	Properties prop;
	public LeitorDadosTeste dadosTeste = new LeitorDadosTeste();
	private WebDriver driver;

	@io.cucumber.java.Before
	public void beforeTest(Scenario scenario) throws Exception {
		prop = properties.getProp();

		logger.info("-- Inicio da Execução Cenário: " + scenario.getName());
		logger.info("URL: " + dadosTeste.getData("url"));
		inicializarChromeDriver();

	}

	@After
	public void afterTest() {
		driver.quit();
	}

	@Dado("que o usuário esteja na pagina inicial")
	public void que_o_usuário_esteja_na_pagina_inicial() {
		try {
			abrirUrl(dadosTeste.getData("url"));

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Quando("realizar uma busca pelo produto")
	public void realizar_uma_busca_pelo_produto() {
		try {
			pesquisarProdutoHome(dadosTeste.getData("produto1"));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Então("validar se produto retornou no resultado da busca: {string}")
	public void validar_se_produto_retornou_no_resultado_da_busca(String string) {
		try {
			validarProdutoPesquisado("Celular Apple iPhone XS Max 64GB 4G iOS 13 Tela 6");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void validarProdutoPesquisado(String produtoPesquisado) throws Exception {
		ResultadoDaBuscaPage resultadoBuscaPage = new ResultadoDaBuscaPage();
		assertTrue(resultadoBuscaPage.validarProdutoPesquisado(driver, produtoPesquisado));
	}

	/**
	 * Pesquisar produto HOME
	 * 
	 * @param produto
	 * @throws Exception
	 */
	public void pesquisarProdutoHome(String produto) throws Exception {
		HomePage home = new HomePage();
		home.pesquisarProduto(driver, produto);

	}

	/**
	 * Método para abrir uma URL enviada
	 * 
	 * @param url
	 */
	private void abrirUrl(String url) {
		driver.get(url);
	}

	/**
	 * Inicializa ChromeDriver
	 * 
	 * @throws IOException
	 */
	private void inicializarChromeDriver() throws IOException {
		System.setProperty("webdriver.chrome.driver", "chromedriver");
		ChromeOptions chromeOptions = new ChromeOptions();
		chromeOptions.addArguments("--start-maximized");
		driver = new ChromeDriver(chromeOptions);
	}

	/**
	 * Retorna o path do chromeDriver
	 * 
	 * @param prop
	 * @return
	 * @throws IOException
	 */
	public String getDriverPath(Properties props) throws IOException {
		return props.getProperty("prop.chromedriver.path");

	}

	/**
	 * Retorna o path do json de dados de Testes
	 * 
	 * @param prop
	 * @return
	 * @throws IOException
	 */
	public String getDadosPath(Properties props) throws IOException {
		return props.getProperty("prop.dados");

	}

}
