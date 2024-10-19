package FindProduct;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class FindProduct {

    private String productName;

    public WebDriver driver;

    @FindBy(id = "twotabsearchtextbox")
    private WebElement searchBox;

    @FindBy(xpath = "//div[@class = 's-suggestion-container']")
    private List<WebElement> suggestionList;


    public FindProduct(WebDriver driver,String productName) {
        this.driver = driver;
        this.productName = productName;
        PageFactory.initElements(driver, this);
        findProduct(productName);
    }

    public void findProduct(String productName) {

        searchBox.sendKeys(productName);

        for (WebElement element : suggestionList) {

            if (element.findElement(By.xpath("child::div[1]")).getText().equals("laptop under 35000")) {

                element.findElement(By.xpath("child::div[1]")).click();
                break;

            }

        }
    }


}
