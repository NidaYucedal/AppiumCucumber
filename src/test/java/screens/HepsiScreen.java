package screens;


import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;


public class HepsiScreen {

    public HepsiScreen() {
        PageFactory.initElements(new AppiumFieldDecorator(Driver.getAppiumDriver()), this);
    }


    @AndroidFindBy(id = "com.pozitron.hepsiburada:id/image_message_of_day")
    public MobileElement home;

    @AndroidFindBy(id = "com.pozitron.hepsiburada:id/homeComponents")
    public MobileElement space;

    @AndroidFindBy(id = "com.pozitron.hepsiburada:id/etSearchBox")
    public MobileElement searchBox;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='nutella']")
    public MobileElement nutella;


    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Mini Nutella Kakaolu Fındık Kreması 25g']")
    public MobileElement product;


    @AndroidFindBy(id = "com.pozitron.hepsiburada:id/tvProductName")
    public MobileElement productName;

    @AndroidFindBy(id = "com.pozitron.hepsiburada:id/product_detail_add_to_cart_text")
    public MobileElement addtocart;

    @AndroidFindBy(xpath = "//android.widget.Toast")
    public MobileElement toast;

    @AndroidFindBy(id = "com.pozitron.hepsiburada:id/goBasketTxt")
    public MobileElement gotocart;

    @AndroidFindBy(id = "com.pozitron.hepsiburada:id/cartWebView")
    public MobileElement cartview;

    @AndroidFindBy(xpath = "(//android.view.View[@content-desc=\"Nutella Fındık ve Kakao Kreması 400 gr\"])[2]/android.widget.TextView")
    public MobileElement productAtTheBasket;


    @AndroidFindBy(xpath = "//android.widget.Button[@text='Alı\u015Fveri\u015Fi tamamla']")
    //android.widget.Button[@text='Alışverişi tamamla']







    public MobileElement completeShopping;


    @AndroidFindBy(xpath = "//*[@resource-id='txtUserName']")
    public MobileElement email;

    @AndroidFindBy(xpath = "//*[@resource-id='btnLogin']")
    public MobileElement login;


    @AndroidFindBy(xpath = "//*[@resource-id='txtPassword']")
    public MobileElement password;

    @AndroidFindBy(xpath = "//*[@resource-id='btnEmailSelect']")
    public MobileElement passwordPageLogin;

    @AndroidFindBy(xpath = "//android.widget.FrameLayout[@content-desc=\"Anasayfam\"]/android.widget.FrameLayout/android.widget.ImageView")
    public MobileElement homePage;

    @AndroidFindBy(id = "com.pozitron.hepsiburada:id/iv_toolbar_user_account_menu")
    public MobileElement profile;

    @AndroidFindBy(id = "com.pozitron.hepsiburada:id/tvUserNameFull")
    public MobileElement userName;

}
