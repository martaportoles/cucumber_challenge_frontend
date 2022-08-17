package frontend.steps;

import frontend.utils.TestBase;
import frontend.utils.TestContextSetup;
import io.cucumber.java.en.Given;
import org.openqa.selenium.WebDriver;

import java.io.IOException;

public class Ordering {

    TestContextSetup testContextSetup;

    WebDriver driver;

    public Ordering(TestContextSetup testContextSetup) throws IOException {
        this.testContextSetup = testContextSetup;
        this.driver = TestBase.WebDriverManager();
    }

    @Given("I visit Demoblaze")
    public void i_visit_demoblaze() {

        this.driver.get("https://www.demoblaze.com");
//        driver.quit();
    }


}
