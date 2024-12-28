import browserClose.BrowserClose;
import browserLaunch.BrowserLaunch;
import checkOut.CheckOut;
import findProduct.FindProduct;
import homePage.HomePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import productSelection.ProductSelection;
import utilities.Configurations;
import utilities.Screenshots;
import utilities.WaitManager;

public class TestRunner {

    private BrowserLaunch browser;
    private HomePage homePage;
    private FindProduct product;
    private ProductSelection selection;
    private CheckOut checkOut;
    private BrowserClose close;
    public WebDriver driver;

    @BeforeTest
    public void browserInvoke() {
        browser = new BrowserLaunch();
        driver = browser.driver;
    }

    @Test(priority = 1)
    public void homePageScreen() {

        WaitManager.implicitWait(driver, 5);

        homePage = new HomePage(driver, Configurations.getProperties("baseURL"));

        /*

        1. Just to showcase Explicit Wait and utilities
        2. Works fine even without below line

         */

        WaitManager.invisibilityOfElement(browser.driver, 20, browser.driver.findElement(By.xpath("//a[@class='_1jKL3b']")));

        driver = homePage.driver;

    }

    @Test(priority = 2)
    public void searchProduct() {


        product = new FindProduct(driver, Configurations.getProperties("productToBuy"));
        driver = product.driver;


    }

    @Test(priority = 3)
    public void productSelection() {

        selection = new ProductSelection(driver, Configurations.getProperties("productSpec1"), Configurations.getProperties("productSpec2"), Configurations.getProperties("productSpec3"));
        driver = selection.driver;


    }

    @Test(priority = 4)
    public void checkOut() {

        checkOut = new CheckOut(driver);
        driver = checkOut.driver;


    }

    @AfterTest
    public void browserClose() {

        close = new BrowserClose(driver);

    }

    @AfterMethod
    public void screenshot() {
        Screenshots.takeScreenshot(driver);
    }


}
