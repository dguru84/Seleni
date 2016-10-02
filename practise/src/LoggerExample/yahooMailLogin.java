package LoggerExample;

import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class yahooMailLogin {

	public static void main(String[] args) {

		WebDriver driver = new FirefoxDriver();
		
		driver.get("https://login.yahoo.com/?.src=ym&.intl=us&.lang=en-US&.done=https%3a//mail.yahoo.com");
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		
		System.out.println("--1--");
		
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("document.getElementById('fdb_close_RICH').click();");
		
		System.out.println("--2--");
		
		driver.switchTo().frame(1);
		//driver.findElement(By.id("login-username")).sendKeys(Keys.TAB);
		driver.findElement(By.xpath("//label[text()='Stay signed in'")).click();

		
		
		
		

	}

}
