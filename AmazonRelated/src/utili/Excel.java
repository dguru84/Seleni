package utili;

import java.io.FileInputStream;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.testng.Reporter;

import scripts.Consti;

public class Excel {
	
	public static String getCellValue(String Sheet, int row, int cell)
	{
		//To get the Value present in a cell of the Excel sheet
		String cellValue = "";
		try
		{
			FileInputStream fis = new FileInputStream(Consti.excelBook);
			Workbook wb = WorkbookFactory.create(fis);
			
			cellValue = wb.getSheet(Sheet).getRow(row).getCell(cell).toString();
			
		}
		catch(Exception e)
		{
			Reporter.log("Exception found. Unable to get the excel file.\n"+e.getMessage(), true);
		}
		return cellValue;
	}
	
	public static int getRowCount(String Sheet)
	{
		//to find the number of rows present in the excel sheet
		int rowCount = 0;
		try
		{
			FileInputStream fis = new FileInputStream(Consti.excelBook);
			Workbook wb = WorkbookFactory.create(fis);
			
			rowCount = wb.getSheet(Sheet).getLastRowNum();		
		}
		catch (Exception e)
		{
			Reporter.log("Exception found. Unable to get the excel file.\n"+e.getMessage(), true);
		}
		
		return rowCount;
		
	}
	

}
