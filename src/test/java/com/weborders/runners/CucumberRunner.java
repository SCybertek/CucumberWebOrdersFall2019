package com.weborders.runners;


import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)

@CucumberOptions(
        glue = "com/weborders/step_definitions", //you can omit having these..if steps are in the same root with features
        features = "src/test/resources/features", //thi is a must !!
        dryRun = false,
        strict = false,
        tags = "",
        plugin = "html:target/default-report"

)
public class CucumberRunner {


}
