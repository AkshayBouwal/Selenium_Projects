package Utilities;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.time.LocalDateTime;

public class Screenshots {


    public static void takeScreenshot(WebDriver driver) {


        LocalDateTime now = LocalDateTime.now();

        String str = now.toString().replace("-", "").replace(":", "").replace(".", "");

        TakesScreenshot ts = (TakesScreenshot) driver;

        File source = ts.getScreenshotAs(OutputType.FILE);

        String destinationPath = "C:\\Users\\aksha\\IdeaProjects\\AmazonFlow\\src\\main\\resources\\screenshot" + str + ".png";

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

        String destinationPath = "C:\\Users\\aksha\\IdeaProjects\\AmazonFlow\\src\\main\\resources\\Listener" + uniqueID + ".png";

        try {
            Files.copy(source.toPath(), new File(destinationPath).toPath());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        return destinationPath;

    }


}
