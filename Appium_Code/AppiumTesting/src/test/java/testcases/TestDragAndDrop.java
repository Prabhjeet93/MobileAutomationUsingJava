package testcases;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.ElementOption;

public class TestDragAndDrop {

	public static AndroidDriver driver;

	public static void main(String[] args) throws MalformedURLException, InterruptedException {

		DesiredCapabilities cap = new DesiredCapabilities();

		cap.setCapability(MobileCapabilityType.DEVICE_NAME, "Android");
		cap.setCapability(AndroidMobileCapabilityType.APP_PACKAGE, "com.mobeta.android.demodslv");
		cap.setCapability(AndroidMobileCapabilityType.APP_ACTIVITY, ".Launcher");
		cap.setCapability(MobileCapabilityType.NO_RESET, "true");

		driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), cap);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		driver.findElements(By.id("com.mobeta.android.demodslv:id/activity_title")).get(0).click();

		WebElement firstElement = driver.findElements(By.id("com.mobeta.android.demodslv:id/drag_handle")).get(0);
		WebElement secondElement = driver.findElements(By.id("com.mobeta.android.demodslv:id/drag_handle")).get(3);

		TouchAction action = new TouchAction(driver);
		action.longPress(ElementOption.element(firstElement)).waitAction(WaitOptions.waitOptions(Duration.ofSeconds(1)))
				.moveTo(ElementOption.element(secondElement)).release().perform();

		Thread.sleep(5000);

		driver.quit();

	}

}
