package LoggerExample;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class PassportStatusCheck {

	public static void main(String[] args) 
	{
		WebDriver driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		
		driver.get("http://passportindia.gov.in/AppOnlineProject/welcomeLink");
		driver.manage().window().maximize();
		
		String xp1 = "//div[@class='main_button_typ_005']";
		driver.findElement(By.xpath(xp1)).click();
		
		WebElement optionsSelect = driver.findElement(By.id("optStatus"));
		
		Select select = new Select(optionsSelect);
		select.selectByIndex(1);
		
		driver.findElement(By.id("fileNo")).sendKeys("BN1069609877116");
		driver.findElement(By.id("applDob")).sendKeys("20/01/1956");
		
		driver.findElement(By.id("trackFile")).click();
		
		String xp2 = "//*[.='Status ']/../td[2]";
		
		String name = driver.findElement(By.xpath("//td[.='Given Name ']/../td[2]")).getText();
		String surname = driver.findElement(By.xpath("//td[.='Surname ']/../td[2]")).getText();
		String result = driver.findElement(By.xpath(xp2)).getText();
		
		System.out.println(name+" "+surname+"\nStatus: "+result);
		
		driver.navigate().back();
		
		driver.findElement(By.id("fileNo")).sendKeys("BN1069609982916");
		driver.findElement(By.id("applDob")).sendKeys("04/10/1988");
		
		driver.findElement(By.id("trackFile")).click();
		

		String name1 = driver.findElement(By.xpath("//td[.='Given Name ']/../td[2]")).getText();
		String surname1 = driver.findElement(By.xpath("//td[.='Surname ']/../td[2]")).getText();
		String result1 = driver.findElement(By.xpath(xp2)).getText();
		
		System.out.println("\n"+name1+" "+surname1+"\nStatus: "+result1);
		
		
		
		driver.close();
		
		
		
		

	}

}
