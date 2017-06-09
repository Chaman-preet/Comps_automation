package operation;

import java.util.Properties;
import java.util.concurrent.TimeUnit;

import junit.framework.Assert;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class UIoperations extends Getobjectclass {
WebDriver driver;
public UIoperations(WebDriver driver)
{
	this.driver=driver;
}

public void perform(Properties p,String operation,String objectname,String objectType,String value) throws Exception
{
//System.out.println("manage value " +p.getProperty("submitbtn"));
switch(operation.toUpperCase())
{
case "CLICK":
driver.findElement(this.getObject(p, objectname, objectType)).click();
break;
case "SETTEXT":
	driver.findElement(this.getObject(p, objectname, objectType)).sendKeys(value);
break;


case "GETTEXT":
	String s=driver.findElement(this.getObject(p,objectname,objectType)).getText();
	System.out.println(s);                          
break;


case "GOTOURL":
	driver.get(p.getProperty(value));
	break;
case "WAIT":
	
	Thread.sleep(50000);

	break;
	
case "Close":
	
	driver.close();

break;
	default:
		break;
}
	}
}
