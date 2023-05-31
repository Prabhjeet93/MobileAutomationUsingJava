package testnglearning;

import java.util.Date;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class TestParallelDataProvider {

	@Test(dataProvider = "dp1")
	public void doLogin(String username, String password) {
		Date d = new Date();
		System.out.println(username + "----" + password + "---" + d.toString());

		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@DataProvider(name = "dp1",parallel = true)
	public Object[][] getData() {

		Object[][] data = new Object[2][2];
		
		
		data[0][0]="trainer@way2automation.com";
		data[0][1]="sdfsdf";
		
		data[1][0]="java@way2automation.com";
		data[1][1]="sdfsfd";
		
		return data;
		
	}

}
