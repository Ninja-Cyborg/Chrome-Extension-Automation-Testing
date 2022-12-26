package com.webapptestproject.pageobject;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.webapptestproject.base.BaseClass;
import com.webapptestproject.utility.Log;

public class ExtensionPage extends BaseClass{
	
	// https://chrome.google.com/webstore/category/extensions
	
	@FindBy(css="div[class='g-c-R  webstore-test-button-label']")
	private WebElement actionBtn;
	
	
	public ExtensionPage() {
		PageFactory.initElements(BaseClass.getDriver(), this);
	}
	
	// to add / remove extension
	public void installExtension() throws InterruptedException, AWTException {
		getActionBtn().click();
		// perform js alert actions
		Thread.sleep(5000);
		Robot robot = new Robot();
		robot.keyPress(KeyEvent.VK_LEFT);
	    robot.keyRelease(KeyEvent.VK_LEFT);  
	    Thread.sleep(3000);
	    robot.keyPress(KeyEvent.VK_ENTER);
	    robot.keyRelease(KeyEvent.VK_ENTER);
	    Thread.sleep(30000);
	}
	
	public boolean checkIfInstalled() throws InterruptedException, AWTException {
		Log.info("installing");
		installExtension();
		Thread.sleep(30000);
		switchToChromeWebStore();
		Log.info("Switched to Chrome WebStore");
		String actionBtnText = getActionBtn().getText();
		boolean verifyText = false;
		
			// if not installed
			if (actionBtnText.equalsIgnoreCase("Add To Chrome")) {
				getActionBtn().click();
				return false;
			}
			// if installed
			if (actionBtnText.equalsIgnoreCase("Remove from Chrome")) {
				return true;
			}
			// but not available for specified browser
			if(actionBtnText.equalsIgnoreCase("Available on Chrome")) {
				return false;
			}
			System.out.println(verifyText + " " + getActionBtn().getText());
		return verifyText;
	}

	public void switchToChromeWebStore() {
		Set<String> windows = BaseClass.getDriver().getWindowHandles();
		Iterator<String> it = windows.iterator();
		String parentWindowId = it.next();
		BaseClass.getDriver().switchTo().window(parentWindowId);
	}
	
	public GoogleTranslatePage openGoogleTranslatePage() throws InterruptedException {
		BaseClass.getDriver().switchTo().newWindow(WindowType.WINDOW);                // try new window
	//	BaseClass.getDriver().get("https://translate.google.ca/");
		BaseClass.getDriver().get("https://translate.google.ca/?sl=en&tl=es&op=translate");
		return new GoogleTranslatePage();
	}
	
	public WebElement getActionBtn() {
		return actionBtn;
	}
	
}
