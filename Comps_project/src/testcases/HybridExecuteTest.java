package testcases;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.openqa.selenium.Proxy.ProxyType;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.firefox.internal.ProfilesIni;
import org.testng.ITestResult;
import org.testng.SkipException;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import operation.UIoperations;
import operation.Readobject;
import exportExcel.POIexcel;
import operation.Utility;

//@Listeners(testcases.Screenshot.class)

public class HybridExecuteTest 
{
	static WebDriver webdriver;

	@Test(dataProvider="hybridData")

	public void testlogin(String testcasename,String keyword, String objectname,String objectType,String value) throws Exception
	{
		//	if(runmode.equals('Y'))
		//	{
		if(testcasename!=null&&testcasename.length()!=0)
		{
			//System.setProperty("webdriver.chrome.driver", "C://Comps_workspace//Comps_project//Driver//driver path//chromedriver.exe");
			//webdriver=new ChromeDriver();
			FirefoxProfile fp = new FirefoxProfile();
			fp.setPreference("network.proxy.type", ProxyType.AUTODETECT.ordinal());
			System.setProperty("webdriver.gecko.driver", "C://Users//sweta.kumari//Downloads//selenium 3//geckodriver.exe");
			System.out.println("tst git  test command ");
			webdriver=new FirefoxDriver(fp);
			webdriver.manage().window().maximize();
		}
		Readobject robject=new Readobject();
		Properties allobjects=robject.getobjectrepository();
		UIoperations Uoperation=new UIoperations(webdriver);
		Uoperation.perform(allobjects, keyword, objectname, objectType, value);

		UploadComps objupload=new UploadComps(webdriver);
		objupload.upload(allobjects, keyword, objectname, objectType, value);
	}

	// else if(runmode.equals('N'))
	//{
	//	 System.out.println("test case skipped");
	//	 
	//	}



	@DataProvider(name="hybridData")
	public Object[][] getDatafromDataprovider() throws IOException
	{
		Object[][] object=null;
		POIexcel file=new POIexcel();


		XSSFSheet sheet=file.readexcel("C:\\Users\\sweta.kumari\\git\\Compsbuilder\\Comps_project", "TestCase.xlsx", "Comps");
		int rowcount=sheet.getLastRowNum()-sheet.getFirstRowNum();
		System.out.println("row count is" +rowcount);
		object=new Object[rowcount][5];
		for(int i=0;i<rowcount;i++)
		{
			XSSFRow row=sheet.getRow(i+1);
			for (int j = 0; j < row.getLastCellNum(); j++) {
				//Print excel data in console
				XSSFCell cell=row.getCell(j);
				object[i][j] = cell.toString();	
				System.out.println("values are"+" " +object[i][j]);
			}
		}
		System.out.println("");
		return object;    
	}

	public void teardown()
	{
		webdriver.close();
	}


	@AfterMethod
	public void screenshot(ITestResult result)
	{
		//	DateFormat format=new SimpleDateFormat("MM/dd/yyyy HH:mm:ss");
		//	Date date=new Date();
		//	String date1=format.format(date);
		//System.out.println("Current time is" +date1);

		if(ITestResult.SUCCESS==result.getStatus())
		{
			//		
			try 
			{
				TakesScreenshot ts=(TakesScreenshot)webdriver;
				File source=ts.getScreenshotAs(OutputType.FILE);
				FileUtils.copyFile(source, new File("./Screenshots/"+result.getName()+".png"));

				System.out.println("Screenshot taken");
				} 
			catch (Exception e)
			{

			System.out.println("Exception while taking screenshot "+e.getMessage());
			} 

			}
		}
	

		//String methodname1=result.getName().toString().trim();
		//		String methodname= result.getName()+ "-" + Arrays.toString(result.getParameters());
		//		Utility.capturescreenshot(webdriver, methodname);
	
}



