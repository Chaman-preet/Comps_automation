package operation;

import java.util.Properties;
import java.util.concurrent.TimeUnit;

import junit.framework.Assert;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import operation.browser_Selection;

public class UIoperations extends Getobjectclass {
WebDriver driver;
public UIoperations(WebDriver driver)
{
	this.driver=driver;
}

@SuppressWarnings("deprecation")
public void perform(Properties p,String operation,String objectname,String objectType,String value) throws Exception
{
//System.out.println("manage value " +p.getProperty("managecomps"));
switch(operation.toUpperCase())
{
case "OPENBROWSER":
	browser_Selection bs=new browser_Selection();
	bs.setup(value);
	break;
	
case "CLICK":
driver.findElement(this.getObject(p, objectname, objectType)).click();
break;
case "SETTEXT":
	driver.findElement(this.getObject(p, objectname, objectType)).sendKeys(value);
break;

case "GOTOURL":
	driver.get(p.getProperty(value));
	break;
	
case "IMPLICITWAIT":
	driver.manage().timeouts().implicitlyWait(80,TimeUnit.SECONDS);
	break;
case "EXPLICITWAIT":
	WebDriverWait wait= new WebDriverWait(driver, 3000);
	wait.until(ExpectedConditions.visibilityOf(driver.findElement(this.getObject(p, objectname, objectType))));
	break;
case "DRIVERWAIT":
	try
	{
		  long time = (long)Double.parseDouble(value);
	        Thread.sleep(time*1000L);}
	catch (NumberFormatException e){
	       System.out.println("not a number"); }
//	Thread.sleep(2000);
	break;
	
case "VERIFY":
	String element = driver.findElement(this.getObject(p, objectname, objectType)).getAttribute("innerHTML");
	try{
	Assert.assertEquals(value, element);}
	catch(Exception e)
	{
		System.out.println("Data do not matches and give exception- " +e.getMessage());
	}
	break;
	
case "SCROLL":
	JavascriptExecutor jse=(JavascriptExecutor)driver;
	jse.executeScript("window.scrollBy(0,450)", "");
	break;
	
case "CLOSE":
	driver.close();
	break;
	

	
default:
		break;
}
	}
}
