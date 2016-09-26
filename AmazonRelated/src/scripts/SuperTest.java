package scripts;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.xml.XmlTest;

import utili.propertyFileParser;

public class SuperTest implements Consti {
	
	WebDriver driver;
	
	@BeforeMethod
	public void preCondition(XmlTest xmlTest)
	{
		String browserName = xmlTest.getParameter("browser");
		Reporter.log("browserName: "+browserName, true);
		
		if(browserName.equalsIgnoreCase("Chrome"))
		{
			System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
			driver = new ChromeDriver();
		}
		else if(browserName.equalsIgnoreCase("firefox"))
		{
			driver = new FirefoxDriver();
		}
		Reporter.log("Navigating to homePage URL", true);
		
		String pageURL = propertyFileParser.propReadMethod("amazon.mainUrl"); 
		Reporter.log("Page URL --> "+pageURL, true);
		
		driver.navigate().to(pageURL);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		Reporter.log("URL is loaded", true);
	}
	
	@AfterMethod
	public void CloseBrowser() throws IOException
	{
		Reporter.log("Closing the browser", true);
		driver.quit();
/*		File scr = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(scr, new File("./Screenshots/Screenshot1.png"));*/
	}

}
