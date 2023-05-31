package rough;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;
import utilities.ScrollUtil;

public class SearchVilla {
	public static AndroidDriver driver;

	public static void main(String[] args) throws MalformedURLException, InterruptedException {

		DesiredCapabilities cap = new DesiredCapabilities();

		cap.setCapability(MobileCapabilityType.DEVICE_NAME, "Android");
		cap.setCapability(AndroidMobileCapabilityType.APP_PACKAGE, "com.goibibo");
		cap.setCapability(AndroidMobileCapabilityType.APP_ACTIVITY, ".common.HomeActivity");
		cap.setCapability(MobileCapabilityType.NO_RESET, "true");

		driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), cap);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		Thread.sleep(5000);
		
		
		driver.findElement(By.xpath("//android.widget.LinearLayout[@content-desc=\"villas\"]/android.widget.TextView")).click();
		driver.findElement(By.xpath("//android.widget.TextView[@text='Area, Landmark or Property']")).click();
		
		driver.findElement(By.id("com.goibibo:id/edtSearch")).sendKeys("Dubai");
		driver.hideKeyboard();
		driver.findElements(By.id("com.goibibo:id/lytLocationItem")).get(0).click();
		driver.findElement(By.xpath("//android.widget.TextView[@text='25']")).click();
		driver.findElement(By.xpath("//android.widget.TextView[@text='27']")).click();
		
		driver.findElement(By.id("com.goibibo:id/btnCalendar")).click();
		
		driver.findElement(By.xpath("//android.widget.TextView[@text='View Stays']")).click();
		Thread.sleep(10000);
		ScrollUtil.scrollToTextByAndroidUIAutomator("Al Waleed Holiday Homes", driver).click();
		

	}

}
