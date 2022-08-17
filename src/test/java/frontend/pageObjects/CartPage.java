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
    // By placeOrder = By.linkText("Place Order");
    By placeOrder = By.cssSelector("#page-wrapper > div > div.col-lg-1 > button.btn.btn-success");

//    By cartPage = By.xpath("//a[contains(@onclick,'showcart()')]");
    By cartPage = By.linkText("Cart");
    By purchaseButton = By.xpath("//button[contains(.,'Purchase')]" );

    By okAlertButton = By.cssSelector("body > div.sweet-alert.showSweetAlert.visible > div.sa-button-container > div > button.confirm");;

    public void openCartPage() {
        this.driver.findElement(cartPage).click();
    }

    public void deleteProduct(String productName) {
        System.out.println(" CartPage::deleteProduct # Deleting product from cart");
        // By element = By.cssSelector("#tbodyid > tr:nth-child(2) > td:nth-child(4) > a");
        By elementPath = By.xpath(
                String.format("//*[@id=\"tbodyid\"]//td[contains(text(),\"%s\")]" +
                        "//ancestor::tr" +
                        "//td[contains(@onclick, 'deleteItem')]", productName));
        this.driver.findElement(elementPath).click();

        FluentWait wait = new FluentWait(this.driver);
        wait.until(ExpectedConditions.invisibilityOfElementLocated(elementPath));


    }

    public void placeOrder() {
        this.driver.findElement(placeOrder).click();
    }

    public void verifyItemInCart(String name) {
        System.out.println("Product is on the cart");
    }


    public void fillData(DataTable userData) throws Throwable{
        List<List<String>> rows = userData.asLists(String.class);
        //System.out.println(rows);

        int skipLines = 1;

        for (List<String> columns : rows) {
            System.out.println(columns);
            if (skipLines > 0) {
                skipLines--;
                continue;
            }

            this.driver.findElement(By.id("name")).sendKeys(columns.get(0));
            this.driver.findElement(By.id("country")).sendKeys(columns.get(1));
            this.driver.findElement(By.id("city")).sendKeys(columns.get(2));
            this.driver.findElement(By.id("card")).sendKeys(columns.get(3));
            this.driver.findElement(By.id("month")).sendKeys(columns.get(4));
            this.driver.findElement(By.id("year")).sendKeys(columns.get(5));

        }

    }


    public void purchase() {
        this.driver.findElement(purchaseButton).click();
    }

    public void acceptAlert() {
        this.driver.findElement(okAlertButton).click();
    }

    public String getAlertMessage() {

        return null;
    }

    public int getIdPurchase(String alertText) {
        return 0;
    }

    public double getAmountPurchase(String alertText) {
        return 0;
    }
}