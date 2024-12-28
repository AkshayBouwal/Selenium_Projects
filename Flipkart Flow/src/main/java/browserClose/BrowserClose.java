package browserClose;

import org.openqa.selenium.WebDriver;

public class BrowserClose {

    public WebDriver driver;

    public BrowserClose(WebDriver driver) {
        this.driver = driver;
        close();
    }

    public void close() {
        driver.quit();
    }
}
