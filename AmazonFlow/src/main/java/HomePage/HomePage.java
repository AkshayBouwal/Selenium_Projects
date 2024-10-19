package HomePage;

import org.openqa.selenium.WebDriver;

public class HomePage {

    private String urlHomePage;

    public WebDriver driver;


    public HomePage(WebDriver driver, String urlHomePage) {

        this.urlHomePage = urlHomePage;
        this.driver = driver;
        homePage(urlHomePage);
    }

    public void homePage(String urlHomePage) {

        driver.get(urlHomePage);
        //return driver;

    }


}
