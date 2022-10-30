package com.cs.qa.cucumber.runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        features = "src/main/resources/Features",
        glue = {"com.cs.qa.cucumber.stepDefinitions"},
        monochrome = true,
        tags = "@Problem1",
        plugin = {})
public class CucumberTestNGTestRunner_P1 extends AbstractTestNGCucumberTests{

}
