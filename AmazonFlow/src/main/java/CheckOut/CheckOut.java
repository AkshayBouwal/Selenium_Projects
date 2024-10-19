package CheckOut;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CheckOut {

    public WebDriver driver;

    @FindBy(xpath = "//a[normalize-space()='Go to Cart']")
    private WebElement goToCart;

    @FindBy(xpath = "//h4//span[@class='a-truncate-cut']")
    private WebElement productPurchased;

    @FindBy(name = "proceedToRetailCheckout")
    private WebElement checkOutButton;

    public CheckOut(WebDriver driver) {

        this.driver = driver;
        PageFactory.initElements(driver, this);
        checkOut();

    }

    public void checkOut() {

        goToCart.click();
        System.out.println(productPurchased.getText());
        checkOutButton.click();
    }

}
