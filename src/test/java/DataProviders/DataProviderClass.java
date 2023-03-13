package DataProviders;

import org.testng.annotations.DataProvider;

import utilities.ExcelRead;

public class DataProviderClass {

	@DataProvider(name="loginData")
	public Object[][] loginData() throws Exception {
		Object[][] arrayObject = ExcelRead.getTableArray(System.getProperty("user.dir") + "\\src\\test\\resources\\ExcelRead\\userData.xlsx","Sheet1");
		return arrayObject;
	}
}
