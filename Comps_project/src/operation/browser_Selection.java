package operation;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Proxy.ProxyType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class browser_Selection {
	WebDriver driver;
	public void setup(String browser) throws Exception{
		//Check if parameter passed from TestNG is 'firefox'
		if(browser.equalsIgnoreCase("firefox")){
		//create firefox instance
			FirefoxProfile fp = new FirefoxProfile();
			fp.setPreference("network.proxy.type", ProxyType.AUTODETECT.ordinal());
			System.setProperty("webdriver.gecko.driver", "C:\\Users\\chaman.preet\\Downloads\\geckodriver.exe");
			driver=new FirefoxDriver(fp);
		}
		//Check if parameter passed as 'chrome'
		else if(browser.equalsIgnoreCase("chrome")){
			//set path to chromedriver.exe
			System.setProperty("webdriver.chrome.driver","C:\\Users\\chaman.preet\\Downloads\\chromedriver.exe");
			//create chrome instance
			driver = new ChromeDriver();
		}
		//Check if parameter passed as 'Internetexplorer'
				else if(browser.equalsIgnoreCase("InternetExplorer")){
					//set path to IE.exe
					System.setProperty("webdriver.InternetExplorer.driver","C:\\Users\\chaman.preet\\Downloads\\IEDriverServer.exe");
					//create Internetexplorer instance
					driver = new InternetExplorerDriver();
				}
		else{
			//If no browser passed throw exception
			throw new Exception("Browser is not correct");
		}
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}
	
}
