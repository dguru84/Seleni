package LoggerExample;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

public class ju {

	public static void main(String[] args)
		
		WebDriver driver = new FirefoxDriver();
		
		driver.get("https://login.yahoo.com/?.src=ym&.intl=us&.lang=en-US&.done=https%3a//mail.yahoo.com");
		

		driver.findElement(By.xpath="login-username");
		
		//driver.switchTo().frame(1);
		
		System.out.println("1");
		
		pomju pj = new pomju(driver);	

		System.out.println("2");
		
		driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@id='mbr-login-ad-rich-frame']")));
		
		System.out.println("3");
		
		Actions ac = new Actions(driver);
		
		ac.moveToElement(pj.close).contextClick().perform();
		
		System.out.println("4");
		
	}




	
	
}
