HOw to verify xpath

1. goto console
2. ctrl+L
3. enter -> $x("xpath")
It will tell correct count.

Use plugin "selectorshub" to find complex elements.

if some elements are displaying on mouse over and immediately going away, in this case we can use eventlistener option or Selectorshub tool.

How to use eventlistener?
1. Inspect -> Elements -> Event Listeners -> blur
2. remove everything in blur option.
3. Now if we mouse hover it will show in DOM.
4. if this doesn't work, we can use SelectorsHub.


isElementPresent -:>

driver.findElements(By.id("abc")).isDisplayed();  //Boolean value -> It checks the visibility of the element but not presence.
 // It will return false if it is hidden element.


So to check the Presence of the elements. We have to create own method using try  catch.

public static boolean isElementPresent(String xpath){
	try{
		driver.findElements(By.id("abc"));
	}
	catch(Throwable t) {
	return false;
	}
	return true;
   }

isElementPresent("XPATH");


By class -:>
We can use this in above methods. Lets see if we have to create above method for each locator, then we will be creating 8 similar methods. So to avoid this we will use By class.

public static boolean isElementPresent(By by){
	try{
		driver.findElements(By.id("abc"));
	}
	catch(Throwable t) {
	return false;
	}
	return true;
   }

isElementPresent(By.id("ID"));
isElementPresent(By.xpath("XPATH"));


If we need to check findElements, for multiple elements, we can compare size() of the list.



Multiple Checkboxes -:>
iterate the xpath.

//int size = driver.findElements(By.xpath("abc")).size();
for ( int i=1;i<=4;i++)
{
driver.findElement(By.xpath("abc["+i+"]")).click();

}


int i = 1;
while(isElementPresent(By.xpath("abc["+i+"]"))
{
driver.findElement(By.xpath("abc["+i+"]")).click();
i++;
}


Q- 
1. Select two random checkboxes.
2. get text/Name of each checkbox
3. check all the checkboxes. if any already checked keep that checked and dont uncheck it.
4. Go to any cricket website or any other sports and then scoreboard. So data will be dynamic 
	we need to print player name and its data. all rows and columns. print them.





# cssSelector -:>

input[id='identified']
input[id='identified'][name='identifier']

Starts with -:>
input[id^='identif']

Ends with 
input[id$='tified']

Contains with 
input[id*='ntifi']


id -> #identified
tagname -> input

tagname and id -> input#identified

class name ->  .className

 if we have space in between classes then remove that with dot (.)
class name ->  .Xbhjedg hfd hghfds wqeo
	   ->  .Xbhjedg.hfd.hghfds.wqeo


Parent and child for the cssSelectors.

for mobile - css doesn't work, but xpath works.



# Launch browser in selenium with driver manager


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class baseclass {

static WebDriver driver;


public static void main(String[] args)
{
String browser = "firefox";

if(browser.equals("chrome"))
{

WebDriverManager.chromedriver().setup();
driver = new ChromeDriver();

}else if(browser.equals("firefox"))
{

WebDriverManager.firefoxdriver().setup();
driver = new FirefoxDriver();

}
else if(browser.equals("edge"))
{

WebDriverManager.edgedriver().setup();
driver = new EdgeDriver();

}
else
{
System.out.println("Please provide a proper browser value..");
}

driver.manage().window().fullscreen();
driver.manage().deleteAllCookies();
driver.get("https://www.facebook.com");

System.out.println("Opened browser and URL successfully");
driver.quit();
}

}
