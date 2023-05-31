package testcases;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestDropdown {

	public static WebDriver driver;

	public static boolean isElementPresent(By by) {

/*		try {
			driver.findElement(by);
		} catch (Throwable t) {

			return false;
		}

		return true;
		
		*/
		
		
		int size = driver.findElements(by).size();
		
		
		if(size==0) {
			
			return false;
		}else {
			
			return true;
		}
		
		
	}

	public static void main(String[] args) {

		driver = WebDriverManager.chromedriver().create();
		driver.get("https://www.wikipedia.org/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
		/*
		 * English - US English - UK
		 */
		// driver.findElement(By.id("searchLanguage")).sendKeys("Eesti");

		System.out.println(isElementPresent(By.id("searchLanguage")));

		System.out.println(isElementPresent(By.xpath("//*[@id=\"search-form123\"]/fieldset/button/i")));
		/*
		 * WebElement dropdown = driver.findElement(By.id("searchLanguage")); Select
		 * select = new Select(dropdown);
		 * 
		 * //select.selectByVisibleText("Eesti"); select.selectByValue("hi");
		 * 
		 * List<WebElement> values = dropdown.findElements(By.tagName("option"));
		 * 
		 * System.out.println(values.get(0).getText());
		 * System.out.println(values.get(0).getAttribute("lang"));
		 * 
		 * System.out.println(values.size());
		 * 
		 * 
		 * for(int i=0; i<values.size(); i++) {
		 * 
		 * System.out.println(values.get(i).getText());
		 * 
		 * }
		 * 
		 * 
		 * System.out.println("-----Printing link-----");
		 * 
		 * WebElement section =
		 * driver.findElement(By.xpath("//*[@id=\"www-wikipedia-org\"]/div[7]/div[3]"));
		 * 
		 * 
		 * 
		 * 
		 * List<WebElement> links = driver.findElements(By.tagName("a"));
		 * 
		 * 
		 * System.out.println("Total links are : "+links.size());
		 * 
		 * 
		 * 
		 * for(WebElement link: links) {
		 * 
		 * 
		 * System.out.println(link.getText()+"--- URL IS ---"+link.getAttribute("href"))
		 * ;
		 * 
		 * }
		 * 
		 * 
		 * 
		 * 
		 * try { Thread.sleep(3000); } catch (InterruptedException e) { // TODO
		 * Auto-generated catch block e.printStackTrace(); }
		 * 
		 * 
		 */
	}

}
