
How to reaqd properties file.

Create object.properties file in a separate file.
we will be storing data as key value pair.

username_xpath = //userxpath
password = #passwd



We can have different file
config.properies file which will be containing the data used in the framework.

package learnauto;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class TestProperties {
	
	
	public static Properties or = new Properties();
	public static FileInputStream fis;
	
	public static void main(String[] args) {
		
		try {
			fis = new FileInputStream("path of the properties file");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			or.load(fis);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		or.getProperty("username_xpath"); // print the value of username_xpath from properties file.
	}

}





Log4j -:> we use this lib to generate logs.

1. Add log4j dependency
2. Logger class - getLogger()
3. Info, Debug, Error
4. Log4j.properties file - contains -> Appenders
5. PropertyConfigurator

//2 and 3 are done below.
//Logger should be imported from org.apache.log4j
public static Logger log = Logger.getLogger(TestProperties.class);

	public static void main(String[] args) {
		
		log.info("Starting the test case");
		log.info("Inside First try statement");
		log.info("Inside 2nd try statement");
		log.info("End of test case");
		
}

Add below code in a log4j.properties file

log4j.rootLogger=INFO, Appender
log4j.appender.Appender=org.apache.log4j.FileAppender
log4j.appender.file.File=logs/main.log
log4j.appender.file.layout=org.apache.log4j.PatternLayout
log4j.appender.file.layout.ConversionPattern=%d %d{Z} [%t] %-5p (%F:%L) - %m%n
log4j.appender.file.Append=false
log4j.appender.file.ImmediateFlush=true
log4j.appender.file.MaxFileSize5MB
log4j.appender.file.MaxBackupIndex=5



Now provide this log4j.properies file using PropertyConfigurator class

public static Logger log = Logger.getLogger(TestProperties.class);

	public static void main(String[] args) {
		PropertyConfigurator.configure("path of the log4j.properties file"); // it will add above config while generating logs.
		log.info("Starting the test case");
		log.info("Inside First try statement");
		log.info("Inside 2nd try statement");
		log.info("End of test case");
		
}




JavaMail API -:>

TO send report to the email.

Add javamail API to the POM.xml File
utitliy mentioned in the code. -> MonitoringMail.java

call method sendMail().

MonitoringMail mail = new MonitoringMail()
mail.sendMail(mailServer, from, to, subject, messagebody, attachementpath, attachementname);
mail.sendMail("smtp.gmail.com", from, to, subject, messagebody, );
we can put all these variables in a .properties file and read them from there.






