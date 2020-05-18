package scenarios;

import java.io.IOException;
import java.util.Properties;

import org.apache.log4j.Logger;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.cucumber.core.api.Scenario;
import pages.HomePage;
import utils.LeitorDadosTeste;
import utils.PropertiesReader;

public class ScriptTesteEcommerce {	
	private static final Logger logger = Logger.getLogger(ScriptTesteEcommerce.class);
	public PropertiesReader properties = new PropertiesReader();
	Properties prop;
	public LeitorDadosTeste dadosTeste  = new LeitorDadosTeste();
	private WebDriver driver;

	@Before
	public void beforeTest() throws Exception {
		prop = properties.getProp();
		
//		logger.info("-- Inicio da Execução Cenário: " + scenario.getName());
		inicializarChromeDriver();
		logger.info("URL: "+ dadosTeste.getData("url"));
		
	}
	
	@Test
	public void script() {
		
		try {
			abrirUrl(dadosTeste.getData("url"));
			pesquisarProdutoHome(dadosTeste.getData("produto1"));
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	/**
	 * Pesquisar produto HOME
	 * @param produto
	 * @throws Exception
	 */
	public void pesquisarProdutoHome(String produto) throws Exception {
		HomePage home = new HomePage();
		home.pesquisarProduto(driver, produto);
			
	}

	/**
	 * Método para abrir uma URL enviada
	 * @param url
	 */
	private void abrirUrl(String url) {
		driver.get(url);
	}
	
	/**
	 * Inicializa ChromeDriver	
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
