package com.cs.qa.cucumber.runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        features = "src/main/resources/Features",
        glue = {"com.cs.qa.cucumber.stepDefinitions"},
        monochrome = true,
        tags = "@Problem3",
        plugin = {})//"pretty", "io.qameta.allure.cucumber7jvm.AllureCucumber7Jvm"
public class CucumberTestNGTestRunner_P3 extends AbstractTestNGCucumberTests{

}
