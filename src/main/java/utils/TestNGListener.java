package utils;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.io.File;
import java.io.IOException;

import static java.nio.file.Paths.get;

public class TestNGListener implements ITestListener {

    @Override
    public void onTestStart(ITestResult result) {
        System.out.println("TestNGListener. onTestStart");
//        String browserName = context.getCurrentXmlTest().getParameter("browserName");
//        WebDriverFactory.createInstance(browserName);
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        System.out.println("TestNGListener. onTestSuccess");
    }

    @Override
    public void onTestFailure(ITestResult result) {
        //int random = (int)(Math.random() * 50 + 1);
        //alternative code
        //TakesScreenshot ts = (TakesScreenshot)utils.WebDriverFactory.getDriver();
        //File source = ts.getScreenshotAs(OutputType.FILE);
        //end
//        File source = captureScreenshot();
//        try {
//            FileUtils.copyFile(source, new File("./Screenshots/Screen" + random + ".png"));
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
        System.out.println("TestNGListener. onTestFailure");
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        System.out.println("TestNGListener. onTestSkipped");
    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
        System.out.println("TestNGListener. onTestFailedButWithinSuccessPercentage");
    }

    @Override
    public void onStart(ITestContext context) {
        System.out.println("TestNGListener. onStart");
    }

    @Override
    public void onFinish(ITestContext context) {
        System.out.println("TestNGListener. onFinish");
    }


}
