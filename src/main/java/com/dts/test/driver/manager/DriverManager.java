package com.dts.test.driver.manager;

import java.net.MalformedURLException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

import com.dts.test.configutils.PropertyUtils;

import java.time.Duration;
import java.util.HashMap;
import java.util.Map;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DriverManager {

	
	public static WebDriver getDriverDynamic() throws MalformedURLException {
	    String defaultBrowser = PropertyUtils.getASpecificProperty("browser");
	    WebDriver driver;
	    switch (defaultBrowser.toLowerCase()) {
	        case "firefox":
	        case "ff":
	            driver = getFirefoxDriver();
	            break;
	        case "chrome":
	            driver = getChromeDriver();
	            break;
	        case "edge":
	            driver = getEdgeDriver();
	            break;    
	        default:
	            throw new IllegalArgumentException("Unsupported browser: " + defaultBrowser);
	    }
	    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
	    driver.manage().window().maximize();
	    return driver;
	}

	public static WebDriver getChromeDriver() {
        WebDriverManager.chromedriver().setup();
		ChromeOptions options = new ChromeOptions();

		Map<String, Object> preferences = new HashMap<>();

		// Disable password manager & address save prompt
		preferences.put("credentials_enable_service", false);
		preferences.put("profile.password_manager_enabled", false);

		// Disable autofill (addresses, phone numbers, etc.)
		preferences.put("autofill.profile_enabled", false);
		preferences.put("autofill.enabled", false);

		options.setExperimentalOption("prefs", preferences);

        return new ChromeDriver(options);
    }
	
	public static WebDriver getFirefoxDriver() {
        WebDriverManager.firefoxdriver().setup();
        return new FirefoxDriver();
    }
	
	public static WebDriver getEdgeDriver() {
        WebDriverManager.edgedriver().setup();
        return new EdgeDriver();
    }
	
}
