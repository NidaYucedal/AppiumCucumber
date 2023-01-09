package utilities;


import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;
import java.util.concurrent.TimeUnit;

import static utilities.Driver.getAppiumDriver;


public class ReusableMethods {


    //hard wait THREAD.SLEEP
    //waitFor(5);  => waits for 5 second
    public static void waitFor(int sec) {
        try {
            Thread.sleep(sec * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    //elementlerin textlerine gore tiklar
    public static void tapOnElementWithText(String text) {
        List<MobileElement> mobileElementList = Driver.getAppiumDriver().findElementsByClassName("android.widget.TextView");
        for (MobileElement page : mobileElementList) {
            if (page.getText().equals(text)) {
                page.click();
            } else {
                scrollWithUiScrollable(text);
            }
            break;
        }
    }

    //ikinci alternatif bir method
    public static void clickOnElementWithText(String elementText) throws InterruptedException {
        Thread.sleep(4000);
        List<MobileElement> mobileElementList = Driver.getAppiumDriver().findElementsByXPath("//android.widget.TextView[@text='" + elementText + "']");
        if (mobileElementList.size() > 0) {
            mobileElementList.get(0).click();
        } else scrollWithUiScrollable(elementText);
    }


    //butun elementleri aldim text olarak elementimi tanimladim
    //eger text elementimi iceriyorsa
    //visible olmasini bekle true don
    public static boolean isElementPresent(String text) {
        boolean elementFound = false;
        List<MobileElement> mobileElementList = Driver.getAppiumDriver().findElementsByXPath("//android.widget.TextView[@text='" + text + "']");
        for (MobileElement el : mobileElementList) {
            if (el.getText().equals(text)) {
                waitToBeVisible(el, 10);
                if (el.isDisplayed()) {
                    elementFound = true;
                }
            }
        }
        return elementFound;
    }

    public static void wait(int second) {
        try {
            Thread.sleep(second * 1000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    //element gorunene kadar bekler click yapar
    public static void tapOn(MobileElement element) {
        waitToBeClickable(element, 10);
        element.click();
    }

    //sendkeys
    public static void enterText(MobileElement element, String text) {
        waitToBeClickable(element, 10);
        element.sendKeys(text);
    }

    //sendkeys 3 parametreli text dolu ise siliyor sonra send yapıyor
    public static void enterText(MobileElement element, String text, boolean needClear) {
        waitToBeClickable(element, 10);
        if (needClear) {
            element.clear();
        }
        element.sendKeys(text);
    }

    //element gorunuyor mu gorunmuyor mu
    //akıllı waitler 6. saniyede elementi bulursa geciyor 10 saniye beklemiyor
    public static boolean isElementPresent(MobileElement mobileElement) {
        boolean elementFound = false;
        waitToBeVisible(mobileElement, 10);
        if (mobileElement.isDisplayed()) {
            elementFound = true;
        }
        return elementFound;
    }

    //element gorunene kadar bekle
    public static void waitToBeVisible(MobileElement element, int timeout) {
        WebDriverWait wait = new WebDriverWait(Driver.getAppiumDriver(), timeout);
        wait.until(ExpectedConditions.visibilityOf(element));
    }

    public static void waitToBeClickable(MobileElement element, int timeout) {
        WebDriverWait wait = new WebDriverWait(Driver.getAppiumDriver(), timeout);
        wait.until(ExpectedConditions.elementToBeClickable(element));
    }

    public static void scrollWithUiScrollable(String elementText) {
        AndroidDriver<MobileElement> driver = (AndroidDriver) Driver.getAppiumDriver();
        driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"" + elementText + "\"))");
        tapOn(driver.findElementByXPath("//android.widget.TextView[@text='" + elementText + "']"));
    }


    public static void scrollToText(AndroidDriver<MobileElement> driver, String text) {
        MobileElement el = (MobileElement) driver.findElementByAndroidUIAutomator("new UiScrollable("
                + "new UiSelector().scrollable(true)).scrollIntoView(" + "new UiSelector().text(\"" + text + "\"));");
    }

    public static void scrollToId(AndroidDriver<MobileElement> driver, String id) {
        MobileElement el = (MobileElement) driver.findElementByAndroidUIAutomator(
                "new UiScrollable(" + "new UiSelector().scrollable(true)).scrollIntoView("
                        + "new UiSelector().resourceIdMatches(\"" + id + "\"));");
    }

    public static void scrollAndClick(AndroidDriver<MobileElement> appiumDriver, String visibleText) {
        AndroidDriver<MobileElement> driver = (AndroidDriver<MobileElement>) Driver.getAppiumDriver();
        driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector().textContains(\"" + visibleText + "\").instance(0))").click();
    }


    public static void waitToast(MobileElement element, int timeout) {
        // Set the implicit wait timeout to 10 seconds
        WebDriverWait wait = new WebDriverWait(getAppiumDriver(), timeout);
        wait.until(ExpectedConditions.visibilityOf(element));

        // Wait until the toast message becomes visible
        getAppiumDriver().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//android.widget.Toast[1]")));
        String toastMessage = getAppiumDriver().findElement(By.xpath("//android.widget.Toast[1]")).getText();
    }

    public static void scrollUp() {
        Dimension dimension= Driver.getAppiumDriver().manage().window().getSize();

        int start_x= (int) (dimension.width*0.5);
        int start_y= (int) (dimension.height*0.8);

        int end_x= (int) (dimension.width*0.5);
        int end_y= (int) (dimension.height*0.2);
        TouchAction touchAction=new TouchAction<>(Driver.getAppiumDriver());
        touchAction.press(PointOption.point(start_x,start_y))
                .waitAction(WaitOptions.waitOptions(Duration.ofSeconds(1)))













                .moveTo(PointOption.point(end_x,end_y)).perform();

    }


}

