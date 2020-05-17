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
		inicializarChromeDriver(prop);
		logger.info("URL: "+ dadosTeste.getData("url"));
		
	}
	
	@Test
	public void script() {
		driver.get(dadosTeste.getData("url"));
	}
	
	/**
	 * Inicializa ChromeDriver	
	 * @throws IOException
	 */
	private void inicializarChromeDriver(Properties prop) throws IOException {
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
