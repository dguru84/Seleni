package scripts;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

import pom.HomePage;
import pom.ItemsSearchedPage;
import utili.Excel;

public class verifyItemSearchOnHomePage extends SuperTest {
	
	@Test(priority=1, enabled=true)
	public void testVerifyHomePage()
	{
		HomePage hp = new HomePage(driver);
		Reporter.log("Checking whether is home page is displayed", true);
		
		Assert.assertTrue(hp.isHomePage());
		Reporter.log("Yup, home page is correctly displayed", true);
			
	}
	
	@Test(priority=2, enabled=true)
	public void testSearchProduct()
	{
		String sheet = "verifyItemSearchOnHomePage";
		Reporter.log("Trying to get the item name from the Excel..");
		String cellValue = Excel.getCellValue(sheet, 4, 0);
		Reporter.log("Received item name is : "+cellValue, true);
		
		HomePage hp = new HomePage(driver);
		Reporter.log("Searching the item: "+cellValue, true);
		hp.searchAnItem(cellValue);
		Reporter.log("Item searching is performed ", true);
	
		Reporter.log("Trying to see whether we are in Item search list page..", true);
		ItemsSearchedPage isp = new ItemsSearchedPage(driver);
		Assert.assertTrue(isp.isItemsListPage());
		Reporter.log("Yes, item search list page is displayed", true);			
	}
	

	
	

}
