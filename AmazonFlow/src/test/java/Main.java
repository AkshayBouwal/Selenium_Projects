import BrowserClose.BrowserClose;
import BrowserLaunch.BrowserLaunch;
import CheckOut.CheckOut;
import FindProduct.FindProduct;
import HomePage.HomePage;
import ProductSelection.ProductSelection;
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


    @BeforeTest
    public void testCase1() {

        browser = new BrowserLaunch();

    }

    @Test()
    public void testCase2() {

        homePage = new HomePage(browser.driver, "https://www.amazon.in");

    }

    @Test(dependsOnMethods = "testCase2")
    public void testCase3() {

        product = new FindProduct(homePage.driver, "Laptop");


    }

    @Test(dependsOnMethods = "testCase3")
    public void testCase4() {

        selection = new ProductSelection(product.driver, "Lenovo", "Intel Core i3", "8");

    }

    @Test(dependsOnMethods = "testCase4")
    public void testCase5() {

        checkOut = new CheckOut(selection.driver);

    }

    @AfterTest
    public void testCase6() {

        close = new BrowserClose(checkOut.driver);

    }


}
