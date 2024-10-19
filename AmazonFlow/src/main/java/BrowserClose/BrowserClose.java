package BrowserClose;

import org.openqa.selenium.WebDriver;

public class BrowserClose {

    private WebDriver driver;

    public BrowserClose(WebDriver driver) {
        this.driver = driver;
        close();
    }

    public void close() {
        driver.quit();
    }
}
