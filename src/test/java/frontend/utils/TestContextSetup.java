package frontend.utils;

import frontend.pageObjects.PageObjectManager;
import org.openqa.selenium.WebDriver;

import java.io.IOException;

public class TestContextSetup {

    // le decimos que variables tienen que ser compartidas con los stepdefinitions

    public WebDriver driver;

    public PageObjectManager pageObjectManager;
    public TestBase testBase;
    public GenericUtils genericUtils;


    public TestContextSetup() throws IOException
    {
        this.testBase = new TestBase();
        this.pageObjectManager = new PageObjectManager(testBase.WebDriverManager());
        this.genericUtils = new GenericUtils(testBase.WebDriverManager());

    }

    public PageObjectManager pageObjectManager() {
        return this.pageObjectManager;
    }
}
