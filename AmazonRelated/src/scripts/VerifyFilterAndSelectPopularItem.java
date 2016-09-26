package scripts;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

import pom.HomePage;
import pom.ItemsSearchedPage;
import pom.SearchedProductPage;
import pom.ShoppingCartPage;
import pom.SignInPage;
import utili.Excel;

public class VerifyFilterAndSelectPopularItem extends SuperTest {
	
	@Test(priority=1, enabled=true)
	public void testApplyingFilterAndSelectingPopular()
	{
		Reporter.log("Starting again..", true);
		String sheet = "verifyItemSearchOnHomePage";
		String cellValue = Excel.getCellValue(sheet, 4, 0);
		Reporter.log("Product name: "+cellValue, true);
		
		Reporter.log("Initializing the homePage", true);
		HomePage hp1 = new HomePage(driver);
		hp1.searchAnItem(cellValue);
		Reporter.log("Searched the product :"+cellValue, true);
	
		ItemsSearchedPage isp = new ItemsSearchedPage(driver);
		String ParentWindoHandle = isp.getWindowHandleParent();
		Reporter.log("Present windowHandle is: "+ParentWindoHandle, true);
		
		Reporter.log("Trying to sort the items by popularity..", true);
		isp.sortByPopularity();
		Reporter.log("Sorting by popularity is applied", true);
		
		Reporter.log("Checking whether the first item is visible?", true);
		isp.isFirstItemDisplayed();
		Reporter.log("FIrst item is listed", true);
		
		Reporter.log("Clicking on the first item..", true);
		isp.selectFirstItem();
		Reporter.log("First item is clicked..", true);
		
		isp.switchToNewWindow();
		Reporter.log("Switched to new Window", true);
		
		SearchedProductPage spp = new SearchedProductPage(driver);
		
		Reporter.log("Checking whether product detailed page is loaded..", true);
		Assert.assertTrue(spp.isAddToCartDisplayed());
		Reporter.log("Product page is loaded..", true);
		
		Reporter.log("Adding product to Cart..", true);
		spp.addProductToCart();
		Reporter.log("Added product to the Cart..!", true);
		
		ShoppingCartPage scp = new ShoppingCartPage(driver);
		
		Reporter.log("Checking whether the Shopping cart page is displayed..", true);
		Assert.assertTrue(scp.isCartPageDisplayed());
		Reporter.log("Shopping cart page is displayed..", true);
		
		Reporter.log("Clicking the checkout button..", true);
		scp.clickCheckoutButton();
		Reporter.log("Checkout button is clicked..", true);
		
		SignInPage sip = new SignInPage(driver);
		
		Reporter.log("Checking whether Sign in Page is displayed", true);
		Assert.assertTrue(sip.userNameInputBoxIsDisplayed());
		Reporter.log("Success!, sign in Page is displayed", true);
		
		Reporter.log("END OF TEST!", true);
		
	}

}
