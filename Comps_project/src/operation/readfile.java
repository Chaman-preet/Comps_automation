package operation;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import exportExcel.POIexcel;

public class readfile {
	
	public void readxlsx(String path, String filename, String sheetname,String runmode) throws IOException
	{
		ArrayList<String> list=new ArrayList<String>();
		FileInputStream fs=new FileInputStream(path);
	    XSSFWorkbook wb=new XSSFWorkbook(fs);
		XSSFSheet sheet=wb.getSheet(sheetname);
		Iterator<Row> rowIterator=sheet.rowIterator();
		while(rowIterator.hasNext())
		{
			Row row=rowIterator.next();
			Iterator<Cell> cellIterator=row.cellIterator();
			while(cellIterator.hasNext())
			{
				Cell cell=cellIterator.next();
						String c=cell.getStringCellValue();
				list.add(c);
				} 
			}
	}
}
