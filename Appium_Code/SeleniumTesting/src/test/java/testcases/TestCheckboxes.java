package testcases;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.Date;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestCheckboxes {

	public static FirefoxDriver driver;

	public static void captureScreenshot() throws IOException {

		Date d = new Date();
		String fileName = d.toString().replace(" ", "_").replace(":", "_") + ".jpg";

		File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(screenshot, new File("./screenshot/" + fileName));

	}

	public static void captureElementScreenshot(WebElement element) throws IOException {

		Date d = new Date();
		String fileName = d.toString().replace(" ", "_").replace(":", "_") + ".jpg";

		File screenshot = element.getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(screenshot, new File("./screenshot/Element_" + fileName));

	}

	public static boolean isElementPresent(By by) {

		/*
		 * try { driver.findElement(by); } catch (Throwable t) {
		 * 
		 * return false; }
		 * 
		 * return true;
		 * 
		 */

		int size = driver.findElements(by).size();

		if (size == 0) {

			return false;
		} else {

			return true;
		}

	}

	public static void main(String[] args) throws IOException {

		WebDriverManager.firefoxdriver().setup();
		driver = new FirefoxDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
		driver.get("http://www.tizag.com/htmlT/htmlcheckboxes.php");

		/*
		 * https://testng.org/testng-eclipse-update-site/6.14.3
		 * 
		 * int i=1; int count=0;
		 * 
		 * for (int i = 1; i <= 4; i++) {
		 * driver.findElement(By.xpath("//div[4]/input["+i+"]")).click(); }
		 * 
		 * while(isElementPresent(By.xpath("//div[4]/input["+i+"]"))) {
		 * driver.findElement(By.xpath("//div[4]/input["+i+"]")).click(); i++; count++;
		 * 
		 * 
		 * }
		 * 
		 * 
		 * System.out.println("Total checkboxes are : "+count);
		 * 
		 */

		WebElement section = driver
				.findElement(By.xpath("/html/body/table[3]/tbody/tr[1]/td[2]/table/tbody/tr/td/div[4]"));

		List<WebElement> checkboxes = section.findElements(By.name("sports"));
		captureElementScreenshot(driver.findElement(By.xpath("/html/body/table[3]/tbody/tr[1]/td[2]/table/tbody/tr/td/div[4]/input[1]")));
		System.out.println(checkboxes.size());

		for (WebElement checkbox : checkboxes) {

			checkbox.click();
		}

		captureScreenshot();
		
		File screen = driver.getFullPageScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(screen, new File("./screenshot/fullpage.jpg"));
	}

}
