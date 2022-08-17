package frontend.steps;

import frontend.pageObjects.CartPage;
import frontend.utils.TestBase;
import frontend.utils.TestContextSetup;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.IOException;
import java.time.Duration;
import java.util.logging.Level;
import java.util.logging.Logger;


public class CartPageStepdefs {
    public WebDriver driver;

    TestContextSetup testContextSetup;

    CartPage cartPage;

    public CartPageStepdefs(TestContextSetup testContextSetup) throws IOException {
        this.testContextSetup = testContextSetup;
        this.cartPage = this.testContextSetup.pageObjectManager.getCartPage();
        this.driver = TestBase.WebDriverManager();
    }

    @Given("I visit cart")
    public void iVisitCart() {
        this.driver.get("https://www.demoblaze.com");
        // cartPage = new CartPage(driver);
        this.cartPage.openCartPage();
    }

    @When("user deletes {string} from cart")
    public void userDeletesFromCart(String productName) {
        this.cartPage.deleteProduct(productName);
    }

    @Then("user complete the order with:")
    public void userCompleteTheOrderWith(DataTable userData) throws Throwable {
        long seconds = 3;

        this.cartPage.placeOrder();

        WebDriverWait wait = new WebDriverWait(this.driver, Duration.ofSeconds(seconds));
        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("#orderModal > div > div > div.modal-footer > button.btn.btn-primary")));

        this.cartPage.fillData(userData);
        this.cartPage.purchase();

    }

    @And("capture and log purchase Id and Amount")
    public void captureAndLogPurchaseIdAndAmount() {
        Logger logger = Logger.getLogger(CartPageStepdefs.class.getName());
        logger.log(Level.INFO, "Id y Amount of the purchase");
        String alertText = this.cartPage.getAlertMessage();
        int id = this.cartPage.getIdPurchase(alertText);
        double amount = this.cartPage.getAmountPurchase(alertText);

        logger.log(Level.INFO, "Id y Amount of the purchase");
    }

    @And("Assert purchase amount equal expected")
    public void assertPurchaseAmountEqualExpected() {
    }

    @And("click {string}")
    public void click(String arg0) {
        this.cartPage.acceptAlert();
    }
}


