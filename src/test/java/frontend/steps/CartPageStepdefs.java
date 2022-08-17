package frontend.steps;

import frontend.pageObjects.CartPage;
import frontend.utils.TestBase;
import frontend.utils.TestContextSetup;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;

import java.io.IOException;


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

        this.cartPage.placeOrder();
        this.cartPage.fillData(userData);
        this.cartPage.purchase();
    }
}


