package stepdefinitions;


import io.appium.java_client.MobileElement;


import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import org.testng.Assert;
import screens.HepsiScreen;
import utilities.Driver;
import utilities.ReusableMethods;

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
        //driver.switchTo().alert().accept();


    }

    @When("verify page is visible")
    public void verifyPageIsVisible() {

        Assert.assertTrue(hepsi.home.isDisplayed());
        driver.openNotifications();
        driver.pressKey(new KeyEvent(AndroidKey.BACK));
    }

    @And("click searchbox")
    public void clickSearchbox() {

        waitFor(5);
        driver.openNotifications();
        driver.pressKey(new KeyEvent(AndroidKey.BACK));
        waitFor(4);
        hepsi.searchBox.click();
        hepsi.searchBox.sendKeys("nutella");
        driver.pressKey(new KeyEvent(AndroidKey.ENTER));
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
        driver.pressKey(new KeyEvent().withKey(AndroidKey.BACK));
        waitFor(3);
        hepsi.gotocart.click();
        waitFor(2);
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
