package utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class PropertiesReader {

	/**
	 * Metodo para leitura das propriedades
	 * 
	 * @return
	 * @throws IOException
	 */
	public Properties getProperties() throws IOException {
		Properties props = new Properties();
		FileInputStream file = new FileInputStream("./src/test/resources/config.properties");
		props.load(file);
		return props;

	}

	/**
	 * Retorna o path do chromeDriver
	 * 
	 * @param prop
	 * @return
	 * @throws IOException
	 */
	public String getDriverPath(Properties prop) throws IOException {
		return prop.getProperty("prop.chromedriver.path");

	}

	/**
	 * Retorna o path do json de dados de Testes
	 * 
	 * @param prop
	 * @return
	 * @throws IOException
	 */
	public String getDadosPath(Properties prop) throws IOException {
		return prop.getProperty("prop.dados");

	}

}
