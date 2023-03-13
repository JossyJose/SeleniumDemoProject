package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import constants.Constants;
import elementRepository.HomePage;
import elementRepository.LoginPage;
import elementRepository.ManageProduct;

public class ManageProductTestCases extends BaseClass {

	LoginPage lp;
	HomePage hp;
	ManageProduct mp;

	@Test(enabled = true)
	public void verifyManageProductTitle() {
		lp = new LoginPage(driver);
		mp = new ManageProduct(driver);
		lp.performLogin(Constants.userName, Constants.password);
		mp.loadManageProductPage();
		Assert.assertEquals(mp.getManagePdtPageTitle(), Constants.ManagePdtPageTitle,
				"::Page Title is as expected");
	}
	
	@Test(enabled = true)
	public void verifyManageProductURL() {
		lp = new LoginPage(driver);
		mp = new ManageProduct(driver);
		lp.performLogin(Constants.userName, Constants.password);
		mp.loadManageProductPage();
		Assert.assertEquals(mp.getManagePdtPageURL(), Constants.ManagePdtPageURL,
				"::Page URL is as expected");

	}

	@Test(enabled = true)
	public void verifyManageProductPageisLoaded() {
		lp = new LoginPage(driver);
		mp = new ManageProduct(driver);
		lp.performLogin(Constants.userName, Constants.password);
		mp.loadManageProductPage();
		Assert.assertEquals(mp.getManageProductPageText(), Constants.ManagePdtPageHeader, ":: Page is loaded");
	}

	@Test(enabled = true)
	public void verifyAddNewProductPageDefaultCheckboxValuesSelected() {
		lp = new LoginPage(driver);
		hp = new HomePage(driver);
		mp = new ManageProduct(driver);
		lp.performLogin(Constants.userName, Constants.password);
		mp.loadManageProductPage();
		mp.loadAddNewPdtPage();
		Assert.assertTrue(mp.unLimitedStockCheckboxStatus(), " Checkbox is selected by default");
	}
	
	@Test(enabled = true)
	public void verifyAddNewProductPageDefaultRadioButtonValues() {
		lp = new LoginPage(driver);
		hp = new HomePage(driver);
		mp = new ManageProduct(driver);
		lp.performLogin(Constants.userName, Constants.password);
		mp.loadManageProductPage();
		mp.loadAddNewPdtPage();
		Assert.assertTrue(mp.ProductTypeDefaultValue(), ":: Radio button  Veg selected by default");
		Assert.assertTrue(mp.PriceTypeDefaultValue(), "::Radio button Weight selected by default");
	}

	@Test(enabled = true)
	public void verifyProductSearchPageLoad() {
		lp = new LoginPage(driver);
		hp = new HomePage(driver);
		mp = new ManageProduct(driver);
		lp.performLogin(Constants.userName, Constants.password);
		mp.loadManageProductPage();
		mp.loadSearchPage();
		Assert.assertEquals(mp.getSearchPageTitleText(), Constants.ManagePdtPageSearchboxTitle,
				"Product search page is opened");

	}
	
}
