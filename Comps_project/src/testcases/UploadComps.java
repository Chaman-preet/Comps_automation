package testcases;

import java.util.Properties;

import operation.Getobjectclass;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class UploadComps extends Getobjectclass
{
	WebDriver driver;

	public UploadComps(WebDriver driver)
	{
		this.driver=driver;
	}
	public void upload(Properties p,String operation,String objectname,String objectType,String value) throws Exception
	{
	
		switch(operation.toUpperCase())
		{
		case "Upload":
			Thread.sleep(10000);
		driver.findElement(this.getObject(p, objectname, objectType)).click();
	/*	WebElement element = driver.findElement(this.getObject(p, objectname, objectType));
		//JavascriptExecutor js = (JavascriptExecutor) driver;
		((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView(false);", element);
		//js.executeScript("window.scrollBy(0,-250)", "");
		Thread.sleep(500); 
		
		


		element.click();*/
		break;
		
			default:
				break;
		}
			}
		
	}

