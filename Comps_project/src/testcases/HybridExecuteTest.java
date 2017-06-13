package testcases;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
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
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import exportExcel.POIexcel;
import operation.UIoperations;
import operation.Readobject;
import operation.Utility;
import operation.readfile;

//@Listeners(testcases.Screenshot.class)

public class HybridExecuteTest extends readfile {
	static WebDriver webdriver;
	readfile rf=new readfile();
	
@Test(dataProvider="hybridData")
public void testlogin(String testcasename,String keyword,String objectname,String objectType,String value) throws Exception
{
	
	rf.readxlsx("C://Comps_workspace//Comps_project//src", "TestCase.xlsx", "Test cases");
if(rf.Runmode.equals("Y"))
	{
	if(testcasename!=null&&testcasename.length()!=0)
	{
		//System.setProperty("webdriver.chrome.driver", "C://Comps_workspace//Comps_project//Driver//driver path//chromedriver.exe");
		//webdriver=new ChromeDriver();
		FirefoxProfile fp = new FirefoxProfile();
		fp.setPreference("network.proxy.type", ProxyType.AUTODETECT.ordinal());
		System.setProperty("webdriver.gecko.driver", "C://Users//chaman.preet//Downloads//geckodriver.exe");
		webdriver=new FirefoxDriver(fp);
		webdriver.manage().window().maximize();
	}
		Readobject robject=new Readobject();
		Properties allobjects=robject.getobjectrepository();
		UIoperations Uoperation=new UIoperations(webdriver);
		Uoperation.perform(allobjects, keyword, objectname, objectType, value);
		Download_comps objdowm=new Download_comps(webdriver);
		objdowm.download(allobjects, keyword, objectname, objectType, value);
		//UploadComps objupload=new UploadComps(webdriver);
		//objupload.upload(allobjects, keyword, objectname, objectType, value);
}
		else if(rf.Runmode.equals("N"))
		   	{
		    		throw new SkipException("Test case is skipped as Run mode is N");
		  	}
}

@DataProvider(name="hybridData")
public Object[][] getDatafromDataprovider() throws IOException
{
	//readfile rf=new readfile();
	//rf.readxlsx("C://Comps_workspace//Comps_project", "TestCase.xlsx", "Test cases");
	Object[][] object=null;
	//POIexcel file=new POIexcel();
	FileInputStream fs=new FileInputStream("C://Comps_workspace//Comps_project//TestCase.xlsx");
    XSSFWorkbook wb=new XSSFWorkbook(fs);
	//XSSFSheet sheet1=file.readexcel("C://Comps_workspace//Comps_project//src", "TestCase.xlsx", "Test steps");
	XSSFSheet sheet1=wb.getSheet("Test steps");
	//XSSFSheet sheet=file.readexcel("C://Comps_workspace//Comps_project//src", "TestCase.xlsx", "Test cases");	
	//XSSFSheet sheet=file.readexcel("C://Comps_workspace//Comps_project//src", "TestCase.xlsx", "Test steps");
	int rowcount=sheet1.getLastRowNum()-sheet1.getFirstRowNum();
	System.out.println("row count is " +rowcount);
	int col_count=sheet1.getRow(1).getPhysicalNumberOfCells();
	
  System.out.println(" values are " +rf.TestCase +" desc " +rf.Description + " runmode " +rf.Runmode);
	object=new Object[rowcount][col_count];
//	 if(rf.Runmode.equals("Y"))
  //   {
	for(int i=0;i<rowcount;i++)
	{
		XSSFRow row=sheet1.getRow(i+1);  
		 for (int j = 0; j < row.getLastCellNum(); j++) {
	            //Print excel data in console
				XSSFCell cell=row.getCell(j);
	            object[i][j] = cell.toString();
	           System.out.println("values are " +object[i][j]);
	        }
	    }
	    System.out.println("");
  //   }
	//     else if(rf.Runmode.equals("N"))
	 //    	{
	  //   		throw new SkipException("Test case is skipped as Run mode is N");
	  //   	}
	     return object; 
	    }


/*public void execute_excel() throws IOException
{ int i = 0,j = 0;
	readfile rf=new readfile();
	rf.readxlsx("C://Comps_workspace//Comps_project//src", "TestCase.xlsx", "Test cases",1,2,"runmode");
	if(runmode.)
	
}*/
/*@DataProvider(name="hybridDatastep")
public Object[][] getDatafromDataprovider2() throws IOException
{
	Object[][] object=null;
	POIexcel file=new POIexcel();
	//XSSFSheet sheet=file.readexcel("C://Comps_workspace//Comps_project//src", "TestCase.xlsx", "Test cases");	
	XSSFSheet sheet=file.readexcel("C://Comps_workspace//Comps_project//src", "TestCase.xlsx", "Test steps");
	int rowcount=sheet.getLastRowNum()-sheet.getFirstRowNum();
	System.out.println("row count is " +rowcount);
	int col_count=sheet.getRow(1).getPhysicalNumberOfCells();
	object=new Object[rowcount][col_count];
	for(int i=0;i<rowcount;i++)
	{
		XSSFRow row=sheet.getRow(i+1);
		 for (int j = 0; j < row.getLastCellNum(); j++) {
	            //Print excel data in console
				XSSFCell cell=row.getCell(j);
	            object[i][j] = cell.toString();
	           System.out.println("values are " +object[i][j]);
	        }
	    }
	    System.out.println("");
	     return object;    
	    }

@DataProvider(name="hybridData")
public Object[][] getDatafromDataprovider() throws IOException {
	
	public static Object[] concat(Object[][] getDatafromDataprovider1(), Object[][] getDatafromDataprovider2()) {
        Object[] result = ArrayUtils.addAll(first, second);
        return result;
	
	
	
	
	  List<Object[]> result = Lists.newArrayList();
	  result.addAll(Arrays.asList(getDatafromDataprovider1()));
	  result.addAll(Arrays.asList(getDatafromDataprovider2()));
	//  System.out.println("sixe of array" +result.toArray(new Object[result.get(4)]));
	  return result.toArray(new Object[result.size()][]);
	 // return result.toArray(new Object[result.size()][]);
	
}*/

public void teardown()
{
	webdriver.close();
}

//@AfterMethod
public void screenshot(ITestResult result)
{
	DateFormat format=new SimpleDateFormat("MM/dd/yyyy HH:mm:ss");
	Date date=new Date();
	String date1=format.format(date);
	//System.out.println("Current time is" +date1);
	if(ITestResult.SUCCESS==result.getStatus())
	{
		String methodname1=result.getName().toString().trim();
		String methodname= result.getName()+ "-" + Arrays.toString(result.getParameters());
		Utility.capturescreenshot(webdriver, methodname);
	}
	}
	}
