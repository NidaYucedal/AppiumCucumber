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
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.interactions.touch.TouchActions;
import org.testng.Assert;
import screens.HepsiScreen;
import utilities.Driver;
import utilities.ReusableMethods;

import static java.time.Duration.ofSeconds;
import static utilities.ReusableMethods.*;

public class HepsiStepDefs {

    //dumpsys window | grep -E "mCurrentFocus"

    AndroidDriver<MobileElement> driver = (AndroidDriver<MobileElement>) Driver.getAppiumDriver();
    HepsiScreen hepsi = new HepsiScreen();


    @Given("open app")
    public void open_app() throws InterruptedException {

        ReusableMethods.waitFor(5);
        Driver.getAppiumDriver();
        waitFor(5);
        // driver.switchTo().alert().accept();


    }

    @When("verify page is visible")
    public void verifyPageIsVisible() {

        Assert.assertTrue(hepsi.home.isDisplayed());
        //((AndroidDriver) driver).openNotifications();
        //((AndroidDriver) driver).pressKey(new KeyEvent(AndroidKey.BACK));
    }

    @And("click searchbox")
    public void clickSearchbox() {

        hepsi.searchBox.click();
        hepsi.searchBox.sendKeys("nutella");
        waitFor(3);
        hepsi.nutella.click();
        waitFor(5);

        scrollAndClick((AndroidDriver<MobileElement>) Driver.getAppiumDriver(), "Mini Nutella Kakaolu Fındık Kreması 25g");

        waitFor(2);
        Assert.assertTrue(hepsi.productName.isDisplayed());

    }

    @And("search a product and add to cart")
    public void searchAProductAndAddToCart() {

        waitFor(2);
        hepsi.addtocart.click();

    }

    @And("go to cart and verify product is visible")
    public void goToCartAndVerifyProductIsVisible() {

        waitFor(3);
        hepsi.gotocart.click();
        Assert.assertTrue(hepsi.productAtTheBasket.isDisplayed());
        waitFor(2);
        //hepsi.ok.click();

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
