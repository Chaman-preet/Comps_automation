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
		File src=new File("C:\\Users\\sweta.kumari\\git\\Compsbuilder\\Comps_project\\src\\objects\\object.properties");
		FileInputStream fs=new FileInputStream(src);
		p.load(fs);
	//	p.setProperty("managecomps", "MANAGE COMPS");
		
		p.setProperty("submitbtn","button.blueButton.UtSubmit");
		p.setProperty("filename","html//body//div[2]//div//div//div//div[3]//div[6]//div//div[2]//div//div//div//table//tbody//tr[2]//td[1]");
		return p;
		}
}
