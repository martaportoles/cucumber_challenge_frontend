package frontend.pageObjects;

import org.openqa.selenium.WebDriver;

public class PageObjectManager {

    public HomePage homePage;
    public CartPage cartPage;

    public WebDriver driver;

    public PageObjectManager(WebDriver driver) {
        this.driver = driver;
    }


    public HomePage getLandingPage() {
        this.homePage = new HomePage(this.driver);
        return this.homePage;
    }

    public CartPage getCartPage() {
        this.cartPage = new CartPage(this.driver);
        return this.cartPage;
    }
}
