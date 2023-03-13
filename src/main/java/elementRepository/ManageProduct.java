package elementRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.ExplicitWait;
import utilities.GeneralUtilities;

public class ManageProduct {

	WebDriver driver;
	GeneralUtilities gnrlUtl;
	ExplicitWait ew;

	public ManageProduct(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		gnrlUtl = new GeneralUtilities();
		ew = new ExplicitWait();
	}

	// web elements

	@FindBy(xpath = "//a[@class=' nav-link']//p[text()='Manage Product']") // with page factory
	WebElement managePdt;

	@FindBy(xpath = "//a[@onclick='click_button(1)']") // with page factory
	WebElement addNewPdtBtn;
	

	@FindBy(xpath = "//a[@onclick='click_button(2)']") // with page factory
	WebElement searchBtn;
	
	@FindBy(xpath = "//h4[@class='card-title']") // with page factory
	WebElement searchPageTitle;


	@FindBy(xpath = "//div[@class='content-header']//h1[text()='List Products']") // with page factory
	WebElement ManagePdtPageHeader;
	
	@FindBy(xpath = "//input[@name='unlimitw[]']") // with page factory
	WebElement unLtfStockChckbox;
	
	@FindBy(xpath = "//input[@value='Veg' and @name='type']") // with page factory
	WebElement RadioBtn_defaultPdtTyp;
	
	
	@FindBy(xpath = "//input[@name='price_type' and @id='purpose']") // with page factory
	WebElement RadioBtn_defaultPriceTyp;
	
	@FindBy(xpath = "//a[@href ='https://groceryapp.uniqassosiates.com/admin/list-product' and  @type='button']") // with page factory
	WebElement cancelBtn;
		

	// functions

	public void loadManageProductPage() {
		gnrlUtl.buttonClick(managePdt);

	}
	
	public boolean unLimitedStockCheckboxStatus() {
		return gnrlUtl.isCheckboxEnabled(unLtfStockChckbox);
	}
	
	public boolean ProductTypeDefaultValue() {
		return gnrlUtl.isRadioButtonEnabled(RadioBtn_defaultPdtTyp);
	}
	
	public boolean PriceTypeDefaultValue() {
		return gnrlUtl.isRadioButtonEnabled(RadioBtn_defaultPriceTyp);
	}

	public void loadAddNewPdtPage() {
		gnrlUtl.buttonClick(addNewPdtBtn);

	}
	
	public void loadSearchPage() {
		gnrlUtl.buttonClick(searchBtn);

	}
	
	public String getSearchPageTitleText() {
		String text = gnrlUtl.getElementText(searchPageTitle);
		return text;
	}

	public String getManageProductPageText() {
		String text = gnrlUtl.getElementText(ManagePdtPageHeader);
		return text;
	}
	
	
	public String getManagePdtPageTitle() {
		String url = gnrlUtl.getPageTitle(driver);
		return url;
	}
	
	public String getManagePdtPageURL() {
		String url = gnrlUtl.getPageURL(driver);
		return url;
	}
}
