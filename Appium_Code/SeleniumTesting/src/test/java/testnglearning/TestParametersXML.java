package testnglearning;

import java.util.Date;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestParametersXML {

	public WebDriver driver;
	
	@Parameters({"browser","url"})
	@Test
	public void browserTest(String browser, String url) throws InterruptedException {
		
		
		if(browser.equals("chrome")) {
			
			driver = WebDriverManager.chromedriver().create();
			
		}else if(browser.equals("firefox")) {
			
			driver = WebDriverManager.firefoxdriver().create();
		}
		//Date d = new Date();
		//System.out.println(browser+"---"+url+d.toString());
		//Thread.sleep(2000);
		driver.get(url);
		driver.manage().window().maximize();
		driver.findElement(By.name("q")).sendKeys("Hello Selenium on Browser : "+browser);
		Thread.sleep(2000);
	}
	
	
	
}
