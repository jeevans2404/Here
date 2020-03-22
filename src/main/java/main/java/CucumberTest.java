package main.java;

import cucumber.api.CucumberOptions;



@CucumberOptions(plugin = { "html:target/site/cucumber-reports", "json:target/cucumber.json" }, features="src/test/resources/")
public class CucumberTest {
}
