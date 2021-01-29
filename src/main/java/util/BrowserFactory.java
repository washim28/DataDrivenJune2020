package util;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class BrowserFactory {
	
	static WebDriver driver;
	
	public static WebDriver init() {
		System.setProperty("webdriver.chrome.driver", "drivers\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("https://www.techfios.com/billing/?ng=login/");
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		return driver;
			
	}
	
	public static void tearDown() {
		driver.close();
		driver.quit();
	}

}
