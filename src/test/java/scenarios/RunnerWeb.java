package scenarios;

import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;


@RunWith(Cucumber.class)
@CucumberOptions(features = "classpath:features", tags = "@test and not @wip", publish = true)
public class RunnerWeb {

}

