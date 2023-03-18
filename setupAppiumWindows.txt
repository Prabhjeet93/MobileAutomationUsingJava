Install Java and set env variables
Install Android Studio, and set Environment variables
Install npm
Install Appium server
Install APpium Inspector
Real device -> Enable Developer Options, Connect with USB
Install Eclipse/VS code
Add appium dependency in POM.xml
Add testng, cucumber plugins in Eclipse

Mobile app -> take package name and activity name.
open the app and run this command->
#adb shell dumpsys activity activities | findStr "mFocused"

Code to start the appium server.
run this command one time.
$ npm install -g appium

$ run this command every time -> $appium  
to start the APpium server. -> I have method for this.

Once appium server is strted, device is connected.
$ adb devices -> to check the devices connected to the laptop.

Now we have set capabilities with App package name and activity name.
I have code for this.

Application will start. Now run automation code on this.

Code for the push notification, read OTP from message app is already present.
Try Finger Biometric code once get device.

Check code integrated in the framework for more details.