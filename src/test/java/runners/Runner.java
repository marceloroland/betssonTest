package runners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        plugin = {
                "pretty",
                "html:target/reports/cucumber-report.html",
                "json:target/reports/cucumber-report.json"
        },
        features = "src/test/resources/features",
        glue = {"steps", "hooks"},
        dryRun = false,
        monochrome = true
)

public class Runner extends AbstractTestNGCucumberTests {
}
