package iostesting;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.HashMap;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.ios.IOSDriver;

public class TestDatePickers {
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
		
		HashMap<String,Object> param = new HashMap<String, Object>();
		param.put("order", "next");
		param.put("offset", 0.15);
		param.put("element", driver.findElement(By.xpath("//XCUIElementTypePickerWheel[1]")));
		
		driver.executeScript("mobile: selectPickerWheelValue", param);
		
		System.out.println(driver.findElement(By.xpath("//XCUIElementTypePickerWheel[1]")).getAttribute("value"));
		
		
		driver.findElement(By.xpath("//XCUIElementTypePickerWheel[2]")).sendKeys("7");
		driver.findElement(By.xpath("//XCUIElementTypePickerWheel[3]")).sendKeys("20");
		driver.findElement(By.xpath("//XCUIElementTypePickerWheel[4]")).sendKeys("AM");
		Thread.sleep(3000);
		driver.quit();

	}

}
