
What is Appium?

Open source tool for the Mobile Apps.


We have 3 types of Mobiles apps.
1. WebApp
2. NativeApp
3. HybridApp


Cross platform -> iOs, Android, Windows
Multi lang -> Java, Python, C#, Ruby, JS


History of Appium - 2014,
DAN cuellar, Jason Huggins, Jonathan Lipps - Sauce Labs - JS FOundation.

It built on NodeJS server.



Google - Android - Android_Studio - UI automator,

Apple - iOS -XCODE - UI automation, XCUITest - 


Appium.io


Appium ( Javaclient, Python Client (Desired capabilities- AndroidDevice, Android)) ->(HTTP method) NodeJS -> UIAutomator -> communicate with Android Device.

Pre-requisite:
1. JDK 1.8
2. Eclipse IDE
3. NodeJS
4. Latest Appium Dependencies
5. Appium GUI Server
6. Appium Inspector
7. Android Studio / XCODE
8. Vysor - Remote of Mobile Screen
9. Real Device
10. Android file transfer APplication

Install JDK 1.8 and set environment variables.

Install Eclipse

Download node.js -> https://nodejs.org/en/download/
Open this nodejs file downloaded and install it.

Check versio -> $ node -v
$ npm -v


Create Maven project in Eclipse.
add dependencies.
1. javaClient


Download appium. -> https://appium.io/downloads.html
Download it and unzip or Install it.
You will get Appium GUI. Open it, it will start Appium Server.

Download Appium inspector from google.
unzip or install it.


1. First Run the APpium Server
2. Open Appium Inspector



Download Android Studio.
Download Xcode.


Android Studio Setup ->

1. Open it
2. Configure on opening screen in bottom -> SDK Manager -> Checkbox for the  latest APIs
3. After Downloading it, change the config in the Environment variable or the bash profile.

this is for the Mac.
export ANDROID_HOME=/Users/user/Library/Android/sdk
export PATH = $PATH:$ANDROID_HOME/tools:$ANDROID_HOME/platform-tools:$ANDROID_HOME/emulator

In Windows
System Environment variables -
provide this path ANDROID_HOME -> "/Users/user/Library/Android/sdk"
in Path -> ANDROID_HOME/tools;$ANDROID_HOME/platform-tools;$ANDROID_HOME/emulator

After this Open Terminal
$ adb devices
List of devices attached.


If this is not the output , it means path is not setup properly.



Dwnload Emulator.
Android Studio Setup ->

1. Open it
2. Configure on opening screen in bottom -> AVD Manager -> Create Virtual Device -> select device/emulator which you want to install. -> NExt -> select API or download new -> Provide any name -> Finish it.

Open AVD manager -> click on the play button in front of the device. -> It will start the Emulator.


Commands 

$ emulator -list --avds
$ emulator -avd <emulator_name>  -> it will launch the emulator.


Android File Transfer

DOwnload it -> https://www.android.com/filetransfer/


Vysor -:> we use it to mirror our real device in the laptop or to show other people in the call.
Download Vysor.-> https://www.vysor.io/download/
download it and install it.


But to connect with real device ->
1. Go to settings -> System management  -> Developer options.
if Developer options is not coming, go to about phone -> click 7 times on software version -> it will show Developer option.


Go to Developer Option
1. check Developer options
2. check staty awake option
3. check USB debugging option

How to open real device in Vysor?

1. Connect real device
2. Open Vysor
3. It will show our real device , click on play button
4. It will show mobile device.



npm install -g appium
npm install wd
brew install carthage


Enter below to check connected device with the Laptop
chrome://inspect/#devices in Chrome browser.
Click on inspect, it will launch connected device.

Now we can inspect element also, as it will show device in chrome. It will show the web applications only.

# Code to run chrome in mobile.


import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;

public class TestApp {
	
	
	public static AndroidDriver driver;
	
	public static void main(String[] args) throws MalformedURLException, InterruptedException {
		
		
		DesiredCapabilities cap = new DesiredCapabilities();
		cap.setCapability(CapabilityType.BROWSER_NAME, "Chrome");
		cap.setCapability(MobileCapabilityType.DEVICE_NAME,"android");
		
		driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), cap);
		driver.get("https://google.com");
		
		driver.findElement(By.name("q")).sendKeys("Hello Hello");
		
		Thread.sleep(2000);
		driver.quit();
		
	}

}












