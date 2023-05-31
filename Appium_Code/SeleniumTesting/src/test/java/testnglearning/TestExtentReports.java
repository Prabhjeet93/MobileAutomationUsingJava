package testnglearning;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.SkipException;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.Markup;
import com.aventstack.extentreports.markuputils.MarkupHelper;

import extentlisteners.ExtentListeners;

public class TestExtentReports {

	/*
	public ExtentSparkReporter htmlReporter; //Creating HTML File
	public ExtentReports extent; //Add config, system, test cases
	public ExtentTest test; //maintain test cases and add logs pass/fail/skip
	
	
	@BeforeTest
	public void setReport() {
		
		htmlReporter = new ExtentSparkReporter("./reports/extent.html");
		htmlReporter.config().setEncoding("utf-8");
		htmlReporter.config().setDocumentTitle("Diagnal Automation Reports");
		htmlReporter.config().setReportName("Automation Test Results");
		htmlReporter.config().setTheme(Theme.STANDARD);
		
		extent = new ExtentReports();
		extent.attachReporter(htmlReporter);
		
		
		extent.setSystemInfo("Automation Tester", "Rahul Arora");
		extent.setSystemInfo("Build No", "1234");
		extent.setSystemInfo("Organization", "Diagnal");
		
	}*/
	
	@Test
	public void doLogin() {
		
		
		//test = extent.createTest("Login Test");
		ExtentListeners.test.log(Status.INFO, "Enter username");
		ExtentListeners.test.log(Status.INFO, "Enter Password");
		ExtentListeners.test.log(Status.INFO, "Click on Submit");
		AssertJUnit.fail();
		
		//Assert.fail();
	}
	
	
	@Test
	public void doUserReg() {
		
		
		//test = extent.createTest("User Reg Test");
		ExtentListeners.test.log(Status.INFO, "Enter Firstname");
		ExtentListeners.test.log(Status.INFO, "Enter lastname");
		ExtentListeners.test.log(Status.INFO, "Enter age");
		ExtentListeners.test.log(Status.INFO, "Enter city");
		ExtentListeners.test.log(Status.INFO, "Click on Submit");
		
		
		/*
		 * TestNG Parameterization (Excel Reading)
		 * Parallel Test Execution
		 * Log4j
		 * Properties
		 * JavaMail
		 * Appium Installation
		 * 
		 */
		//Assert.fail();
	}
	
	
	@Test
	public void isSkip() {
		
		
		//test = extent.createTest("Skip Test");
		
		ExtentListeners.test.log(Status.INFO, "Click on Submit");
		
		throw new SkipException("Skipping the test");
	}
	
	
	/*
	@AfterTest
	public void endReport() {
		
		extent.flush();
	}
	
	
	@AfterMethod
	public void updateResults(ITestResult result) {
		
		if(result.getStatus()==ITestResult.FAILURE) {
			
			String methodName = result.getMethod().getMethodName();
			Markup m = MarkupHelper.createLabel(methodName.toUpperCase()+" - FAILED", ExtentColor.RED);
			
			test.fail(m);
			
		}else if(result.getStatus()==ITestResult.SUCCESS) {
			
			String methodName = result.getMethod().getMethodName();
			Markup m = MarkupHelper.createLabel(methodName.toUpperCase()+" - PASS", ExtentColor.GREEN);
		
			test.pass(m);
			
			
		}else if(result.getStatus()==ITestResult.SKIP) {
			
			String methodName = result.getMethod().getMethodName();
			Markup m = MarkupHelper.createLabel(methodName.toUpperCase()+" - SKIP", ExtentColor.AMBER);
		
			test.skip(m);
			
		}
		
		
	}
	
	*/
}
