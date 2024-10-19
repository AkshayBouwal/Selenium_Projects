package BrowserLaunch;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import java.time.Duration;

public class BrowserLaunch {

    private final String browserType;

    public WebDriver driver;

    public BrowserLaunch() {
        this("Chrome");
    }

    public BrowserLaunch(String browserType) {

        this.browserType = browserType;

        if (this.browserType.equalsIgnoreCase("FireFox")) {
            driver = fireFoxBrowser();
        } else if (this.browserType.equalsIgnoreCase("Edge")) {
            driver = edgeBrowser();
        } else {
            driver = chromeBrowser();
        }

    }

    public WebDriver chromeBrowser() {

        ChromeOptions options = new ChromeOptions();
        options.addArguments("start-maximized");

        WebDriver driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

        return driver;

    }

    public WebDriver edgeBrowser() {

        EdgeOptions options = new EdgeOptions();
        options.addArguments("start-maximized");

        WebDriver driver = new EdgeDriver(options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

        return driver;

    }

    public WebDriver fireFoxBrowser() {

        FirefoxOptions options = new FirefoxOptions();
        options.addArguments("start-maximized");

        WebDriver driver = new FirefoxDriver(options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

        return driver;

    }


}
