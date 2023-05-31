package testnglearning;

import org.testng.annotations.Test;
import org.testng.annotations.Test;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TestCase1 {

	@BeforeTest
	public void createDbConn() {

		System.out.println("Creating DB Conn");
	}

	@AfterTest
	public void closeDbConn() {

		System.out.println("Closing DB Conn");
	}

	@BeforeMethod
	public void launchBrowser() {

		System.out.println("Launching the browser");
	}

	@AfterMethod
	public void closeBrowser() {

		System.out.println("Closing the browser");

	}

	@Test(priority = 1)
	public void doUserReg() {

			System.out.println("Executing User Reg test");
			Reporter.log("Inside User reg test");
		
	}

	@Test(priority = 2)
	public void doLogin() {
		
			System.out.println("Executing login test");
			Reporter.log("Inside Do Login test");
		
	}

}
