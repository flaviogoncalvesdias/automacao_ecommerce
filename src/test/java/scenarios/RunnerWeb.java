package scenarios;

import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;


@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/resources/features",monochrome = false,tags = "@Regressao", glue = { "scenarios"})
public class RunnerWeb {

}
