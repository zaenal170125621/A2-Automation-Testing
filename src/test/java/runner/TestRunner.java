package runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

/**
 * Test Runner class for Cucumber BDD tests.
 * Configures Cucumber to find features and step definitions,
 * and generates multiple report formats.
 */
@RunWith(Cucumber.class)
@CucumberOptions(
    features = "src/test/resources/features",
    glue = {"stepdefinitions", "hooks"},
    plugin = {
        "pretty",
        "html:target/cucumber-reports/cucumber-report.html",
        "json:target/cucumber-reports/cucumber-report.json",
        "junit:target/cucumber-reports/cucumber-report.xml"
    },
    monochrome = true,
    publish = false
)
public class TestRunner {
    // This class serves as the entry point for running Cucumber tests
    // No additional code needed - configuration is done via annotations
}
