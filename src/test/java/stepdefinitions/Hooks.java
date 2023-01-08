package stepdefinitions;

import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import utilities.Driver;

import java.io.IOException;


public class Hooks {
    //private bcz i ll use it only in this class
    private AppiumDriverLocalService appiumServer = AppiumDriverLocalService.buildDefaultService();
    final Runtime runtime = Runtime.getRuntime();

    @Before
    public void setUp() {
        //it starts appium server
        forceStopAppiumServer();

        appiumServer.start();

    }

    @After
    public void tearDown(Scenario scenario) {
        final byte[] screenshot = ((TakesScreenshot) Driver.getAppiumDriver()).getScreenshotAs(OutputType.BYTES);
        if (scenario.isFailed()) {
            scenario.attach(screenshot, "image/png", "screenshots");
        }
       // Driver.quitAppiumDriver();
      //  appiumServer.stop();
    }

    public void forceStopAppiumServer() {
        try {
            runtime.exec("killall node");
            runtime.exec("pkill  -i xcodebuild");
            System.out.println("Kill all nodes");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}