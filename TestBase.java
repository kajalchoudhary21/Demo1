package Com.PlayStore.qa.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import Com.PlayStore.qa.utils.TestUtils;

public class TestBase {
	
	public static WebDriver driver;
	public static Properties prop;
	
	public TestBase() throws Exception {
		
		prop = new Properties();
		try {
			FileInputStream fis = new FileInputStream(System.getProperty("C:\\Users\\ABCD\\eclipse-workspace\\PlayStoreTest\\src\\main\\java\\Com\\PlayStore\\qa\\Config\\config.properties"));
		    prop.load(fis);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public static void initialization() {
		
		String browserName = prop.getProperty("browser");
		
		if (browserName.equals("chrome"));
		{
			System.setProperty("Webdriver.chrome.driver", "");
			driver = new ChromeDriver();
		}
		
		if (browserName.equals("Firefox")) {
			System.setProperty("Webdriver.gecko.driver", "");
			 driver = new FirefoxDriver();
			
		}
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(TestUtils.Implicit_Wait, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(TestUtils.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
		
		String url = prop.getProperty("url");
		driver.get(url);
		
		
	}
	

}
