Extent Report -:>

We can genearte our own report and modify it and add  to the test suite.

1. Get the Extentreports dependency.
2. Write below code.





package learnauto;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.Markup;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class TestExtentReports {
	
	public ExtentSparkReporter htmlReporter;// Creating HTML file
	public ExtentReports extent;  // Add config, system, test cases
	public ExtentTest test;  // maintain test cases and add logs pass/fail/skip
	
	
	//@BeforeTest
	public void setReport() {
		htmlReporter = new ExtentSparkReporter("./reports/extent.html");
		htmlReporter.config().setEncoding("utf-8");
		htmlReporter.config().setDocumentTitle("Automation Report for Delhi");
		htmlReporter.config().setReportName("Automation Test Results");
		htmlReporter.config().setTheme(Theme.STANDARD);
		
		extent = new ExtentReports();
		extent.attachReporter(htmlReporter);
		
		extent.setSystemInfo("Automation Tester", "Tester name1");
		extent.setSystemInfo("Build No", "1234");
		extent.setSystemInfo("Organization", "Org Name");
		
		
	}
	
	//Now call test cases
	//@test
	public void login() {
		test = extent.createTest("Login Test");
		System.out.println("print method");
		test.log(Status.INFO, "Enter User name");
		test.log(Status.INFO, "Enter password ");
		test.log(Status.INFO, "Click submit btn");
		test.pass("Test case passed");
		
	}
	//@test
		public void registration() {
			test = extent.createTest("registration Test");
			System.out.println("print method");
			test.log(Status.INFO, "Enter User name");
			test.log(Status.INFO, "Enter password ");
			test.log(Status.INFO, "Click submit btn");
			//test.fail("Test case passed");
			
			Assert.fail();
			
			
		}
		//@test
		public void skipping() {
			test = extent.createTest("skipping Test");
			System.out.println("print method");
			
			test.log(Status.INFO, "Click submit btn");
			test.pass("Test case skipped");
			//throw new SkipException("Test case skipped"));
			
		}
	
	// This method will check each method or tests result and update it.
	//@AfterMethod
	public void updateResults(ITestResult result) {
		if (result.getStatus() == ITestResult.FAILURE){	
			String methodname = result.getMethod().getMethodName();
			Markup m = MarkupHelper.createLabel(methodName.toUpperCase()+" - FAILED", ExtentColor.RED);
			//test.fail("Test case failed");
			test.fail(m);
		}
		else if (result.getStatus() == ITestResult.SUCCESS){		
			String methodname = result.getMethod().getMethodName();
			Markup m = MarkupHelper.createLabel(methodName.toUpperCase()+" - PASS", ExtentColor.GREEN);
			
			//test.pass("Test case passed");
			test.pass(m);
		}
		else if (result.getStatus() == ITestResult.SKIP){
			test.skip("Test case skipped");
			throw new SkipException("Test case skipped"));
		}
	}
	//@AfterTest
	public void endReport() {
		extent.flush();
	}

}


This type of things we can write in the onTestStart method. SO that it will print on each test case start so we dont have to write in each test case.
test = extent.createTest("registration Test");
System.out.println("print method");



public class CustomeListeners implemnets ITestListener{
	
public void onTestStart(ITestResult result){
test = extent.createTest("registration Test");
System.out.println("print method");
}

public void onTestSuccess(ITestResult result){
}

public void onTestFailure(ITestResult result){

System.setProperty("org.uncommons.reportng.escape-output","false");

Reporter.log("<a href=\"path of the image\" target=\"_blank\">Screenshot link</a>");
Reporter.log("<br>");
Reporter.log("<a href=\"path of the image\" target=\"_blank\"><img src=\"path of the image\" height=200 width=200></a>");

}

public void onTestSkipped(ITestResult result){
}
}

