package SampleTest.SampleTest;


import org.testng.annotations.AfterMethod;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.Assert;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;


public class SauceLabTest{
	WebDriver driver;

	@BeforeMethod
	@BeforeSuite
	 void setUp() throws Exception {
		
		System.setProperty("webdriver.chrome.driver","D:\\Software\\chromedriver.exe");
		ChromeOptions option = new ChromeOptions();
		option.addArguments("disable-infobars");
		driver = new ChromeDriver(option);
		driver.get("https://www.ebay.com/");
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
				
	}
	@Test
	public void test01_getPageHeader() {
		String title = driver.getTitle();
		System.out.println(title);
	//	driver.findElement(By.xpath("//input[@class='gh-tb ui-autocomplete-input']")).sendKeys("Java");
	//	driver.findElement(By.xpath("//input[@id='gh-ac']")).sendKeys("Java");
		//driver.findElement(By.xpath("//input[contains(@class, 'gh-tb')]")).sendKeys("Java");
	//	driver.findElement(By.xpath("//a[contains(text(), 'My eBay')]")).click();
		
		List<WebElement> listWeb = driver.findElements(By.tagName("a"));
		System.out.println("Link Count " + listWeb.size());
		
		
				
		
		
		//Assert.assertEquals(title, "Welcome");	
	}
	
	@AfterSuite
	void tearDown() throws Exception {
		driver.quit();
	}

}
