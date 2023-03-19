package stepdefinitions;


import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
import screens.HepsiScreen;
import utilities.Driver;
import static utilities.ReusableMethods.*;

public class HepsiStepDefs {

    //dumpsys window | grep -E "mCurrentFocus"

    AndroidDriver<MobileElement> driver = (AndroidDriver<MobileElement>) Driver.getAppiumDriver();
    HepsiScreen hepsi = new HepsiScreen();


    @Given("open app")
    public void open_app() throws InterruptedException {

        Driver.getAppiumDriver();
        waitFor(5);

    }

    @When("verify page is visible")
    public void verifyPageIsVisible() {

        Assert.assertTrue(hepsi.home.isDisplayed());

    }

    @And("click searchbox")
    public void clickSearchbox() {

        waitFor(4);
        hepsi.searchBox.click();
        hepsi.searchBox.sendKeys("nutella");
        waitFor(3);
        hepsi.nutella.click();
        waitFor(5);

        scrollAndClick((AndroidDriver<MobileElement>) Driver.getAppiumDriver(), "Nutella Fındık ve Kakao Kreması 400 gr");

        waitFor(2);
        Assert.assertTrue(hepsi.productName.isDisplayed());

    }

    @And("search a product and add to cart")
    public void searchAProductAndAddToCart() {

        hepsi.addtocart.click();
    }

    @And("go to cart and verify product is visible")
    public void goToCartAndVerifyProductIsVisible() {

        waitFor(3);
        hepsi.gotocart.click();
        waitFor(2);
        Assert.assertTrue(hepsi.productAtTheBasket.isDisplayed());
        waitFor(2);
        hepsi.completeShopping.click();
        waitFor(3);

    }

    @And("click login and verify")
    public void clickLoginAndVerify() {

        waitFor(2);
        hepsi.email.click();
        hepsi.email.sendKeys("xoyeb32553@moneyzon.com");
        waitFor(2);
        hepsi.login.click();
        waitFor(2);

    }

    @And("enter valid data")
    public void enterValidData() {

        hepsi.password.click();
        hepsi.password.sendKeys("1234Jane");
        waitFor(2);
        hepsi.passwordPageLogin.click();
        waitFor(2);

    }

    @Then("verify user profile")
    public void verifyUserProfile() {

        driver.navigate().back();
        waitFor(2);
        hepsi.homePage.click();
        waitFor(2);
        hepsi.profile.click();
        waitFor(2);
        Assert.assertTrue(hepsi.userName.isDisplayed());
        waitFor(2);



        driver.closeApp();

    }
}
