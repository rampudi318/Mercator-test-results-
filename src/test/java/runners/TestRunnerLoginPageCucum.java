package runners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.Test;

@CucumberOptions(
        features = "src/test/resources/org/features/RamTest.feature",
        glue = {
                "org/stepdefinitions",
                "hooks",

        },
        plugin = {"pretty", "html:target/cucumber-html-report.html"})

@Test
public class TestRunnerLoginPageCucum extends AbstractTestNGCucumberTests {

}