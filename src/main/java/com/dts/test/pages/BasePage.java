package com.dts.test.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.openqa.selenium.support.pagefactory.ElementLocatorFactory;
import java.util.Random;

public class BasePage {
	public WebDriver driver;

	public BasePage(WebDriver driver) {
		ElementLocatorFactory finder = new AjaxElementLocatorFactory(driver, 30);
		PageFactory.initElements(finder, this);
		this.driver = driver;
	}

	protected void enterText(WebElement element, String text) {
		element.clear();
		element.sendKeys(text);
	}

	protected void clickElement(WebElement element) {
		element.click();
	}

	protected String getText(WebElement element) {
		return element.getText();
	}

	public String getTitle() {
		return driver.getTitle();
	}

	public String getRandomString(int length) {
		String chars = "abcdefghijklmnopqrstuvwxyz";
		StringBuilder sb = new StringBuilder();
		Random random = new Random();
		for (int i = 0; i < length; i++) {
			sb.append(chars.charAt(random.nextInt(chars.length())));
		}
		return sb.toString();
	}

	public String getRandomNumber(int length) {
		String chars = "0123456789";
		StringBuilder sb = new StringBuilder();
		Random random = new Random();
		for (int i = 0; i < length; i++) {
			sb.append(chars.charAt(random.nextInt(chars.length())));
		}
		return sb.toString();
	}
}
