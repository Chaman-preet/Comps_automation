package operation;

import java.net.URL;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;


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
		case "UPLOAD":


			driver.findElement(this.getObject(p, objectname, objectType)).sendKeys("C:\\Users\\sweta.kumari\\Downloads\\reference_data..xlsx");
   Thread.sleep(5000);

   driver.findElement(By.cssSelector("button.blueButton.UtSubmit"));
			break;

		case "SUBMIT":
            System.out.println("test submit method");
            
           // driver.findElement(By.cssSelector("button.blueButton.UtSubmit"));
			String s=driver.findElement(this.getObject(p, objectname, objectType)).getText();
			System.out.println("clicked on"+""+ s+" "+ "button");
		        driver.findElement(this.getObject(p, objectname, objectType)).click();
break;

		case "GetFileExtn":
			String s1=driver.findElement(this.getObject(p, objectname, objectType)).getAttribute("innerHTML");
			System.out.println(s1);
			String extn ="charu.txt";
			String fileExtensionName=extn.substring(extn.indexOf("."));

			if(fileExtensionName.equals(".txt"))
			{
				//verify message should be Invalid Extension


			}




			break;



		default:
			break;
		}
	}

}

