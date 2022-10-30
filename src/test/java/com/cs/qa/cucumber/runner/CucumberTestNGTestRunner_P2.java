package com.cs.qa.cucumber.runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        features = "src/main/resources/Features",
        glue = {"com.cs.qa.cucumber.stepDefinitions"},
        monochrome = true,
        tags = "@Problem2",
        plugin = {})
public class CucumberTestNGTestRunner_P2 extends AbstractTestNGCucumberTests{

}
