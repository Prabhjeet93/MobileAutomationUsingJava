Tools/ Library/ APIs to test Mobile Applications - 
1. Robotium -> APplication code is required, only for Android
2. Calabash - > Both, BDD, Supports only Ruby
3. Appium -> Both, Best
4. Selendroid -> Android
5. iOS - Driver -> iOS


Appium - is just a wrapper over the Selenium.


There are 3 types of mobile APplication.
1. Native -> Internal Applications, Camera, Cal, 
2. Hybrid -> Mixed - Facebook, LinkedIn
3. WebApps -> browser based, Chrome, Safari


Android (Win, Mac, Linux) and iOS ( Mac)

IOS - to test on Real device we need License from Apple Dev Org
IOS Simulators.

Android can test from Android Studio.


Pre requisite -> 
1. Java JDK 1.8
2. Android Studio
3. IDE -> Eclipse, VS code
4. Apium Tool GUI
5. Appium Jar - API
6. Selenium Jar

Specific to iOS
1. xcode





We need -> 
1. Core Java
2. Selenium Basics


HP/ QTP / UFT  -> VB scripts, Windows

Web based - Selenium, / QTP
Desktop based - QTP 
Mobile app - APpium
Webservices - Rest/ SOAP -> Postman, Rest Assured
TV app - 
Database - 

Current Version of Selenium 4.0.0 Alpha 5, released in March of 2020.
Started by Thoughtworks. Jasson Huggins - 2004


We can use selenium IDE for the mouse hover or similar tasks, if you are stucking anywhere.
IDE, Grid, WebDriver, RC ( Remote Control ) - 4.1.4 - 4.x

Components used -: 
TestNG/ JUnit - Frameworks
Maven
Jenkins - 
CucumberBDD - Framework
Page Object Model
Page Factories
Extent reports/ ReportNG / Allure
Log4J
Apache POI
Robot Class
JavaMail API
JDBC
Properties - Locators, config mainatains
Datadriven, Keyword Driven Frameworks


Install 
1. IDE - Eclipse, VS code
2. JDK 1.8


Add jdk to Environment Variables 
In Windows : 
1. Open System Environment Variables
2. User variables ->
3. System Variables -> New -> 
var name - JAVA_HOME
value - c:/program files/java/jdk1.8.0

4. open Path -> New
add -> %JAVA_HOME%\bin


In MAC  : 
Create a bash profile

$ touch .bash_profile
$ open .bash_profile

In file write -> 
export JAVA_HOME = /Library/Java/JavaVirtualMachines/jdk1.8.0_281.jdk/Content/Home
export MAVEN_HOME = /Users/<user>/Downloads/apache-maven-3.6.3
export Path = $PATH:$JAVA_HOME/bin:$MAVEN_HOME/bin


Save it and check Java version.

