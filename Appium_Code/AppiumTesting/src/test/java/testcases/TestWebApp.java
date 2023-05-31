package testcases;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;

public class TestWebApp {

	
	public static AndroidDriver driver;
	public static void main(String[] args) throws MalformedURLException, InterruptedException {
		
		DesiredCapabilities cap = new DesiredCapabilities();
		cap.setCapability(CapabilityType.BROWSER_NAME, "Chrome");
		cap.setCapability(MobileCapabilityType.DEVICE_NAME, "Android");
		
		
		driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), cap);
		
		
		driver.get("http://google.com");
		
		driver.findElement(By.xpath("//*[@name='q']")).sendKeys("Hello Appium !!!");
		
		Thread.sleep(2000);
		
		driver.quit();
		
		

	}

}
