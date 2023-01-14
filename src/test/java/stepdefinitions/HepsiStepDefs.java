package stepdefinitions;


import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.Alert;
import org.openqa.selenium.NoAlertPresentException;
import screens.HepsiScreen;
import utilities.Driver;
import utilities.ReusableMethods;

import static java.time.Duration.ofSeconds;
import static utilities.ReusableMethods.scrollAndClick;
import static utilities.ReusableMethods.waitFor;

public class HepsiStepDefs {

    //dumpsys window | grep -E "mCurrentFocus"

    AndroidDriver<MobileElement> driver = (AndroidDriver<MobileElement>) Driver.getAppiumDriver();
    HepsiScreen hepsi = new HepsiScreen();


    @Given("open app")
    public void open_app() throws InterruptedException  {

        ReusableMethods.waitFor(5);
        Driver.getAppiumDriver();


    }

    @When("verify page is visible")
    public void verifyPageIsVisible() {

        waitFor(7);
        hepsi.searchBox.click();
        waitFor(5);
        //((AndroidDriver) driver).openNotifications();
        //((AndroidDriver) driver).pressKey(new KeyEvent(AndroidKey.BACK));

        try {
            // Get the alert
            Alert alert = Driver.getAppiumDriver().switchTo().alert();
            // Dismiss the alert
            alert.dismiss();
        } catch (NoAlertPresentException e) {
            // No alert is present, so do nothing

        }
    }

    @And("click searchbox")
    public void clickSearchbox() {

        hepsi.searchBox.sendKeys("nutella");
        waitFor(5);
        hepsi.nutella.click();
        waitFor(5);

        scrollAndClick((AndroidDriver<MobileElement>) Driver.getAppiumDriver(),"Mini Nutella Kakaolu Fındık Kreması 25g");

        //TouchActions action = new TouchActions(driver);
        //action.scroll(element, 10, 100);
        //action.perform();
        //element.click();


        try {
            new TouchAction(Driver.getAppiumDriver()).press(PointOption.point(988, 693)).
                    waitAction(WaitOptions.waitOptions(ofSeconds(1)))
                    .moveTo(PointOption.point(58, 693)).release().perform();
        } catch (Exception e) {
            System.out.println("unable to swipe");
        }










    }

    @And("search a product and add to cart")
    public void searchAProductAndAddToCart() {
    }

    @And("go to cart and verify product is visible")
    public void goToCartAndVerifyProductIsVisible() {
    }

    @And("click login and verify")
    public void clickLoginAndVerify() {
    }

    @And("enter valid data")
    public void enterValidData() {
    }

    @Then("verify user profile")
    public void verifyUserProfile() {
    }
}
