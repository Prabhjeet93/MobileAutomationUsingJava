package testcases;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.touch.offset.PointOption;

public class TestTapAndLongPress {
	
	public static AndroidDriver driver;
	public static void main(String[] args) throws MalformedURLException, InterruptedException {
	

	DesiredCapabilities cap = new DesiredCapabilities();
	
	cap.setCapability(MobileCapabilityType.DEVICE_NAME, "Android");
	cap.setCapability(AndroidMobileCapabilityType.APP_PACKAGE, "com.android.contacts");
	cap.setCapability(AndroidMobileCapabilityType.APP_ACTIVITY, ".DialtactsContactsEntryActivity");
	cap.setCapability(MobileCapabilityType.NO_RESET, "true");
	
	
	driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), cap);
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	//driver.findElement(By.xpath("//android.widget.Button[@content-desc=\"New Contact\"]")).click();
	
	//driver.findElement(By.xpath("//android.widget.EditText[@text='Name']")).sendKeys("Abcd2");
	//driver.findElement(By.xpath("//android.widget.EditText[@text='Phone']")).sendKeys("3243324234");
	//driver.findElement(By.xpath("//android.widget.Button[@text='Done']")).click();
	

	//android.widget.TextView[@text='Abcd2']
	
	new TouchAction(driver).longPress(PointOption.point(341, 919)).perform();
	//TouchAction(driver).tap(x=341, y=919).perform()
	
	
	
	
	}

}
