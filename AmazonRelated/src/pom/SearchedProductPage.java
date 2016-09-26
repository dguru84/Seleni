package pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SearchedProductPage {
	
	WebDriver driver; 
	
	@FindBy(id="add-to-cart-button")
	private WebElement addToCartButton;
	
	public SearchedProductPage(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public void addProductToCart()
	{
		//adds the selected product to the cart
		addToCartButton.click();
	}
	
	public boolean isAddToCartDisplayed()
	{
		//checking whether the Add_to_Cart button is visible/displayed
		return addToCartButton.isDisplayed();
	}
	

}
