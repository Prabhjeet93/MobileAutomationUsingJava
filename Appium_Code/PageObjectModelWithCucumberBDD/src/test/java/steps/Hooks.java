package steps;

import base.BaseSteps;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

public class Hooks extends BaseSteps{
	
	
	@Before
	public void beforeHook() {
		
		setUp();
	}
	
	@After
	public void afterHook(Scenario scenario) {
		
		
		if(scenario.isFailed()) {
			
			scenario.attach(getScreenshot(), "image/png", scenario.getName());
			
		}
		
		quit();
		
	}

}
