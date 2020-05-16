package scenarios;

import java.io.IOException;

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
	public LeitorDadosTeste dadosTeste  = new LeitorDadosTeste();
	private WebDriver driver;

	@Before
	public void beforeTest() throws Exception {
//		logger.info("-- Inicio da Execução Cenário: " + scenario.getName());
		inicializarChromeDriver();
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
	private void inicializarChromeDriver() throws IOException {
		System.setProperty("webdriver.chrome.driver", properties.getDriverPath());
		ChromeOptions chromeOptions = new ChromeOptions();
//		chromeOptions.addArguments("--start-maximized");
		driver = new ChromeDriver(chromeOptions);
	}
	
	

}
