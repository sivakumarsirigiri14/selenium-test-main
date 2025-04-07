package com.dts.test.runners;

import org.junit.runner.RunWith;

//import cucumber.api.CucumberOptions;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(plugin = {"pretty","html:target/test-report.html","json:target/cucumber.json"}, 
features = { "classpath:TestScenarios/" },
//dryRun=true,
tags = "@regression",
glue = "com.dts.tests.steps")
public class TestRunner {


}
