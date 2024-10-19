import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class SingleClassFlowAmazon {

    public static void main(String[] args) {

        ChromeOptions options = new ChromeOptions();
        options.addArguments("start-maximized");

        WebDriver driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.get("https://www.amazon.in");


        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));

//        wait.until(ExpectedConditions.invisibilityOf(driver.findElement(By.xpath("//div[@class = 'nav-signin-tt nav-flyout']"))));

        driver.findElement(By.id("twotabsearchtextbox")).sendKeys("Laptop");

        List<WebElement> list = driver.findElements(By.xpath("//div[@class = 's-suggestion-container']"));

        //System.out.println(list.size());

        for (WebElement element : list) {

            //System.out.println(element.findElement(By.xpath("child::div[1]")).getText());

            if (element.findElement(By.xpath("child::div[1]")).getText().equals("laptop under 35000")) {

                element.findElement(By.xpath("child::div[1]")).click();
                break;

                //element.click();
            }

        }

        //List<WebElement> products = driver.findElements(By.xpath("//span[@class='a-size-medium a-color-base a-text-normal']"));

        List<WebElement> products = driver.findElements(By.xpath("//div[@class = 'puisg-col puisg-col-4-of-12 puisg-col-8-of-16 puisg-col-12-of-20 puisg-col-12-of-24 puis-list-col-right']"));

        for (WebElement element : products) {

            WebElement productDescription = element.findElement(By.xpath("descendant::span[@class='a-size-medium a-color-base a-text-normal']"));

            String laptop = productDescription.getText();

            //System.out.println("-> " + element.getText());
            //System.out.println(laptop);

            if (laptop.contains("Lenovo") && laptop.contains("Intel Core i3") && laptop.contains("8")) {
                System.out.println("I my in");
                element.findElement(By.xpath("descendant::button")).click();
                break;
            }
        }

        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//strong[text()='Item Added']")));

        driver.findElement(By.xpath("//a[normalize-space()='Go to Cart']")).click();

        String output = driver.findElement(By.xpath("//h4//span[@class='a-truncate-cut']")).getText();
        System.out.println(output);

        driver.findElement(By.name("proceedToRetailCheckout")).click();


        //driver.quit();


    }
}
