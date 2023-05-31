package testcases;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.android.Activity;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;

public class TestSwitchingApps {
	public static AndroidDriver driver;

	public static void main(String[] args) throws MalformedURLException, InterruptedException {

		DesiredCapabilities cap = new DesiredCapabilities();

		cap.setCapability(MobileCapabilityType.DEVICE_NAME, "Android");
		cap.setCapability(AndroidMobileCapabilityType.APP_PACKAGE, "in.upstox.app");
		cap.setCapability(AndroidMobileCapabilityType.APP_ACTIVITY, "in.upstox.pro.beta.app.MainActivity");
		cap.setCapability(MobileCapabilityType.NO_RESET, "true");

		driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), cap);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		driver.findElement(By.id("in.upstox.app:id/inputTextLineField")).sendKeys("9711111558");
		
		//driver.findElement(By.xpath("//android.widget.Button[@text='Get OTP']")).click();
		
		driver.startActivity(new Activity("com.android.mms",".ui.ConversationList"));
		
		String text = driver.findElement(By.id("com.android.mms:id/subject")).getText();
		System.out.println(text);
		String otp = text.substring(0, 6);
		System.out.println(otp);
		Thread.sleep(5000);

		driver.quit();
		
	}

}
