package testCases;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import constants.Constants;
import io.github.bonigarcia.wdm.WebDriverManager;
import utilities.ScreenShotCapture;

public class BaseClass {

	public static WebDriver driver;
	ScreenShotCapture sc;
	Properties properties=new Properties();
	FileInputStream fip;
	
	public BaseClass() {
		try {
			fip=new FileInputStream(Constants.CONFIG_FILE_PATH);
			properties.load(fip);
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}

	public void initialize(String browser, String url) {
		if(browser.equals("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver=new ChromeDriver();
		}
		else if(browser.equals("edge"))
		{
			WebDriverManager.edgedriver().setup();
			driver=new EdgeDriver();
		}
		else if(browser.equals("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver=new FirefoxDriver();
		}
		driver.get(url);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofMillis(5000));
		
	}
	
	@Parameters("browser")
	@BeforeMethod(alwaysRun = true, enabled = false)
	public void launch_Browser(String browser) {
		String url= properties.getProperty("url");
		initialize(browser, url);
		
	}
	
	@BeforeMethod(alwaysRun = true, enabled = true)
	public void launchBrowser() {
		String browser= properties.getProperty("browser");
		String url= properties.getProperty("url");
		initialize(browser, url);
		
	}

	@AfterMethod(alwaysRun = true)
	public void afterMethod(ITestResult itestResult) throws IOException {
		if (itestResult.getStatus() == ITestResult.FAILURE) {
			sc = new ScreenShotCapture();
			sc.captureScreenShotFailures(driver, itestResult.getName());
		}
		driver.close();
	}

	
	 
}

