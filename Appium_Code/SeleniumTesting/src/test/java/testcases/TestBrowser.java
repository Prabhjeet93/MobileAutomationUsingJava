package testcases;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestBrowser {
	
	public static String browser = "chrome";
	public static WebDriver driver;


	public static void main(String[] args) {
		
		
		//ChildClass1 c1 = new ChildClass1()
		//ChildClass2 c2 = new ChildClass2();
		//ParentClass p1 = new ChildClass2();
		//ParentClass p2 = new ChildClass1();
		
		//WebDriverManager.chromedriver().create();
		
		if(browser.equals("chrome")) {
			
;			WebDriverManager.chromedriver().setup();
			 driver = new ChromeDriver();
			
			
		}else if(browser.equals("firefox")){
			
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
			
		}
		
		
		
		driver.get("http://gmail.com");
		
		
		driver.getTitle().length();
		
		String actualTitle = driver.getTitle();
		System.out.println(actualTitle.length());
		
		String expectedTitle = "Yahoo.com";
		
		
		
		if(actualTitle.equals(expectedTitle)) {
			
			System.out.println("Test case pass");
		}else {
			
			System.out.println("Test case failed");
		}
		
		
		
		
		//driver.close(); //current window
		driver.quit(); //current window + all openend window / tabs in current session only
		
		
	}

}
