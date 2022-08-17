package frontend;

import io.cucumber.junit.platform.engine.Cucumber;
import io.cucumber.junit.platform.engine.CucumberTestEngine;
import org.junit.platform.suite.api.ConfigurationParameter;
import org.junit.platform.suite.api.IncludeEngines;
import org.junit.platform.suite.api.SelectClasspathResource;
import org.junit.platform.suite.api.Suite;

import static io.cucumber.junit.platform.engine.Constants.PLUGIN_PROPERTY_NAME;

@Suite
@IncludeEngines("cucumber")
@SelectClasspathResource("frontend")
@ConfigurationParameter(key = PLUGIN_PROPERTY_NAME, value = "pretty")
/*
@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/java/features",
        glue = "steps"
)
*/
public class RunCucumberTest{
}
