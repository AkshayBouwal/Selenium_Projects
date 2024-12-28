package utilities;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

public class Screenshots {


    public static void takeScreenshot(WebDriver driver) {

        TakesScreenshot ts = (TakesScreenshot) driver;

        File source = ts.getScreenshotAs(OutputType.FILE);

        String destinationPath = System.getProperty("user.dir") + "/src/main/java/reports/screenshot" + TimeStamp.currentTimeStamp() + ".png";

        try {
            Files.copy(source.toPath(), new File(destinationPath).toPath());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    public static String takeScreenshotForListener(WebDriver driver) {

        String uniqueID = Long.toString(System.currentTimeMillis());

        TakesScreenshot ts = (TakesScreenshot) driver;

        File source = ts.getScreenshotAs(OutputType.FILE);

        String destinationPath = System.getProperty("user.dir") + "/src/main/java/reports/Listener" + uniqueID + ".png";

        try {
            Files.copy(source.toPath(), new File(destinationPath).toPath());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        return destinationPath;

    }


}
