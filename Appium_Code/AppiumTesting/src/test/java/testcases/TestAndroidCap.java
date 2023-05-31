package testcases;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;

public class TestAndroidCap {
	public static AndroidDriver driver;
	public static void main(String[] args) throws MalformedURLException, InterruptedException {
	
		DesiredCapabilities cap = new DesiredCapabilities();
		
		cap.setCapability(MobileCapabilityType.DEVICE_NAME, "Android");
		cap.setCapability(AndroidMobileCapabilityType.APP_PACKAGE, "com.android.contacts");
		cap.setCapability(AndroidMobileCapabilityType.APP_ACTIVITY, ".DialtactsContactsEntryActivity");
		cap.setCapability(MobileCapabilityType.NO_RESET, "true");
		
		
		driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), cap);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.findElement(By.xpath("//android.widget.Button[@content-desc=\"New Contact\"]")).click();
		
		//driver.findElement(By.xpath("//android.widget.EditText[@text='Name']")).sendKeys("Abcd1");
		
		//Hide Keyboard
		driver.hideKeyboard();
		//Run app in background
		driver.runAppInBackground(Duration.ofSeconds(10));
		driver.pressKey(new KeyEvent(AndroidKey.HOME));
		
		File app = new File("./app/ApiDemos.apk");
		driver.installApp(app.getAbsolutePath());
		
		System.out.println(driver.isAppInstalled("io.appium.android.apis"));
		
		driver.removeApp("io.appium.android.apis");
		
		System.out.println(driver.isAppInstalled("io.appium.android.apis"));
		
		driver.installApp(app.getAbsolutePath());
	
		driver.openNotifications();
		
		Thread.sleep(2000);
		
		//driver.quit();
		
		

	}

}
