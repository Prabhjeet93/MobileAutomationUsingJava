TestNG Framework -:>

1. Download TestNG dependency from Maven.
2. Download Eclipse plugin in Eclipse as well.
3. Eclipose -> help -> install new software -> paste below url.
	https://testng.org/testng-eclipse-update-site/6.14.3



Annotations -:>

@Test -> it will make a java method to a test case.

@Test(priority = 1) -> we can give prioroty to run the method or test case.

@BeforeMethod   -> it will be called before every test case.

@AfterMethod   -> it will be called after every test case.

@BeforeTest -> execute in the starting and only once.

@AfterTest -> execute in the ending and only once.




Validation -:>

we use  TestNG assertions.

Assert.assertEquals(actual, expected);
Assert.assertTrue(isElementPresent("By.id("abcid")));

Assert.assertTrue(isElementPresent("By.id("abcid")), "Login button failed");

Assert.fail("Condition not met");

if there is any  break in any assertion, it will fail complete test case.
SO to overcome this condtion, we can use Try / catch.

s.o.p("Begining of the test case");
try{
Assert.assertTrue(isElementPresent("By.id("abcid")));

Assert.assertTrue(isElementPresent("By.id("abcid")), "Login button failed");
}
catch(Throwable t){
Assert.fail("Condition not met");

}

s.o.p("Ending of the test case");


but this also does not work. We will use Soft assertions.

Soft Assert -:>

s.o.p("Begining of the test case");
softAssert.assertEquals(actual, expected);
softAssert.assertTrue(isElementPresent("By.id("abcid")));

softAssert.assertTrue(isElementPresent("By.id("abcid")), "Login button failed");

softAssert.fail("Condition not met");

softAssert.assertAll(): // -> it will add all the results of the softasserts. if we dont put this in the code, tets case is going to pass.

s.o.p("Ending of the test case");


If test case1 is failing and 2nd test case is dependent on 1st.
we will use dependsOnMethods.


@Test(priority = 1)
public void register(){
}

@Test(priority = 2, dependsOnMethods = "register")
public void login(){
}


 we can use SkipException as well.

@Test(priority = 3)
public void skipping(){

throw new SkipException("Skipping this test as condition is not met");
}



Run testng cases in the Suite.

We will be creating a testng.xml file

<suite name="TestNG Learning">
	<test name="Login">
	 <classes>
	    <class name=testnglearning.TestCase1" />
	   
	 </classes>
	</test>
	<test name="Validate title">
	 <classes>
	    
	    <class name=testnglearning.TestCase2" />
	    
	 </classes>
	</test>
</suite>

We can create testng.xml file .
1. Right click on the Project.
2. TestNG -> Convert to TestNG


After adding this, we can run test cases as Suite.
TestNG suite.

It will generate the test-output folder for the report.
It will be having a report in html file.  - name = index.html
we will get emailable-report.html -> which is better then index.html report.



We can add logs, screenshots in the report.
We will be using Reporter Class for that.


Reporter.log("Test case passed");

TestNG Listeners -:>

they are going to listen when any test case is failed or passed.

We will be creating a new class for that.

public class CustomeListeners implemnets ITestListener{
	
public void onTestStart(ITestResult result){
}

public void onTestSuccess(ITestResult result){
}

public void onTestFailure(ITestResult result){
Reporter.log("Test case failed");
Reporter.log("Screenshot link");
Reporter.log("<a href=\"path of the image\">Screenshot link</a>");
}

public void onTestSkipped(ITestResult result){
}
}


After that we need to add this listener to the testng.xml class.

<listeners>
	<listener class-name="testnglearning.CustomeListeners" />
</listeners>


Above code will capture screenshot or print the failed message whenever test case is failing.


How to create a link in the testng report with basic html
Reporter.log("<a href=\"path of the image\">Screenshot link</a>");

Open screenshot in new tab.
Reporter.log("<a href=\"path of the image\" target=\"_blank\">Screenshot link</a>");


Provide image in the report.
Reporter.log("<a href=\"path of the image\" target=\"_blank\">Screenshot link</a>");
Reporter.log("<br>");
Reporter.log("<a href=\"path of the image\" target=\"_blank\"><img src=\"path of the image\" height=200 width=200></a>");




How To capture Screenshot?

We have method in the browserdriver class.

//Capture the screenshot
File screenshot = driver.getScreenshotAs(OutputType.FILE);
//move this file to particular location.
FileUtils.copyFile(screenshot, new File("./screenshot/error.jpg"));

We can add timestamp to the name of the screenshot to generate and add screenshot in the Report.

Date d=new Date();
d.toString();
d.toString().replace(" ","_").replace(":","_")+".jpg";


We will create a method.


//Capture the screenshot
File screenshot = driver.getScreenshotAs(OutputType.FILE);
//move this file to particular location.
FileUtils.copyFile(screenshot, new File("./screenshot/"+name));


public void captureScreenshot(){
Date d=new Date();
d.toString();
String name = d.toString().replace(" ","_").replace(":","_")+".jpg";
File screenshot = driver.getScreenshotAs(OutputType.FILE);
FileUtils.copyFile(screenshot, new File("./screenshot/"+name));
}

Call this method wherever required.
captureScreenshot();



Capture screenshot for the particular area.
we need to replace driver with the webelement.


public void captureElementScreenshot(WebELement wb){
Date d=new Date();
d.toString();
String name = d.toString().replace(" ","_").replace(":","_")+".jpg";
File screenshot = wb.getScreenshotAs(OutputType.FILE);
FileUtils.copyFile(screenshot, new File("./screenshot/Element_"+name));
}



We can take screenshot with the help of TakeScreenshot Interface as well which is available in selenium lib.

We can use when we are defing driver as Webdriver, so we need to typecast the driver with TakeScreenshot Interface.

File screenshot = ((TakeScreenshot) driver).getScreenshotAs(OutputType.FILE);
FileUtils.copyFile(screenshot, new File("./screenshot/"+name));



In Selenium 4 , we have hasFullPageScreenshot Interface and getFullPageScreenshotAs()

File file =  driver.getFullPageScreenshotAs(OutputType.FILE);
FileUtils.copyFile(file, new File("./screenshot/"+name));





reportNG listener.
we need to add dependency for the reportng from maven
and we need to add one more jar to support this is - google guice core lib


To use this listener, go to the testng.xml file

<listeners>
	<listener class-name="testnglearning.CustomeListeners" />
	<listener class-name="org.uncommons.reportng.HTMLReporter" />
</listeners>


It will generate a html folder inside test-output folder.

It will be a beautiful and more interactive report.

But it will not show screenshots, so we have to add one line of code int he CustomeListeners method.
System.setProperty("org.uncommons.reportng.escape-output","false");

public class CustomeListeners implemnets ITestListener{
	
public void onTestStart(ITestResult result){
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




Extent Report -:>

We can genearte our own report and modify it and add  to the test suite.

1. Get the Extentreports dependency.

Follow the steps in File ExtentreportGenerate.txt

Now whatever we have done in the ExtentreportGenerate.txt file, we can do by importing a extent listener Package.

and add this class to the testng.xml file.

<listeners>
	<listener class-name="testnglearning.CustomeListeners" />
	<listener class-name="org.uncommons.reportng.HTMLReporter" />
	<listener class-name="extentlisteners.ExtentListeners" />
</listeners>
