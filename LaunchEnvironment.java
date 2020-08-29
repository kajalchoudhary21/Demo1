package Org.SeleniumFramework.appModule;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import Org.SeleniumFramework.Reoprts.Log;
import Org.SeleniumFramework.Reoprts.Reports;

public class LaunchEnvironment {
	
	public static WebDriver driver;
	
	public static boolean flag;
	
	/**
	 * @author kajal
	 * @param Browser
	 * @return
	 */

	public static boolean launchbrowser(String Browser) {
		
		flag = false;
		Log.info("Provided browser is " +Browser);
		
		try {
		if(Browser.equalsIgnoreCase("Chrome")) {
		
			System.setProperty("Webdriver.chrome.driver", "path");
			 driver = new ChromeDriver();
			 driver.manage().window().maximize();
			 driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS );
			 
			 flag = true;
		}
		
		else if (Browser.equalsIgnoreCase("FF")) {
			System.setProperty("Webdriver.gecko.driver", "path");
			 driver = new FirefoxDriver();
			 driver.manage().window().maximize();
			 driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS );
			 
			 flag = true;
			
		}
		else {
			Log.info("Invalid data provided");
		}
		}catch(Exception e) {
			e.printStackTrace();
			Log.info(e.fillInStackTrace().toString());
			Reports.info("Browser Invocation", e.fillInStackTrace().toString());
		}
		
		
		return false;
		
	}
	/**
	 * @author kajal
	 * @param URL
	 * @return
	 */
	
	public static boolean launchURL(String URL) {
		flag = false;
	    Log.info("Provided URL is " +URL);
	    
	    try {
	    	driver.get(URL);
	    	flag = true;
	    } catch (Exception e) {
	    	e.printStackTrace();
	    	Log.info(e.fillInStackTrace().toString());
	    	Reports.info("Url Invocation", e.fillInStackTrace().toString())	;
	    }
				
		return flag;
		
	}

	private static void closebrowser() {
		driver.close();
		
	}
}
