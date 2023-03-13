package elementRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.GeneralUtilities;

public class HomePage {

	WebDriver driver;
	GeneralUtilities gnrlUtl;

	public HomePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		gnrlUtl = new GeneralUtilities();
	}


	@FindBy(xpath = "//a[text()='Home']") 
	WebElement homepage;
	
	@FindBy(xpath = "//li[@class='nav-item dropdown']") 
	WebElement UserDropdown;
	
	@FindBy(xpath = "//a[@href='https://groceryapp.uniqassosiates.com/admin/logout']") 
	WebElement logoutButton;
	
	
	@FindBy(xpath = "//li[@class='nav-item']//i[@class='fas fa-bars']") 
	WebElement navBarIcon;
	
	

	public String getHomePageText() {
		
		String text = gnrlUtl.getElementText(homepage);
		return text;
	}
	
	public String getHomePageURL() {
		String url= gnrlUtl.getPageURL(driver);
		return url;
	}
	
	public String getHomePageTitle() {
		String url= gnrlUtl.getPageTitle(driver);
		return url;
	}
	
	public void performLogout() {
		gnrlUtl.buttonClick(UserDropdown);
		gnrlUtl.buttonClick(logoutButton);	
	}

	
}
