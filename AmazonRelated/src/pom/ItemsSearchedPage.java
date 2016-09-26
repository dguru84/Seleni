package pom;

import java.util.Set;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;

public class ItemsSearchedPage {
	
	WebDriver driver;
	
	@FindBy(id="sort")
	private WebElement sortByList;
	
	@FindBy(xpath="//li[@id='result_0']//h2")
	private WebElement firstItem;
	
	public ItemsSearchedPage(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public void sortByPopularity()
	{
		//Selecting the Popular option from the drop down list
		Select select = new Select(sortByList);
		Reporter.log("Trying to select..the sort by menu");
		select.selectByValue("popularity-rank");
		Reporter.log("Sorted by 'Popularity' ");
	}
	
	public void selectFirstItem()
	{
		//clicking on the first product available on the search result page
		firstItem.click();
	}
	
	public String getWindowHandleParent()
	{
		//returns the main window's window_handle name
		return driver.getWindowHandle();
	}
	
	public boolean isItemsListPage()
	{
		//checking the loading_complete status of the product page which is being searched
		return sortByList.isDisplayed();
	}
	
	public void switchToNewWindow()
	{
		//using this method navigating to the newly launched tab/window
		Set<String> winHandles = driver.getWindowHandles();
		for (String newWindow: winHandles)
		{
			driver.switchTo().window(newWindow);
		}
	}
	
	public boolean isFirstItemDisplayed()
	{
		//checking whether the first item is loaded on the page
		WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.elementToBeClickable(firstItem));
		return firstItem.isDisplayed();
		
	}
	
	
	
	

}
