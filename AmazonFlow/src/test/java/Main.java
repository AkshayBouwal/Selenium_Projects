import BrowserClose.BrowserClose;
import BrowserLaunch.BrowserLaunch;
import CheckOut.CheckOut;
import FindProduct.FindProduct;
import HomePage.HomePage;
import ProductSelection.ProductSelection;
import Utilities.Screenshots;
import Utilities.WaitManager;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Main {

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
    }

    @Test(priority = 1)
    public void homePageScreen() {

        WaitManager.implicitWait(browser.driver, 5);

        homePage = new HomePage(browser.driver, "https://www.amazon.in");

        /*

        1. Just to showcase Explicit Wait and utilities
        2. Works fine even without below line

         */

        //WaitManager.invisibilityOfElement(browser.driver, 20, browser.driver.findElement(By.xpath("//div[@class = 'nav-signin-tt nav-flyout']")));

        driver = browser.driver;

    }

    @Test(priority = 2)
    public void searchProduct() {


        product = new FindProduct(homePage.driver, "Laptop");
        driver = homePage.driver;


    }

    @Test(priority = 3)
    public void productSelection() {

        selection = new ProductSelection(product.driver, "Lenovo", "Intel Core i3", "8");
        driver = product.driver;


    }

    @Test(priority = 4)
    public void checkOut() {

        checkOut = new CheckOut(selection.driver);
        driver = selection.driver;


    }

    @AfterTest
    public void browserClose() {

        close = new BrowserClose(checkOut.driver);

    }

    @AfterMethod
    public void screenshot() {
        Screenshots.takeScreenshot(driver);
    }


}
