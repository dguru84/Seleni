package LoggerExample;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class pomju {
	
	WebDriver driver;
	
	@FindBy(xpath="//div[@id='fdb_close_RICH']/div")
	public WebElement close;
	
	public pomju(WebDriver driver)
	
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public void clickCLose()
	{
		close.click();
	}
	
}
