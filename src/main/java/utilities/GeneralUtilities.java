package utilities;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class GeneralUtilities {

	public String getElementText(WebElement element) {
		String text = element.getText();
		return text;
	}

	public boolean elementPresence(WebElement element) {
		return element.isDisplayed();

	}

	public void buttonClick(WebElement element) {
		element.click();
	}
	
	public void clearField(WebElement element) {
		element.clear();
	}

	public void inputText(WebElement element, String text) {
		element.sendKeys(text);
	}

	public String getAlertMessage(WebDriver driver) {
		String msg = driver.switchTo().alert().getText();
		return msg;
	}

	public void acceptAlert(WebDriver driver) {
		driver.switchTo().alert().accept();
	}

	public String getBackgroundColor(WebElement element) {
		String buttonColor = element.getCssValue("background-color");
		return buttonColor;
	}

	public String getFontColor(WebElement element) {
		String fontColor = element.getCssValue("color");
		return fontColor;
	}

	public String getFontSize(WebElement element) {
		String fontSize = element.getCssValue("font-size");
		return fontSize;
	}
	
	 public String getPageURL(WebDriver driver)
	 {
		 String pageurl = driver.getCurrentUrl();
		 return pageurl;
	 }
	 
	 public String getPageTitle(WebDriver driver)
	 {
		 String pageTitle = driver.getTitle();
		 return pageTitle;
	 }
	 
	 public boolean isCheckboxEnabled(WebElement element)
	 {
		 return element.isSelected();	
				 }
	 
	 public boolean isRadioButtonEnabled(WebElement element)
	 {
		 return element.isSelected();
	 }
	 
	 public boolean getCheckboxSelection(WebElement element)
	 {
		 element.click();
		 return element.isEnabled();
	 }

	public String selectDropDownValue(WebElement element, String text) {
		Select select = new Select(element);
		select.selectByVisibleText(text);
		WebElement selectedElement = select.getFirstSelectedOption();
		String selectedText = selectedElement.getText();
		return selectedText;
	}

	public String selectDynamicItem(List<WebElement> element, String itemName, String dynamicPath) {
		String itemToDelete = null;
		for (int i = 0; i < element.size(); i++) {
			if (element.get(i).getText().equals(itemName)) {
				i = i + 1;
				itemToDelete = dynamicPath;
				break;
			}
		}
		return itemToDelete;
	}
	
	public void performFileUpload(WebElement element, WebDriver driver, String filePath) throws AWTException, InterruptedException {
		StringSelection ss = new StringSelection(filePath);
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(ss, null);
		
		Actions obj = new Actions(driver);
		obj.moveToElement(element).click().perform();
		Robot robot = new Robot();
		robot.delay(250);
		robot.keyPress(KeyEvent.VK_CONTROL);
		robot.keyPress(KeyEvent.VK_V);
		robot.delay(250);
		robot.keyRelease(KeyEvent.VK_CONTROL);
		robot.keyRelease(KeyEvent.VK_V);
		robot.delay(250);
		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);

	}

}
