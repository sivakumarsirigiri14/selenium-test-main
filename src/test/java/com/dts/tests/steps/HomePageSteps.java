package com.dts.tests.steps;

import com.dts.test.configutils.PropertyUtils;
import com.dts.test.pages.HomePage;

import io.cucumber.java.en.*;

public class HomePageSteps extends CommonSteps {
	public HomePage homePage;

	public HomePageSteps() {
		homePage = new HomePage(driver);
	}

	@Given("I am navigated to home page")
	public void i_am_navigated_to_home_page() {
		homePage.gotoHomePage();
	}
	@When("I click on registration")
	public void i_click_on_registration() {
		homePage.clickOnRegisterLink();
	}


	@When("I logout from the application")
	public void iLogoutFromTheApplication() {
		homePage.logOutFromApplication();
	}
}
