package utilities;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class Driver {
    private static AppiumDriver<MobileElement> appiumDriver;


    public static AppiumDriver getAppiumDriver() {
        URL appiumServerURL = null;
        try {
            appiumServerURL = new URL("http://127.0.0.1:4723/wd/hub");
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }

        if (appiumDriver == null) {
            DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
            desiredCapabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, ConfigReader.getProperty("automationName"));
            desiredCapabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, ConfigReader.getProperty("platformName"));
            desiredCapabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, ConfigReader.getProperty("platformVersion"));
            desiredCapabilities.setCapability(MobileCapabilityType.DEVICE_NAME, ConfigReader.getProperty("deviceName"));
            //desiredCapabilities.setCapability(MobileCapabilityType.APP, System.getProperty("user.dir")+ConfigReader.getProperty("appPath"));
            desiredCapabilities.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT, "60000");
            desiredCapabilities.setCapability("autoAcceptAlerts", true);
            desiredCapabilities.setCapability(MobileCapabilityType.NO_RESET, true);
            desiredCapabilities.setCapability("disableAndroidWatchers", true);
            //desiredCapabilities.setCapability(MobileCapabilityType.SUPPORTS_ALERTS, true);

            if (ConfigReader.getProperty("platformName").equals("Android")) {
                //if you do not provide app path so you should provide "appPackage" and "appActivity"
                desiredCapabilities.setCapability("appPackage", "com.pozitron.hepsiburada");
                desiredCapabilities.setCapability("appActivity", "com.hepsiburada.ui.startup.SplashActivity");
                //com.google.android.calculator");
                //"com.android.calculator2.Calculator
                //com.hepsiburada.ui.home.BottomNavigationActivity
                assert appiumServerURL != null;
                appiumDriver = new AndroidDriver(appiumServerURL, desiredCapabilities);
            } else if (ConfigReader.getProperty("platformName").equals("iOS")) {
                //if you do not provide app path so you should use "bundleId"
//                desiredCapabilities.setCapability("bundleId",ConfigReader.getProperty("iosBundleId"));
                assert appiumServerURL != null;
                appiumDriver = new IOSDriver(appiumServerURL, desiredCapabilities);
            } else {
                throw new UnsupportedOperationException("Invalid Platform Name " + ConfigReader.getProperty("platformName"));
            }
        }
        appiumDriver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        return appiumDriver;
    }


    public static void quitAppiumDriver() {
        if (appiumDriver != null) {
            appiumDriver.quit();
            appiumDriver = null;
        }
    }
}
/*
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;

public class Driver {
  private static AppiumDriver<MobileElement> driver;

  public static AppiumDriver<MobileElement> getDriver() {
    if (driver == null) {
      try {
        driver = new AndroidDriver<>(new URL("http://localhost:4723/wd/hub"), getDesiredCapabilities());
      } catch (MalformedURLException e) {
        e.printStackTrace();
      }
    }
    return driver;
  }

  private static DesiredCapabilities getDesiredCapabilities() {
    DesiredCapabilities capabilities = new DesiredCapabilities();
    // Burada cihazınızın özelliklerini belirtmeniz gerekiyor.
    // Örneğin:
    capabilities.setCapability("deviceName", "My Device");
    capabilities.setCapability("platformName", "Android");
    capabilities.setCapability("appPackage", "com.example.myapp");
    capabilities.setCapability("appActivity", "com.example.myapp.MainActivity");
    return capabilities;
  }
}

AppiumDriver<MobileElement> driver = Driver.getDriver();
 */