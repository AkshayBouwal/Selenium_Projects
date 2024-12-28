package checkOut;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import utilities.Configurations;

public class CheckOut {

    public WebDriver driver;

    @FindBy(xpath = "//button[@class='QqFHMw vslbG+ In9uk2 JTo6b7' or text()='Add to cart' ]")
    private WebElement addToCartButton;

    @FindBy(xpath = "//a[@class='T2CNXf QqLTQ-']")
    private WebElement productPurchased;

    @FindBy(xpath = "//span[normalize-space()='Place Order']")
    private WebElement placeOrderButton;

    public CheckOut(WebDriver driver) {

        this.driver = driver;
        PageFactory.initElements(driver, this);
        checkOut();

    }

    public void checkOut() {

        addToCartButton.click();

        Assert.assertTrue(productPurchased.getText().contains(Configurations.getProperties("productSpec1")));
        Assert.assertTrue(productPurchased.getText().contains(Configurations.getProperties("productSpec2")));
        Assert.assertTrue(productPurchased.getText().contains(Configurations.getProperties("productSpec3")));

        placeOrderButton.click();

    }

}
