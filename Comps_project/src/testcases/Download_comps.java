package testcases;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

import operation.Getobjectclass;
import operation.UIoperations;

public class Download_comps extends Getobjectclass{
WebDriver driver;
public Download_comps(WebDriver driver)
{
	this.driver=driver;
	}

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
	
		default:
			break;
	}
	}
}
