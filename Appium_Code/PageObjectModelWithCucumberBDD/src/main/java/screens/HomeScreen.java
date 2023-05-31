package screens;

import org.openqa.selenium.By;

import base.BaseScreen;
import io.appium.java_client.AppiumDriver;

public class HomeScreen extends BaseScreen{

	
	
	
	public HomeScreen(AppiumDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}



	public void gotoVillas() {
		
		driver.findElement(By.xpath("//android.widget.LinearLayout[@content-desc=\"villas\"]/android.widget.TextView"))
		.click();
		
	}
	
	
	
	public void gotoHotels() {
		
		
	}
	
	
	public void gotoFlights() {
		
		
		
	}
	
	
}
