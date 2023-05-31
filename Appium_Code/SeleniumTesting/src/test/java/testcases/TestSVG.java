package testcases;

import java.time.Duration;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestSVG {

	public static void main(String[] args) {

		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		
		driver.get("https://www.covid19india.org/");
		
		
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
	//	wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"root\"]/div/div[2]/div[1]/div[4]/div[2]/div/div[9]/div[1]"))).click();
		//driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div[1]/div[4]/div[2]/div/div[9]/div[1]")).click();
		
		List<WebElement> graphPoints = driver.findElements(By.xpath("(//*[name()='svg' and @preserveAspectRatio='xMidYMid meet'])[6]//*[local-name()='circle']"));
 
		Actions action = new Actions(driver);
		for(WebElement point: graphPoints) {
			
			action.moveToElement(point).perform();
			System.out.println(driver.findElement(By.xpath("//div[@class='stats is-confirmed']/div/h2")).getText());
			
			
		}
		
	}

}
