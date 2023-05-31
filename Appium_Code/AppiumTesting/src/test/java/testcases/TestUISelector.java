package testcases;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;

public class TestUISelector {
	public static AndroidDriver driver;
	
	public static void scrollToElement(String text) {
		
		driver.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector().text("+text+").instance(0))")).click();
		
	}

	
	public static void main(String[] args) throws MalformedURLException, InterruptedException {
		
		//AppActivity & AppPackage
		File app = new File("./app/ApiDemos.apk");
		DesiredCapabilities cap = new DesiredCapabilities();
		
		cap.setCapability(MobileCapabilityType.DEVICE_NAME, "Android");
		cap.setCapability(MobileCapabilityType.APP, app.getAbsolutePath());
		
		
		driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), cap);

		//
		
		driver.findElement(AppiumBy.androidUIAutomator("UiSelector().text(\"Views\")")).click();
		driver.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector().text(\"Lists\").instance(0))")).click();
		
	//	scrollToElement(Lists);
		
		Thread.sleep(5000);
		
		driver.quit();
		
	}

}
