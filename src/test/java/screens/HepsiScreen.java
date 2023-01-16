package screens;


import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class HepsiScreen {

    public HepsiScreen() {
        PageFactory.initElements(new AppiumFieldDecorator(Driver.getAppiumDriver()),this);
    }


    @AndroidFindBy(id="com.pozitron.hepsiburada:id/image_message_of_day")
    public MobileElement home;

    @AndroidFindBy(id="com.pozitron.hepsiburada:id/homeComponents")
    public MobileElement space;

    @AndroidFindBy(id = "com.pozitron.hepsiburada:id/etSearchBox")
    public MobileElement searchBox;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='nutella']")
    ////*[@class='suggestion-telPRb5gY5JtrMjuj62z' and text()='nutella']
    public MobileElement nutella;


    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Mini Nutella Kakaolu Fındık Kreması 25g']")
    public MobileElement product;


    @AndroidFindBy(id = "com.pozitron.hepsiburada:id/tvProductName")
    public MobileElement productName;


    @AndroidFindBy(xpath = "//android.widget.Toast")
    public MobileElement toast;

    @AndroidFindBy(xpath= "//android.widget.FrameLayout[@content-desc=\"Sepetim, 1 yeni bildirim\"]/android.widget.FrameLayout/android.widget.ImageView")
    public MobileElement gotocart;

    @AndroidFindBy(id = "com.pozitron.hepsiburada:id/cartWebView")
    public MobileElement cartview;

    @AndroidFindBy(xpath = "(//android.view.View[@content-desc=\"Mini Nutella Kakaolu Fındık Kreması 25g\"])[2]/android.widget.TextView")
    public MobileElement productAtTheBasket;


    @AndroidFindBy(id= "com.pozitron.hepsiburada:id/product_detail_add_to_cart_text" )
    public MobileElement addtocart;

    @AndroidFindBy(id= "continue_step_btn" )
    public MobileElement ok;


    @AndroidFindBy(id = "txtUserName")
    public MobileElement email;

    @AndroidFindBy(id= "btnLogin" )
    public MobileElement login;








}
