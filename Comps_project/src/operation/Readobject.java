package operation;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class Readobject {
	Properties p=new Properties();
public Properties getobjectrepository() throws IOException
{
	File src=new File("C:\\Comps_workspace\\Comps_project\\src\\objects\\object.properties");
	FileInputStream fs=new FileInputStream(src);
	p.load(fs);
	p.setProperty("managecomps", "MANAGE COMPS");
	p.setProperty("Team_arrow", "//span[@aria-owns='drp_Team_listbox']");
	p.setProperty("Team_select", "//div[@class='k-list-scroller']//ul[@id='drp_Team_listbox']//li[@data-offset-index='0']");
	p.setProperty("Template_arrow", "//span[@aria-owns='drp_Template_listbox']");
	p.setProperty("Template_select","//div[@class='k-list-scroller']//ul[@id='drp_Template_listbox']//li[text()='NY']");
	p.setProperty("UploadcompsTab", "Upload Comps");
	p.setProperty("upload", "attachment");
	p.setProperty("Sector_select", "//div[@class='k-list-scroller']//ul[@id='drp_Sector_listbox']/li[@data-offset-index='0']");
	p.setProperty("Subsector_arrow", "(//div[@class='k-multiselect-wrap k-floatwrap'])[1]");
	p.setProperty("Subsector_select", "//div[@class='k-list-scroller']//ul[@id='MulSel_SubSector_listbox']//li[text()='Retail']");
	p.setProperty("Portfolio_arrow", "(//div[@class='k-multiselect-wrap k-floatwrap'])[2]");
	p.setProperty("Portfolio_Select", "//div[@class='k-list-scroller']//ul[@id='MulSel_Portfolio_listbox']//li[text()='Apparel Manufacturers']");
	p.setProperty("Select_pages", "//div[@id='selectallpages']");
	p.setProperty("Subsector_select2","//div[@class='k-list-scroller']//ul[@id='MulSel_SubSector_listbox']//li[text()='Consumer']" );
	p.setProperty("Portfolio_Select2", "//div[@class='k-list-scroller']//ul[@id='MulSel_Portfolio_listbox']//li[text()='Beer']");
	p.setProperty("Remove_portfolio", "(//div[@class='k-widget k-multiselect k-header']//span[@class='k-icon k-i-close'])[2]");
	p.setProperty("count_message", "//div[@class='k-pager-wrap k-grid-pager k-widget k-floatwrap']//span[@class='k-pager-info k-label']");
	
	return p;
	}
}
