Grid ->  is for the Remote test Execution.
Hub and Nodes.


TestNG -> we can use it for the Parallel Testing.

We inject javascript on browser with Selenium.


Download all the latest versions of all Jars using Maven Repo.
selenium jar
Extent jar
POI jar
JDBC jar
Log4j


Configure Maven:

1. Download Apache Maven -> apache-maven-3.8.5-bin.zip
2. Configure Maven globally.
3. Add jdk to Environment Variables 
In Windows : 
	1. Open System Environment Variables
	2. User variables ->
	3. System Variables -> New -> 
	var name - MVN_HOME
	value - c:/Downloads/apache-maven-3.6.3

	4. open Path -> New
	add -> %MVN%\bin

Now Maven Configured.


Now Create Maven Project.

Group ID - > Domain name -> com.w2a
Artifactid -> seleniumtesting

Click on finish.

In POM.xml File

Add all the Jars to download.
1. Open this File.
2. Search for the dependency to download on maven website.
3. add <dependency> to the pom.xml file.

From Selenium 4.x, we dont put separately code for the browsers.
we use below code.

Import WebDriverManager

WebDriverManager.chromedriver().setup();
ChromeDriver driver = new ChromeDriver();

or 

WebDriverManager.chromedriver().create();  // this will open and perform action and close the browser.

It will get latest version of the chrome driver.


driver.close(); // current window
driver.quit(); // current window + all opened window / tabs in current session only.

For Firefox driver.
WebDriverManager.firefoxdriver().setup();
FirefoxDriver driver = new FirefoxDriver();
driver.get("URL");


Webdriver -> is an Interface. So we can't create Object of the Webdriver.
ChromeDriver and FirfoxDriver are the Classes.



driver.findElement(By.id("val"));

WebElement wb = driver.findElement(By.name("val"));
wb.sendKeys("test");

By is a class and it has so many methods.
findElement(By by) --> Find the first WebElement using the given method.



Locators -: 
id = identified
name = identifier
ClassName = whjak_hsah
cssSelector = #identified
xpath = //*[@id="identified"]
tagName = input
linkText = href
partialLinkText = href


driver.manage().window().maximize();  // Method Chaining.
driver.manage() -> manage() method, this is from ChromeDriver class.

or 

Options opt = driver.manage();   // This belongs to WebDriver.Options Interface but defined inside RemoteWebDriverOptions.
Window win  = opt.window();    // This belongs to WebDriver.Window Interface but defined inside RemoteWebDriverOptions.
win.maximize();


Example -:>
if login to gmail and username and click on Next and then CLick on Password and then Next.
So username and password screen are on same page, they are changing element but on same page. Its updating on run time.
So if this is the case, we have to provide some wait.
But if they are on different page, we dont have to give waits.

We use Dynamic Waits.
1. Implicit wait  
2. Explicit Wait
3. Fluent wait


1. Implicit wait -> It will wait till 10 seconds before throwing the NoSuchElementFound Exception. It works on Presence of the Element.
driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));


It may sometime dont work. Because different browsers have different time or ways to synchronize the elements.

ElementIsNotReachable Exception -> We will use Explicit Wait.

2. Explicit Wait -> This can works on multiple conditions of the Element.
To eliminate the ElementIsNotReachable exception, we will use Explicit Wait.

WebDriverWait wait = New WebDriverWait(driver, Duration.OfSeconds(10));

wait.until(ExpectedConditions.elementToBeClickable(By.xpath("xpath"))).Click();

Implicit wait we define only once in the starting of the method. But Explicit we define again and again.




Dropdown -:>
1. we can select dropdown value directly.
	driver.findElement(By.id("searchLanguage")).sendKeys("French");

2. We can do by Select Class.
	WebElement drop= driver.findElement(By.id("searchLanguage"));
	Select sel = new Select(drop); 
	sel.selectByValue("Frech");

3. Get all values of Dropdowns on a page. - we use findElements

	List<WebElement> values = driver.findElements(By.tagName("option"));
	values.size();
	values.get(0); // print first webelement.
	values.get(0).getText(); // This will print text on Webelement.
	values.get(0).getAttribute("lang"); //
	

	For ( int i = 0; i<values.size(); i++){
		values.get(i).getText());
	}

4. Get all values of a particular dropdown of the page. - we use findElements
	
	WebElement dropdown = driver.findElement(By.id(searchLanguage));
	List<WebElement> values = dropdown.findElements(By.tagName("option"));
	values.size();
	values.get(0); // print first webelement.
	values.get(0).getText(); // This will print text on Webelement.
	values.get(0).getAttribute("lang"); //
	

	For ( int i = 0; i<values.size(); i++){
		values.get(i).getText());
	}


LINKS -:>

1. How to find the count of the links on the page.
 -> Using anchor tag -> <a>

List<WebElement> links = driver.findELements(By.tagName("a"));
links.size();
for ( WebElement link : links) {
	link.getText()+"-- URL is ---" +link.getAttribute("href"));
}

2. How to find the number / count of the links from a section of the page.
WebElement section = driver.findElement(By.xpath("xpath"));   // xpath of that section.
List<WebElement> links = section.findELements(By.tagName("a"));
links.size();
for ( WebElement link : links) {
	link.getText()+"-- URL is ---" +link.getAttribute("href"));
}
	

Buttons -:>

If we have same id for multiple buttons.
We can use below methods to click on them.
	
	driver.findElements(By.id("abc")).get(2).click();  // It will click on the thrid element.

if we are clicking on button in particular section or block.
	
	WebElement block = driver.findElement(By.xpath("xpath"));
	block.findElements(By.id("abc")).get(2).click();

	















