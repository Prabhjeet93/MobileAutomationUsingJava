
// Download a apk file and create a folder name app in the eclipse project and save that apk in that folder.
// https://github.com/appium-boneyard/sample-code/blob/master/sample-code/apps/ApiDemos/bin/ApiDemos-debug.apk

// How To install apk on Android device or Emulator.


public class TestApiApp {
	

	public static AndroidDriver driver;
	
	public static void main(String[] args) throws MalformedURLException, InterruptedException {
		
		// path of the apk file
		File app = new File("./app/ApiDemos.apk");
		DesiredCapabilities cap = new DesiredCapabilities();
		
		cap.setCapability(MobileCapabilityType.DEVICE_NAME,"android");
		cap.setCapability(MobileCapabilityType.APP, app.getAbsolutePath());
		
		driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), cap);
		driver.get("https://google.com");
		
		driver.findElement(By.name("q")).sendKeys("Hello Hello");
		
		Thread.sleep(2000);
		driver.quit();
		
	}
	

}

// // we need information about AppActivity and AppPackage Name.
// 		// Launch the application
// 		// open cmd in Laptop and enter below adb command.
// 		// adb shell dumpsys activity activities | findStr "mFocused"

// 	adb shell dumpsys activity a. | findStr -E 'mResumedActivity' | cut -d '' -f 8

// ### Launch Existing installed APplication.
public class TestApiApp {
	

	public static AndroidDriver driver;
	
	public static void main(String[] args) throws MalformedURLException, InterruptedException {
		
		// When APK is already Installed.
		
		// we need information about AppActivity and AppPackage Name.
		// Launch the application
		// open cmd in Laptop and enter below adb command.
		// adb shell dumpsys activity activities | findStr "mFocused"
		
//		mFocusedApp=ActivityRecord{565e495 u0 io.appium.android.apis/.ApiDemos t23}
//	    mFocusedWindow=Window{834e17b u0 io.appium.android.apis/io.appium.android.apis.ApiDemos}
//	    Package name = io.appium.android.apis
// 		Activity name = .ApiDemos
	    
		DesiredCapabilities cap = new DesiredCapabilities();
		
		cap.setCapability(MobileCapabilityType.DEVICE_NAME,"android");
		cap.setCapability(AndroidMobileCapabilityType.APP_PACKAGE, "io.appium.android.apis");
		cap.setCapability(AndroidMobileCapabilityType.APP_ACTIVITY, "ApiDemos");
		
		driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), cap);
		driver.get("https://google.com");
		
		driver.findElement(By.name("q")).sendKeys("Hello Hello");
		
		Thread.sleep(2000);
		driver.quit();
		
	}




// How to find Web Element in Mobile App
// 1. Download and launch Appium Inspector
// 2. Enter Remote path -> /wd/hub
// 2. Enter jason data in the field.
// {
//   "appPackage": "com.google.android.apps.messaging",
//   "appActivity": ".ui.ConversationListActivity",
//   "platformName": "android",
//   "deviceName": "android"
// }
// 3. Click on Start session



// Add one property to appium selector, to skip the Application's prerequiste like access pop up, or anything for the fresh app.


// {
//   "appPackage": "com.google.android.apps.messaging",
//   "appActivity": ".ui.ConversationListActivity",
//   "platformName": "android",
//   "deviceName": "android",
//   "appium:noReset":"true"
// }




// press back key of the Android Device
driver.pressKey(new KeyEvent(AndroidKey.BACK));
		
// App switch while working on two apps in parallely
driver.pressKey(new KeyEvent(AndroidKey.APP_SWITCH));
	

// How to hide the keyboard
driver.hideKeyboard();
		
// Run the app in background for 10 seconds
driver.runAppInBackground(Duration.ofSeconds(100));
		
// To check whether app is installed or not.
//driver.isAppInstalled("package name");
driver.isAppInstalled("io.appium.android.apis");
		
		
//How to uninstall app
driver.removeApp("io.appium.android.apis");
		
		
//Switch to Home Screen
driver.pressKey(new KeyEvent(AndroidKey.HOME));
		
// How to Open Notification
driver.openNotifications();


//For tap, get the x and y co-ordinates with the help of Appium selector.
// new TouchAction(driver)).tap(PointOption.point(311,811)).perform();
		
		
//For Long press, get the x and y co-ordinates with the help of Appium selector.
// new TouchAction(driver)).longPress(PointOption.point(311,811)).perform();
		
		
// We can use UI selector Library as well for these android actions.
//https://developer.android.com/reference/androidx/test/uiautomator/UiSelector
//https://appium.io/docs/en/writing-running-appium/android/uiautomator-uiselector/
		
//driver.findElement(AppiumBy.androidUIAutomator("UiSelector().text(\"Gallery\")")).click();
		
		
// swipe down and swipe up and then click on that screen.
// we can use UIScrollable class.
//https://developer.android.com/reference/androidx/test/uiautomator/UiScrollable
		
		
//new UiScrollable(new UiSelector().scrollable(true).instance(0).scrollIntoView(new UiSelector().textContains(\"Lists\").instance(0));
//driver.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector().scrollable(true).instance(0).scrollIntoView(new UiSelector().textContains(\\\"Lists\\\").instance(0))"));
		



// Native methods from Android Driver class

// Unlocking the device:

if(driver.isLocked()){
   driver.unlockDevice();
		
	}

driver.unlockDevice();

// Locking the device:

// 	driver.lockDevice();

// Get Current running activity:
	
System.out.println(driver.currentActivity());

// Android Key Codes:

// http://developer.android.com/reference/android/view/KeyEvent.html


	driver.pressKeyCode(153);
	driver.pressKeyCode(151);
	driver.pressKeyCode(145);
	
This will enter the number as 971
Open Notifications:
		
	driver.openNotifications();


driver.rotate(ScreenOrientation.LANDSCAPE)



// Drag and drop the Element

WebElement firstElement = driver.findElements(By.id("ID1")).get(0);
WebElement secondElement = driver.findElements((By.id("ID2")).get(3);
		
TouchAction action = new TouchAction(driver);
action.longPress(ElementOption.element(firstElement)).waitAction(WaitOptions.waitOptions(Duration.ofSeconds(5))).moveTo((ElementOption.element(secondElement))).release().perform();
		


Start Appium Server with code
AppiumServiceBuilder serviceBuilder = new AppiumServiceBuilder().usingPort(4723);
AppiumDriverLocalService server = AppiumDriverLocalService.buildService(serviceBuilder);
server.start();

// For more utilities check the Archive code, it has prebuild code.

