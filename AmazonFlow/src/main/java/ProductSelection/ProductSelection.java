package ProductSelection;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class ProductSelection {

    public WebDriver driver;
    private String brand;
    private String processor;
    private String ram;

    @FindBy(xpath = "//div[@class = 'puisg-col puisg-col-4-of-12 puisg-col-8-of-16 puisg-col-12-of-20 puisg-col-12-of-24 puis-list-col-right']")
    private List<WebElement> productList;

    @FindBy(xpath = "//strong[text()='Item Added']")
    private WebElement itemAddedPopup;

    public ProductSelection(WebDriver driver, String brand, String processor, String ram) {

        this.driver = driver;
        this.brand = brand;
        this.processor = processor;
        this.ram = ram;
        PageFactory.initElements(driver, this);
        productSelection();
    }

    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));

    public void productSelection() {

        for (WebElement element : productList) {

            WebElement productDescription = element.findElement(By.xpath("descendant::span[@class='a-size-medium a-color-base a-text-normal']"));

            String laptop = productDescription.getText();


            if (laptop.contains(brand) && laptop.contains(processor) && laptop.contains(ram)) {
                //System.out.println("I my in");
                element.findElement(By.xpath("descendant::button")).click();
                break;
            }
        }

        wait.until(ExpectedConditions.invisibilityOf(itemAddedPopup));

    }


}
