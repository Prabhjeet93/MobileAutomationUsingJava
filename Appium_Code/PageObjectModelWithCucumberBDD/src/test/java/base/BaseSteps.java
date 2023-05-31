package base;

import org.openqa.selenium.OutputType;

import io.appium.java_client.AppiumDriver;
import utilities.CommonUtils;

public class BaseSteps {
	
	
	
	public static AppiumDriver driver;
	public static String loadPropertyFile = "Android_goibibo.properties";
	
	
	public byte[] getScreenshot() {
		
		return driver.getScreenshotAs(OutputType.BYTES);
		
	}
	
	
	
	public void setUp() {
		
		if(loadPropertyFile.startsWith("Android_")) {
			
			CommonUtils.loadAndriodConfProp(loadPropertyFile);
			CommonUtils.setAndroidCapabilities();
			driver = CommonUtils.getAndroidDriver();
			
			
		}else if(loadPropertyFile.startsWith("IOS_")) {
			
			
			
		}
		
		
	}
	
	
	public void quit() {
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		driver.quit();
	}

}
