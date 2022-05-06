package cucumberTestRunner;

import io.cucumber.junit.Cucumber;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(plugin= {"pretty","html:target/cucumber-results/report.html",
		"json:target/cucumber-results/report.json"},monochrome=true,
		features="src/test/resources/features", glue= "stepDefinitions", tags= "not(@ignore or @deferred)"
		)

public class CucumberTestRunner extends AbstractTestNGCucumberTests {

}
	