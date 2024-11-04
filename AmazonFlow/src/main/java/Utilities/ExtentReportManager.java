package Utilities;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class ExtentReportManager implements ITestListener {

    public ExtentTest test;

    public ExtentReports extent;


    @Override
    public void onStart(ITestContext context) {

        String uniqueID = Long.toString(System.currentTimeMillis());

        ExtentSparkReporter report = new ExtentSparkReporter("C:\\Users\\aksha\\IdeaProjects\\AmazonFlow\\src\\main\\resources\\index" + uniqueID + ".html");

        report.config().setReportName("Amazon Report");
        report.config().setDocumentTitle("Test Reports");
        report.config().setTheme(Theme.DARK);


        extent = new ExtentReports();
        extent.attachReporter(report);
        extent.setSystemInfo("Tester", "Akshay Bouwal");

    }

    @Override
    public void onTestSuccess(ITestResult result) {

        test = extent.createTest(result.getName());
        test.log(Status.PASS, "Test Case Passed : " + result.getName());

        WebDriver driver;

        try {

            //driver = (WebDriver) result.getTestClass().getRealClass().getField("driver").get(result.getInstance());

            driver = (WebDriver) result.getTestClass()
                    .getRealClass()
                    .getDeclaredField("driver")
                    .get(result.getInstance());


        } catch (IllegalAccessException | NoSuchFieldException e) {
            throw new RuntimeException(e);
        }

        String path = Screenshots.takeScreenshotForListener(driver);
        test.addScreenCaptureFromPath(path);


    }

    @Override
    public void onTestFailure(ITestResult result) {

        test = extent.createTest(result.getName());
        test.log(Status.FAIL, "Test Case Failed : " + result.getName());


    }

    @Override
    public void onFinish(ITestContext context) {
        extent.flush();
    }
}
