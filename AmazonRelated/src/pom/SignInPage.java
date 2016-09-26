package pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SignInPage {
	
	@FindBy(id = "ap_email")
	private WebElement unTB;
	
	public SignInPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	public boolean userNameInputBoxIsDisplayed()
	{
		//checking whether the SIgnIn button is displayed with the username input button
		return unTB.isDisplayed();
	}
	

}
