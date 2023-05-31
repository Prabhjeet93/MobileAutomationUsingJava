package testcases;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestFindingElements {

	public static void main(String[] args) throws InterruptedException {

		 WebDriver driver = WebDriverManager.chromedriver().create();
		//WebDriverManager.firefoxdriver().setup();
		//WebDriver driver = new FirefoxDriver();
		driver.get("http://gmail.com");

		// driver.manage().window().maximize();
		/*
		 * Options opt = driver.manage(); Window win = opt.window(); win.maximize();
		 */

		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

		/*
		 * WebElement username = driver.findElement(By.id("identifierId"));
		 * username.sendKeys("java@way2automation.com");
		 * 
		 * WebElement btn =
		 * driver.findElement(By.xpath("//*[@id=\"identifierNext\"]/div/button/span"));
		 * btn.click();
		 * 
		 * 
		 * WebElement pass =
		 * driver.findElement(By.xpath("//*[@id=\"password\"]/div[1]/div/div[1]/input"))
		 * ; pass.sendKeys("dfsdfsfd");
		 */

		driver.findElement(By.id("identifierId")).sendKeys("w2ajava@way2automation.com");
		driver.findElement(By.xpath("//*[@id=\"identifierNext\"]/div/button/span")).click();

		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(
				"/html/body/div[1]/div[1]/div[2]/div/div[2]/div/div/div[2]/div/div[1]/div/form/span/section/div/div/div[1]/div[1]/div/div/div/div/div[1]/div/div[1]/input")))
				.sendKeys("sdfsdfsf");

		// driver.findElement(By.xpath("/html/body/div[1]/div[1]/div[2]/div/div[2]/div/div/div[2]/div/div[1]/div/form/span/section/div/div/div[1]/div[1]/div/div/div/div/div[1]/div/div[1]/input")).sendKeys("dfsdfsfd");
		driver.findElement(By.xpath("//*[@id=\"passwordNext\"]/div/button/span")).click();

		System.out.println(driver.findElement(By.xpath(
				"//*[@id=\"view_container\"]/div/div/div[2]/div/div[1]/div/form/span/section/div/div/div[1]/div[2]/div[2]/span"))
				.getText());

		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
