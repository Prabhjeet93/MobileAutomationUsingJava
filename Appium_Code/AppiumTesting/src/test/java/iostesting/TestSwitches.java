package iostesting;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.ios.IOSDriver;

public class TestSwitches {
	public static IOSDriver driver;

	public static void main(String[] args) throws MalformedURLException, InterruptedException {

		// File app = new File("./app/IntegrationApp.app");
		DesiredCapabilities capabilities = new DesiredCapabilities();
		capabilities.setCapability("platformName", "iOS");
		capabilities.setCapability("platformVersion", "15.4.1");
		capabilities.setCapability("deviceName", "iPhone 13 Pro Max");
		// capabilities.setCapability("app", app.getAbsolutePath());

		// Real Device
		capabilities.setCapability("udid", "00008110-000E4D08012A801E");
		capabilities.setCapability("bundleId", "com.facebook.IntegrationApprah111");

		driver = new IOSDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		driver.findElement(AppiumBy.accessibilityId("Attributes")).click();

		WebElement switches = driver.findElement(By.className("XCUIElementTypeSwitch"));

		if (switches.getAttribute("value").equals("1")) {

			switches.click();
		}

		Thread.sleep(3000);
		if (switches.getAttribute("value").equals("0")) {

			switches.click();
		}

		Thread.sleep(3000);
		driver.quit();

	}

}
