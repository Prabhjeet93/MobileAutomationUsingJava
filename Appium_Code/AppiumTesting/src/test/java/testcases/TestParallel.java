package testcases;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;

public class TestParallel {

	
	
	public AndroidDriver driver;
	public DesiredCapabilities cap = new DesiredCapabilities();
	
	@Parameters({"deviceName"})
	@Test
	public void launchBrowser(String deviceName) throws MalformedURLException {
		
		if(deviceName.equals("vivo")) {
			
			cap.setCapability(CapabilityType.BROWSER_NAME, "Chrome");
			cap.setCapability(MobileCapabilityType.UDID, "8e006adb");
			cap.setCapability(MobileCapabilityType.DEVICE_NAME, "Android");
			cap.setCapability(AndroidMobileCapabilityType.CHROMEDRIVER_EXECUTABLE, "/Users/rahularora/Desktop/chrome83/chromedriver");
			
			driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), cap);
			
			
			
		}else if(deviceName.equals("emulator")) {
			
			cap.setCapability(CapabilityType.BROWSER_NAME, "Chrome");
			cap.setCapability(MobileCapabilityType.UDID, "emulator-5554");
			cap.setCapability(MobileCapabilityType.DEVICE_NAME, "Android");
			cap.setCapability(AndroidMobileCapabilityType.CHROMEDRIVER_EXECUTABLE, "/Users/rahularora/Desktop/chrome83/chromedriver");
			
			
			driver = new AndroidDriver(new URL("http://127.0.0.1:4724/wd/hub"), cap);
			
			
			
		}
		
		
		driver.get("http://google.com");
		driver.findElement(By.name("q")).sendKeys("Hello "+deviceName);
		
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		driver.quit();
		
	}
	
	
	

}
