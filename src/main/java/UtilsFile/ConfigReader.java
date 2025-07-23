package UtilsFile;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {

	private Properties prop;
	
	/**
	 * Method loads the properties from config.properties file
	 * @return
	 */
	public Properties init_prop() {
		prop = new Properties();
		FileInputStream ip;
		try {
			ip = new FileInputStream("./scr/test/resource/ConfigFile/Config.properties");
			prop.load(ip);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return prop;	
	}
}
