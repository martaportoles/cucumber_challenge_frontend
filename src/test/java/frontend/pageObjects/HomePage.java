package frontend.pageObjects;

import dev.failsafe.internal.util.Assert;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static dev.failsafe.internal.util.Assert.*;
import static org.junit.jupiter.api.Assertions.assertTrue;


public class HomePage {
    public WebDriver driver;

    public HomePage(WebDriver driver) {
        this.driver = driver;
    }




    By phonesCategory = By.xpath("//a[contains(@onclick,'phone')]");

    By laptopCategory = By.xpath("//a[contains(@onclick,'notebook')]");
    By monitorsCategory = By.xpath("//a[contains(@onclick,'monitor')]");

    // By addToCart = By.xpath("//a[contains(@onclick,'addToCart(8)')]");
    // By addToCart = By.cssSelector("#tbodyid > div.row > div > a");
    By addToCart = By.linkText("Add to cart");

    //    By okConfirmation = new By.ByLinkText("OK");

    public void addToCart() {
        driver.findElement(addToCart).click();
    }


    public void acceptConfirmation(){
        try {
            Alert okConfirmation = driver.switchTo().alert();
            okConfirmation.accept();
//            WebDriverWait wait = new WebDriverWait(driver, 60).until(ExpectedConditions.
//                    presenceOfElementLocated(By.name("OK")));;
//            wait.until(ExpectedConditions.alertIsPresent());
//            Alert okConfirmation = driver.switchTo().alert();
//            System.out.println(okConfirmation.getText());
//            assertTrue(okConfirmation.getText().contains("OK"));
//            okConfirmation.accept();

        } catch (Exception e) {
            //exception handling
        }
//
    }
    public void openItemPage(String name) {
        By productName = new By.ByLinkText(name);

        try {
            driver.findElement(productName).click();
        } catch (Exception ex){
            driver.findElement(productName).click();
        }
    }

    public void openLaptopPage() {
        driver.findElement(laptopCategory).click();
    }

    public void openMonitorsPage() {
        driver.findElement(monitorsCategory).click();}

    public void openPhonesPage() {
        driver.findElement(phonesCategory).click();}
}