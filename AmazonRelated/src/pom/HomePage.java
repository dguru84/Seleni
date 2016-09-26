package pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
	
	WebDriver driver;
	
	@FindBy(id="twotabsearchtextbox")
	private WebElement searchBox;
	
	@FindBy(xpath="//input[@value='Go']")
	private WebElement searchButton;
	
	public HomePage(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public void searchAnItem(String itemName)
	{
		//Searching the item on home page using the data available in the excel sheet
		searchBox.clear();
		searchBox.sendKeys(itemName);
		searchButton.click();
	}
	
	public boolean isHomePage()
	{
		//Making sure that the home page is displayed
		return searchBox.isDisplayed();
	}
	
	
		
}
