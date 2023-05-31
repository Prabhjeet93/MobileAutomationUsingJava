package testnglearning;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import utilities.ExcelReader;

public class TestParameterization {
	
	private WebDriver driver;
	private WebDriverWait wait;
	
	@BeforeMethod
	@BeforeTest
	public void setUp() {
		
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		wait = new WebDriverWait(driver, Duration.ofSeconds(10));

	}
	
	@AfterMethod
	@AfterTest
	public void tearDown() {
		
		driver.quit();
	}
	
	
	
	@Test(dataProvider = "dp")
	public void doLogin(String username, String password) {
		
		driver.get("http://gmail.com");
		driver.findElement(By.id("identifierId")).sendKeys(username);
		driver.findElement(By.xpath("//*[@id=\"identifierNext\"]/div/button/span")).click();

		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(
				"/html/body/div[1]/div[1]/div[2]/div/div[2]/div/div/div[2]/div/div[1]/div/form/span/section/div/div/div[1]/div[1]/div/div/div/div/div[1]/div/div[1]/input")))
				.sendKeys(password);

		// driver.findElement(By.xpath("/html/body/div[1]/div[1]/div[2]/div/div[2]/div/div/div[2]/div/div[1]/div/form/span/section/div/div/div[1]/div[1]/div/div/div/div/div[1]/div/div[1]/input")).sendKeys("dfsdfsfd");
		driver.findElement(By.xpath("//*[@id=\"passwordNext\"]/div/button/span")).click();

		
		
	}
	
	
	
	@DataProvider(name="dp")
	public Object[][] getData() {
		
		
		ExcelReader excel = new ExcelReader("./src/test/resources/excel/test_data2.xlsx");
		
		String sheetName = "LoginTest";
		
		int rowNum = excel.getRowCount(sheetName);
		int colNum = excel.getColumnCount(sheetName);
		
		
	//	System.out.println("Total rows are : "+rowNum+"----Total cols are : "+colNum);
		
	//	System.out.println(excel.getCellData(sheetName, 0, 2));
		
		 Object[][] data = new Object[rowNum-1][colNum];
		 /*
		 data[0][0] = excel.getCellData(sheetName, 0, 2);
		 data[0][1] = excel.getCellData(sheetName, 1, 2);
		 
		 data[1][0] = excel.getCellData(sheetName, 0, 3);
		 data[1][1] = excel.getCellData(sheetName, 1, 3);
		 
		 
		 data[2][0] = excel.getCellData(sheetName, 0, 4);
		 data[2][1] = excel.getCellData(sheetName, 1, 4);
		 */
		 
		 
		 for(int rows=2; rows<=rowNum; rows++) {
			 
			 
			 for(int cols=0; cols<colNum; cols++) {
				 
				 data[rows-2][cols] = excel.getCellData(sheetName, cols, rows);
				 
			 }
			 
		 }
		 
		 
		 
		 
		 return data;
	}
	
	
	
	
	
	

}
