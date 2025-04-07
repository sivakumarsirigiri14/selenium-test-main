package com.dts.tests.steps;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriverException;

import io.cucumber.java.After;
import io.cucumber.java.Scenario;

public class SharedSteps extends CommonSteps {

	/**
	 * Take screen shot
	 * 
	 * @param scenario
	 */
	@After
	public void embedScreenshot(Scenario scenario) {
		try {
			byte[] bytes = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
			scenario.attach(bytes, "image/png", scenario.getName());
		} catch (WebDriverException wde) {
			System.err.println(wde.getMessage());
		} catch (Exception e) {
			e.printStackTrace();
		}
		driver.close();
		driver = null;
	}
}
