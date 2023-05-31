package testcases;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;

public class TestAPIDemos {


	public static AndroidDriver driver;
	public static void main(String[] args) throws MalformedURLException, InterruptedException {
		
		//AppActivity & AppPackage
		//File app = new File("./app/ApiDemos.apk");
		DesiredCapabilities cap = new DesiredCapabilities();
		
		cap.setCapability(MobileCapabilityType.DEVICE_NAME, "Android");
		cap.setCapability(AndroidMobileCapabilityType.APP_PACKAGE, "com.android.dialer");
		cap.setCapability(AndroidMobileCapabilityType.APP_ACTIVITY, ".TwelveKeyDialer");
		
		
		
		//cap.setCapability(MobileCapabilityType.APP, app.getAbsolutePath());
		
		
		driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), cap);
		
		driver.findElement(By.id("com.android.dialer:id/one")).click();
		driver.findElement(By.xpath("//android.widget.ImageView[@content-desc=\"2\"]")).click();
		driver.findElement(AppiumBy.accessibilityId("3")).click();
		driver.findElement(By.xpath("//android.widget.RelativeLayout/android.widget.ImageView[@content-desc='4']")).click();

		//driver.findElement(AppiumBy.accessibilityId("Dial")).click();
		
		//Run app in background
				driver.runAppInBackground(Duration.ofSeconds(10));
				
				
		
		Thread.sleep(2000);
		
		driver.quit();
		
		

	}

}
