import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.android.Activity;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;

public class GetOTP {
	
	public static AndroidDriver driver;

	public static void main(String[] args) throws MalformedURLException, InterruptedException {
		// TODO Auto-generated method stub
		
		
		DesiredCapabilities cap = new DesiredCapabilities();
		
		cap.setCapability(MobileCapabilityType.DEVICE_NAME,"android");
		cap.setCapability(AndroidMobileCapabilityType.APP_PACKAGE, "com.google.android.apps.messaging");
		cap.setCapability(AndroidMobileCapabilityType.APP_ACTIVITY, ".ui.ConversationListActivity");
		
		// this line will not not open the rest app, so that access pop and other can be skipped.
		cap.setCapability(MobileCapabilityType.NO_RESET, "true");
		
		
		driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), cap);
		
		driver.manage().timeouts().implicitlyWait(10, null);
		
		// login to the main app and genrate otp.
		
		//Now generate app_package name and activity information and start the message app.
		driver.startActivity(new Activity("package name","activity name"));
		
		// now get the webelements of the messaging app. Recent ( first message) and click on that.
		// and this will fetch the complete text message.
		String text = driver.findElement(By.id("ID")).getText();
		
		
		// Now we will read the string and fetch the otp only.
		String otp = text.substring(8,15);
		
		
		
		/// Now again switch back to the Main application and paste this OTP.
		
		
		
		
		
		
		Thread.sleep(2000);
		driver.quit();
		
		

	}

}
