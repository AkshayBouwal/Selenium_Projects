package Utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class WaitManager {

    public static void implicitWait(WebDriver driver, int seconds) {

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(seconds));

    }

    public static void invisibilityOfElement(WebDriver driver, int sec, WebElement element) {

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(sec));
        wait.until(ExpectedConditions.invisibilityOf(element));

    }
}
