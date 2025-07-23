package DriverFactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DriverFactory {

	public WebDriver driver;
	public static ThreadLocal <WebDriver> tlDriver = new ThreadLocal<>();

	/**
	 * Method initialize the given browser
	 * @param browser
	 * @return
	 */
	public WebDriver init_driver(String browser) {
		System.out.println("Brower value is = " + browser);
		
		if(browser.equals("chrome")) {
			WebDriverManager.chromedriver().setup();
			tlDriver.set(new ChromeDriver());
		}else if(browser.equals("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			tlDriver.set(new FirefoxDriver());
		}else {
			System.out.println("Enter valid browser");
		}
		
		getDriver().manage().deleteAllCookies();
		getDriver().manage().window().maximize();
		return getDriver();
		
		}
	
	
	/**
	 * Method to get driver with thread local
	 * @return
	 */
	 public static synchronized WebDriver getDriver() {
		 return tlDriver.get();
	 }
}
