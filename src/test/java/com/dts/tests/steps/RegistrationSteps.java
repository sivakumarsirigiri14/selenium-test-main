package com.dts.tests.steps;

import com.dts.test.pages.RegistrationPage;
import io.cucumber.java.en.*;
import static org.junit.Assert.*;

public class RegistrationSteps extends CommonSteps {
	public RegistrationPage registrationPage;
	public static String userName;

	public RegistrationSteps() {
		registrationPage = new RegistrationPage(driver);
	}

	@And("I register the user")
	public void iRegisterTheUser() {
		 userName = registrationPage.registerUser();
	}

	@Then("I should see user registration successful")
	public void iShouldSeeUserRegistrationSuccessful() {
		assertEquals("Welcome "+ userName, registrationPage.getCreatedUserText());
		System.out.println(userName);
	}

	@And("I try to register with the same user created above")
	public void iTryToRegisterWithTheSameUserCreatedAbove() {
		registrationPage.registerUserWithUserId(userName);
	}

	@Then("I should see error as user is already exists")
	public void iShouldSeeErrorAsUserIsAlreadyExists() {
		assertEquals("This username already exists.",registrationPage.getUserErrorMessage());
	}
}
