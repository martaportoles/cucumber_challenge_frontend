package frontend.utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

public class TestBase {

    public static WebDriver driver;

    public static WebDriver WebDriverManager() throws IOException {

        FileInputStream fis = new FileInputStream(System.getProperty("user.dir")+"//src//test//resources//global.properties");
        Properties prop = new Properties();
        prop.load(fis);
        String url = prop.getProperty("QAUrl");
        String browser_properties = prop.getProperty("browser");
        String browser_maven=System.getProperty("browser");
        // result = testCondition ? value1 : value2

        String browser = browser_maven!=null ? browser_maven : browser_properties;

        if (driver == null) {
            if(browser.equalsIgnoreCase("chrome")) {
                System.setProperty("webdriver.chrome.driver","/usr/local/bin/chromedriver");
                driver = new ChromeDriver();// driver gets the life
//                driver.manage().window().maximize();

            }

            if(browser.equalsIgnoreCase("firefox")) {
                System.setProperty("webdriver.gecko.driver","/usr/local/bin/mozilla-geckodriver-9b5f85c");
                driver = new FirefoxDriver();
//                driver.manage().window().maximize();
            }

            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
            driver.get(url);
        }

        return driver;
    }
}
