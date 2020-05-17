package utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class PropertiesReader {
	
	public Properties getProp() throws IOException {
        Properties props = new Properties();
        FileInputStream file = new FileInputStream(
                "./src/test/resources/config.properties");
        props.load(file);
        return props;
 
    }

}
