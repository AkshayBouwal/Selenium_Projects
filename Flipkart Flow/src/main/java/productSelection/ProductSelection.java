package productSelection;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class ProductSelection {

    public WebDriver driver;
    private String brand;
    private String processor;
    private String ram;

    @FindBy(xpath = "//div[@class = 'tUxRFH']")
    private List<WebElement> productList;

    public ProductSelection(WebDriver driver, String brand, String processor, String ram) {

        this.driver = driver;
        this.brand = brand;
        this.processor = processor;
        this.ram = ram;
        PageFactory.initElements(driver, this);
        productSelection();
    }

    public void productSelection() {

        for (WebElement element : productList) {

            if (element.getText().contains(brand) && element.getText().contains(processor) && element.getText().contains(ram)) {
                element.click();

                Set<String> ids = driver.getWindowHandles();
                ArrayList<String> orderIds = new ArrayList<>(ids);

                driver.switchTo().window(orderIds.get(1));

                break;

            }
        }


    }


}
