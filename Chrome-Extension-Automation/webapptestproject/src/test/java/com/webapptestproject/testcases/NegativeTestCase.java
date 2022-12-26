package com.webapptestproject.testcases;

import java.awt.AWTException;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.webapptestproject.base.BaseClass;
import com.webapptestproject.pageobject.ChromeWebStorePage;
import com.webapptestproject.pageobject.ExtensionPage;
import com.webapptestproject.pageobject.GoogleTranslatePage;
import com.webapptestproject.utility.Log;

public class NegativeTestCase extends BaseClass{
	
	private ChromeWebStorePage chromeWebStorePage;
	private GoogleTranslatePage googleTranslatePage;
	private ExtensionPage extensionPage;
	
	@Parameters("browser")
	@BeforeMethod()
	public void setup(String browser) {
		loadBrowser(browser);
	}
	
	@AfterMethod()
	public void tearDown() {
		getDriver().quit();
	}
	
	@Parameters("extensionName")
	@Test
	public void validateLanguageErrorsAreNotDetected(String extensionName) throws InterruptedException, AWTException {
		Log.testCasestarts("validateLanguageErrorsAreNotDetected");
		// install extension
		chromeWebStorePage = new ChromeWebStorePage();
		chromeWebStorePage.searchExtension(extensionName);
		extensionPage = chromeWebStorePage.openExtensionPage(extensionName);
		extensionPage.installExtension();
		Log.info("Installed extension: " +extensionName);
		// perform test  | switch to google translate
		googleTranslatePage = extensionPage.openGoogleTranslatePage();
		Log.info("check if enabled");
		System.out.println(googleTranslatePage.checkIfEnabled());
		Log.info("add text input");
		Thread.sleep(3000);
		// los datos - spanish - the data
		String inputText = "los datos is precious";
		googleTranslatePage.getTextArea().sendKeys(inputText);
		Thread.sleep(3000);
		Log.info("checking for errors");
		String errorCount = googleTranslatePage.getErrorIconValue();
		String actualError = "1";
		Log.info("Asserting");
		boolean result = errorCount.equals(actualError);
		System.out.println(result);
		Assert.assertFalse(result, " No error Detected ! ");
		Thread.sleep(3000);
		Log.testCaseEnds("validateLanguageErrorsAreNotDetected");
	}
	
	
}
