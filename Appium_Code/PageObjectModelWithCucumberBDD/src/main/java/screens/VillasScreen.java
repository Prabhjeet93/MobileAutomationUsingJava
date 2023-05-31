package screens;

import org.openqa.selenium.By;

import base.BaseScreen;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.HidesKeyboard;
import utilities.ScrollUtil;

public class VillasScreen extends BaseScreen {

	



	public VillasScreen(AppiumDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	public void searchProperty(String area) {

		driver.findElement(By.xpath("//android.widget.TextView[@text='Area, Landmark or Property']")).click();

		driver.findElement(By.id("com.goibibo:id/edtSearch")).sendKeys(area);
		((HidesKeyboard) driver).hideKeyboard();
		driver.findElements(By.id("com.goibibo:id/lytLocationItem")).get(0).click();

	}

	public void selectCheckinAndCheckoutDates() {

		driver.findElement(By.xpath("//android.widget.TextView[@text='25']")).click();
		driver.findElement(By.xpath("//android.widget.TextView[@text='27']")).click();

		driver.findElement(By.id("com.goibibo:id/btnCalendar")).click();

	}

	public void clickViewStays() {

		driver.findElement(By.xpath("//android.widget.TextView[@text='View Stays']")).click();
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void scrollToHotelApartment(String apartmentName) {

		ScrollUtil.scrollToTextByAndroidUIAutomator(apartmentName, driver).click();

	}

	public void gotoRecentSearches() {

	}

}
