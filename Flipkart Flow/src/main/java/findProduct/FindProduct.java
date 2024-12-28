package findProduct;

import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class FindProduct {

    private String productName;

    public WebDriver driver;

    @FindBy(name = "q")
    private WebElement searchBox;

    @FindBy(xpath = "//ul[@class='_1sFryS _2x2Mmc _3ofZy1']/li")
    private List<WebElement> suggestionList;


    public FindProduct(WebDriver driver, String productName) {
        this.driver = driver;
        this.productName = productName;
        PageFactory.initElements(driver, this);
        findProduct(productName);
    }

    public void findProduct(String productName) {

        searchBox.sendKeys(productName);

        for (WebElement element : suggestionList) {

            try {

                if (element.getText().equals("laptop under 40000")) {

                    element.click();

                    break;

                }

            } catch (StaleElementReferenceException e) {
                /*
                Another Solution: using another form of xpath to click on same element
                 */
                System.out.println("Stale Element Reference Exception");
            }


        }
    }


}
