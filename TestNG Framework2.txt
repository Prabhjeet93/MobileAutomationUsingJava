TestNG
Parameterization
Parallel test execution
Properties
Log4J
JavaMail API



Parameterization -:>
we have an excel sheet.
username password
user1    pass1
user2    pass2
user3    pass3


and we have to test 100 users for the login test case.
We will use below code for the same.

Install all POI's dependencies.

package learnauto;

import org.testng.annotations.Test;

public class TestParameterization {
	
	
	@Test(dataProvider = "dp")
	public void login(String username, String password) {
		
	}
	
	
	@DataProvider(name="dp")
	public Object[][] getData() {
		
		ExcelReader excel = new ExcelReader("path of excel sheet");
		
		String sheetName = "LoginTest";
		int rowNum = excel.getRowCount(sheetName);
		int colNum = excel.getColumnCount(sheetName);
		
		Object[][] data = new Object[rowNum-1][colNum];
		
		for(int rows=2; rows<=rowNum; rows++) {
			for(int cols=0;cols<colNum;cols++) {
				data[rows-2][cols] = excel.getCellData(sheetName, cols, rows);
				
			}
		}
		
	}

}




Run tests in Parallel.
 we need to create a xml file. and provide parallel = tests.

We can add parallel = true in th edata provider also.

	@DataProvider(name="dp", parallel=true)
	public Object[][] getData() {
}


<suite name = "Suite" parallel="tests" >
<test thread-count="5" name="Chrome Test">
<parameter name="browser" value="chrome" />
<classes>
<class name = "testnglearning.TestParametersXML"/>

</classes>
</test>

<test thread-count="5" name="Firefox Test">
<parameter name="browser" value="firefox" />
<classes>
<class name = "testnglearning.TestParametersXML"/>

</classes>
</test>
</suite>


In code -> 

public class Paralleltest {
	
	
	@parameters({"browser","url"})
	@Test
	public void browserTest(String browser, String url) {
		
	}

}





