package testcases;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.Status;

import extentlisteners.ExtentListeners;
import io.github.bonigarcia.wdm.WebDriverManager;

public class TestProperties {

	/*
	 * 
	 * Log4j Dep Logger - getLogger() Info, Debug, Error Log4j.properties -
	 * Appenders - PropertyConfigurator
	 * 
	 * 
	 * 
	 */

	public static Properties or = new Properties();
	public static Properties config = new Properties();
	public static FileInputStream fis;
	public static Logger log = Logger.getLogger(TestProperties.class);
	public static WebDriver driver;

	//trainer@way2automation.com
	public static void click(String locator) {

		if (locator.endsWith("_xpath")) {
			driver.findElement(By.xpath(or.getProperty(locator))).click();
		} else if (locator.endsWith("_id")) {
			driver.findElement(By.id(or.getProperty(locator))).click();
		} else if (locator.endsWith("_css")) {
			driver.findElement(By.cssSelector(or.getProperty(locator))).click();
		}
		log.info("Clicking on Element :  " + locator);
		// ExtentListeners.test.log(Status.INFO, "Clicking on Element : " + locator);

	}

	public static void type(String locator, String value) {
		if (locator.endsWith("_xpath")) {
			driver.findElement(By.xpath(or.getProperty(locator))).sendKeys(value);
		} else if (locator.endsWith("_css")) {
			driver.findElement(By.cssSelector(or.getProperty(locator))).sendKeys(value);
		} else if (locator.endsWith("_id")) {
			driver.findElement(By.id(or.getProperty(locator))).sendKeys(value);
		}
		log.info("Typing in an Element :  " + locator + "  entered the value as : " + value);
		// ExtentListeners.test.log(Status.INFO, "Typing in an Element : " + locator+"
		// entered the value as : "+value);

	}

	public static void main(String[] args) {

		PropertyConfigurator.configure(
				"/Users/rahularora/seleniumworkspace/BatchDiagnal/SeleniumTesting/src/test/resources/properties/log4j.properties");

		log.info("starting the test case");

		try {
			fis = new FileInputStream("./src/test/resources/properties/OR.properties");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			or.load(fis);
			log.info("OR Property file loaded");

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		try {
			fis = new FileInputStream("./src/test/resources/properties/Config.properties");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			config.load(fis);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		if (config.getProperty("browser").equals("chrome")) {

			driver = WebDriverManager.chromedriver().create();
			log.info("Chrome browser launched ");
		} else if (config.getProperty("browser").equals("firefox")) {

			driver = WebDriverManager.firefoxdriver().create();
			log.info("Firefox browser launched ");
		}

		driver.get(config.getProperty("testsiteurl"));
		log.info("Navigating to the Website : " + config.getProperty("testsiteurl"));
		driver.manage().window().maximize();
		driver.manage().timeouts()
				.implicitlyWait(Duration.ofSeconds(Integer.parseInt(config.getProperty("implicit.wait"))));

		type("username_id", "trainer@way2automation.com");
		click("submit_xpath");

		driver.quit();

		log.info("Test Execution completed !!!");

	}

}
