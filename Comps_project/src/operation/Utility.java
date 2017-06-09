package operation;

import java.io.File;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class Utility {
	public static void capturescreenshot(WebDriver driver, String screenshotname)
	{
		try
		{
			File scr = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(scr, new File("C:\\Users\\chaman.preet\\Desktop\\screenshot\\Comps Builder\\Fail\\"+screenshotname+".png"));
		System.out.println("Screenshot captured");
		}
		catch(Exception e)
		{
			System.out.println("Exception while taking screenshot" +e.getMessage());
		}
	}

}
