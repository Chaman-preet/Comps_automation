package testcases;

import java.util.Properties;

import junit.framework.Assert;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import operation.Getobjectclass;
import operation.UIoperations;

public class Download_comps extends Getobjectclass{
WebDriver driver;
public Download_comps(WebDriver driver)
{
	this.driver=driver;
	}

@SuppressWarnings("deprecation")
public void download(Properties p,String operation,String objectname,String objectType,String value) throws Exception
{
	switch(operation.toUpperCase())
	{
	case "Select":
		Select myselect=new Select(driver.findElement(this.getObject(p, objectname, objectType)));
		//String dropdownvalue=String.valueOf(value);
		//myselect.selectByIndex(value);
		myselect.selectByVisibleText(value);
	break;
	
	case "VERIFYELEMENTPRESENT":
		WebElement element = driver.findElement(this.getObject(p, objectname, objectType));
			if(element.isDisplayed())
			{
				System.out.println("Mentioned element is present" +element.getAttribute("innerHTML"));
			}
			else{
				System.out.println("Element is not present");}
		break;
	
	case "Gettext":
		String pagecount = driver.findElement(this.getObject(p, objectname, objectType)).getAttribute("innerHTML");
	System.out.println("Count is " +pagecount);
	break;
		default:
			break;
	}
	}
}
