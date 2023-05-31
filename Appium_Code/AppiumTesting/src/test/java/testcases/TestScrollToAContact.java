package testcases;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;
import utilities.ScrollUtil;

public class TestScrollToAContact {
	public static AndroidDriver driver;
	public static void main(String[] args) throws MalformedURLException, InterruptedException {
	
		DesiredCapabilities cap = new DesiredCapabilities();
		
		cap.setCapability(MobileCapabilityType.DEVICE_NAME, "Android");
		cap.setCapability(AndroidMobileCapabilityType.APP_PACKAGE, "com.android.contacts");
		cap.setCapability(AndroidMobileCapabilityType.APP_ACTIVITY, ".DialtactsContactsEntryActivity");
		cap.setCapability(MobileCapabilityType.NO_RESET, "true");
		
		
		driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), cap);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		String text = "Airtel Wiring";
		ScrollUtil.scrollToTextByAndroidUIAutomator(text, driver).click();

		Thread.sleep(2000);
		
		driver.quit();
		
		
	}

}
