package pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ShoppingCartPage {
	
	@FindBy(id="hlb-ptc-btn-native")
	private WebElement proceedToCheckoutButton;
	
	public ShoppingCartPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	public void clickCheckoutButton()
	{
		//Clicking the checkOut button
		proceedToCheckoutButton.click();
	}
	
	public boolean isCartPageDisplayed()
	{
		//checking whether the page is properly loaded with the Check out button
		return proceedToCheckoutButton.isDisplayed();
	}
	
	
	

}
