package steps;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;

import base.BaseSteps;
import io.appium.java_client.HidesKeyboard;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import screens.HomeScreen;
import screens.VillasScreen;
import utilities.ScrollUtil;

public class GoIbiboSteps extends BaseSteps {
	
	
	HomeScreen home = new HomeScreen(driver);
	VillasScreen villa = new VillasScreen(driver);

	

	@Given("I navigate to Villas section")
	public void i_navigate_to_villas_section() {

		home.gotoVillas();

	}

	@When("I search for a property in area {string}")
	public void i_search_for_a_property_in_area_dubai(String area) {

		villa.searchProperty(area);

	}

	@Then("I select the checkin and checkout dates")
	public void i_select_the_checkin_and_checkout_dates() {
		
		villa.selectCheckinAndCheckoutDates();
		

	}

	@And("I click on view stays")
	public void i_click_on_view_stays() {
		
		villa.clickViewStays();
	

	}

	@And("I scroll till {string}")
	public void i_scroll_till_baity_hotel_apartments(String apartments) {

		villa.scrollToHotelApartment(apartments);
		
	}

}
