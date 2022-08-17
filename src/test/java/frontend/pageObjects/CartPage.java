package frontend.pageObjects;

import io.cucumber.datatable.DataTable;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;

import java.util.List;
// import java.util.Map;

// import static sun.security.krb5.internal.crypto.KeyUsage.isValid;

public class CartPage {
    public WebDriver driver;

    public CartPage(WebDriver driver) {
        this.driver = driver;
    }


//    By deleteProduct = By.linkText("Delete");
    By placeOrder = By.linkText("Place Order");

//    By cartPage = By.xpath("//a[contains(@onclick,'showcart()')]");
    By cartPage = By.linkText("Cart");
    By purchaseButton = By.xpath("//button[contains(.,'Purchase')]" );

    public void openCartPage() {
        driver.findElement(cartPage).click();
    }

    public void deleteProduct(String productName) {

        By elementPath = By.xpath(
                String.format("//*[@id=\"tbodyid\"]//td[contains(text(),\"%s\")]" +
                        "//ancestor::tr" +
                        "//td[contains(@onclick, 'deleteItem')]", productName));
        driver.findElement(elementPath).click();

        FluentWait wait = new FluentWait(driver);
        wait.until(ExpectedConditions.invisibilityOfElementLocated(elementPath));


    }

    public void placeOrder() {
        driver.findElement(placeOrder).click();
    }

    public void verifyItemInCart(String name) {
        System.out.println("Product is on the cart");
    }


    public void fillData(DataTable userData) throws Throwable{
        List<String> data = userData.row(0);
        driver.findElement(By.id("name")).sendKeys(data.get(0));
        driver.findElement(By.id("country")).sendKeys(data.get(1));
        driver.findElement(By.id("city")).sendKeys(data.get(2));
        driver.findElement(By.id("card")).sendKeys(data.get(3));
        driver.findElement(By.id("month")).sendKeys(data.get(4));
        driver.findElement(By.id("year")).sendKeys(data.get(5));
//        FluentWait wait = new FluentWait(driver);
//        wait.until(ExpectedConditions.elementToBeSelected (purchaseButton));


//        List<Map<String, String>> signUpForms = userData.asMaps(String.class, String.class);
//
//        String name = signUpForms.get(0).get("Name");
//        String country = signUpForms.get(0).get("Country");
//        String city = signUpForms.get(0).get("City");
//        String cCard = signUpForms.get(0).get("Credit cart");
//        String month = signUpForms.get(0).get("Month");
//        String year = signUpForms.get(0).get("Year");

    }


    public void purchase() {
        driver.findElement(purchaseButton).click();
    }
}