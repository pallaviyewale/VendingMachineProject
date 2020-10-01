import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
		features = "src/Tests/featureFiles",
		glue = {"Tests/stepDefinations"})
public class TestRunner
{
	

}