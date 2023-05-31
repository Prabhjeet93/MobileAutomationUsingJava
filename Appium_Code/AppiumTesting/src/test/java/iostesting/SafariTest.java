package iostesting;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.remote.MobileCapabilityType;

public class SafariTest {
	
	
	public static IOSDriver driver;

	public static void main(String[] args) throws MalformedURLException, InterruptedException {
		
		DesiredCapabilities capabilities = new DesiredCapabilities();
		capabilities.setCapability("platformName", "iOS");
		capabilities.setCapability("platformVersion", "15.4.1");
		capabilities.setCapability("deviceName", "iPhone 13 Pro Max");
		
		capabilities.setCapability("udid", "267E4C9B-5CD2-4CD9-8708-D5B2E8AE26F9");
		
		//Real Device
	//	capabilities.setCapability("udid", "00008110-000E4D08012A801E");
		capabilities.setCapability(CapabilityType.BROWSER_NAME, "Safari");
		
		
		driver = new IOSDriver(new URL("http://127.0.0.1:4723/wd/hub"),capabilities);
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		
		driver.get("http://google.com");
		
		driver.findElement(By.xpath("//*[@name='q']")).sendKeys("Hello Appium !!!");
		
		Thread.sleep(3000);
		
		driver.quit();
		
		
		
	}

}
