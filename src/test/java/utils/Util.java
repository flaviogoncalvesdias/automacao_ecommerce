package utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class Util {

	public static void main(String[] args) {
		Properties prop = null;

		try {
			prop = getDriverPath();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(prop.getProperty("prop.chromedriver.path"));
	}

	/**
	 * Metodo para leitura das propriedades
	 * 
	 * @return
	 * @throws IOException
	 */
	public static Properties getDriverPath() throws IOException {
		Properties props = new Properties();
		FileInputStream file = new FileInputStream("./src/test/resources/config.properties");
		props.load(file);
		return props;

	}
}
