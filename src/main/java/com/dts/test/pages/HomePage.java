package com.dts.test.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.openqa.selenium.support.pagefactory.ElementLocatorFactory;

import com.dts.test.configutils.PropertyUtils;

public class HomePage extends BasePage {

	@FindBy	(xpath = "//a[text()='Register']")
	private WebElement registerLink;

	@FindBy	(xpath = "//a[text()='Log Out']")
	private WebElement logoutLink;

	public HomePage(WebDriver driver) {
		super(driver);
		ElementLocatorFactory finder = new AjaxElementLocatorFactory(driver, 5);
		PageFactory.initElements(finder, this);
		this.driver = driver;
	}

	public void gotoHomePage() {
		driver.get(PropertyUtils.getASpecificProperty("env.url"));
	}

	public void clickOnRegisterLink(){
		clickElement(registerLink);
	}

	public void logOutFromApplication() {
		clickElement(logoutLink);
	}
}
