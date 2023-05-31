package testnglearning;

import org.testng.annotations.Test;
import org.testng.Assert;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;
import org.testng.Assert;
import org.testng.AssertJUnit;
import org.testng.Reporter;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class TestCase2 {
	
	
	
	@Test
	public void validateTitle() {
		
		
		System.out.println("Beginning");
		
		String expectedTitle = "Google.com";
		String actualTitle = "gmail.com";
		
		/*
		if(expectedTitle.equals(actualTitle)) {
			
			System.out.println("Test case pass");
		}else {
			
			System.out.println("Test case fail");
		}*/
		
		SoftAssert softAssert = new SoftAssert();
		
		
		softAssert.assertEquals(actualTitle, expectedTitle);
		softAssert.assertTrue(false,"Login button missing");
		Assert.fail("Failing the test as the condition is not met");
		
		System.out.println("Ending");
		
		softAssert.assertAll();
		
		
		
	}

}
