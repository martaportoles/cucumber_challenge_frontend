package frontend.steps;

import frontend.pageObjects.CartPage;
import frontend.pageObjects.HomePage;
import frontend.utils.TestBase;
import frontend.utils.TestContextSetup;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;

import java.io.IOException;

public class HomePageStepdefs {
    WebDriver driver;


    TestContextSetup testContextSetup;

    HomePage homePage;
    CartPage cartPage;

    public HomePageStepdefs(TestContextSetup testContextSetup) throws IOException {
        this.testContextSetup = testContextSetup;
        this.homePage = testContextSetup.pageObjectManager.getLandingPage();
        this.cartPage = testContextSetup.pageObjectManager.getCartPage();
        this.driver = TestBase.WebDriverManager();
    }


    @When("User navigates to Laptop section")
    public void userNavigatesToLaptopPSection() {

        // homePage = new HomePage(this.driver);
        // this.homePage.openMonitorsPage();
        // this.homePage.openPhonesPage();
        this.homePage.openLaptopPage();
    }


    @When("user adds product to cart")
    public void userAddsProductToCart() {
        this.homePage.addToCart();
        this.homePage.acceptConfirmation();
    }


    @When("user navigates to {string} item page")
    public void user_navigates_to_item_page(String name) {
        this.homePage.openItemPage(name);
    }


    @Then("user navigates to cart page and validates {string} is on cart")
    public void user_navigates_to_cart_page_and_validates_is_on_cart(String name) {
        // this.cartPage = new CartPage(this.driver);
        this.cartPage.openCartPage();
        this.cartPage.verifyItemInCart(name);
        // this.driver.quit();

    }

}
