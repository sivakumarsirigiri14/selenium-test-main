package com.dts.tests.steps;

import java.net.MalformedURLException;

import org.openqa.selenium.WebDriver;

import com.dts.test.driver.manager.DriverManager;

public class CommonSteps {

	public static WebDriver driver;

	public CommonSteps() {
		if (driver == null) {
			try {
				driver = DriverManager.getDriverDynamic();
			} catch (MalformedURLException e) {
				e.fillInStackTrace();
			}
		}
	}

}