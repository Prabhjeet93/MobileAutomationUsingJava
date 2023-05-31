package testcases;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;
import utilities.ScrollUtil;

public class TestSwipe {

	public static AndroidDriver driver;

	public static void main(String[] args) throws MalformedURLException, InterruptedException {

		DesiredCapabilities cap = new DesiredCapabilities();

		cap.setCapability(MobileCapabilityType.DEVICE_NAME, "Android");
		cap.setCapability(AndroidMobileCapabilityType.APP_PACKAGE, "flipboard.app");
		cap.setCapability(AndroidMobileCapabilityType.APP_ACTIVITY, "flipboard.activities.LaunchActivityAlias");
	
		

		driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), cap);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		
		driver.findElement(By.id("flipboard.app:id/first_launch_cover_continue")).click();
		
		driver.findElements(By.id("flipboard.app:id/topic_picker_topic_row_topic_tag")).get(0).click();
		driver.findElements(By.id("flipboard.app:id/topic_picker_topic_row_topic_tag")).get(1).click();
		driver.findElements(By.id("flipboard.app:id/topic_picker_topic_row_topic_tag")).get(4).click();
		driver.findElements(By.id("flipboard.app:id/topic_picker_topic_row_topic_tag")).get(6).click();
		
		driver.findElement(By.id("flipboard.app:id/topic_picker_continue_button")).click();
		
		driver.findElement(By.id("flipboard.app:id/account_login_buttons_skip")).click();
		
		Thread.sleep(2000);
		
		
		ScrollUtil.swipeUp(4, driver);
		Thread.sleep(2000);
		ScrollUtil.swipeDown(4, driver);
		Thread.sleep(2000);
		ScrollUtil.swipeLeft(2, driver);
		Thread.sleep(2000);
		ScrollUtil.swipeRight(2, driver);
		
		
		Thread.sleep(5000);

		driver.quit();

		
		
		

	}

}
