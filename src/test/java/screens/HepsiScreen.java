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


    @AndroidFindBy(id = "com.pozitron.hepsiburada:id/etSearchBox")
    public MobileElement searchBox;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='nutella']")
    ////*[@class='suggestion-telPRb5gY5JtrMjuj62z' and text()='nutella']
    public MobileElement nutella;


    @AndroidFindBy(xpath = "(//android.widget.Button[@content-desc=\"Sepete Ekle\"])[4]")
    public MobileElement product;


    @AndroidFindBy(xpath = "(//android.widget.Button[@content-desc=\"Sepete Ekle\"])[1]")
    public MobileElement addcart;


    @AndroidFindBy(xpath = "//android.widget.Toast")
    public MobileElement toast;

    @AndroidFindBy(xpath = "//android.widget.FrameLayout[@content-desc=\"Sepetim, 1 yeni bildirim\"]/android.widget.FrameLayout/android.widget.ImageView")
    public MobileElement gotocart;

    @AndroidFindBy(id = "com.pozitron.hepsiburada:id/cartWebView")
    public MobileElement cartview;

    @AndroidFindBy(xpath = "//btnLogin[@text='Giriş yap']")
    public MobileElement giris;


    @AndroidFindBy(id= "com.pozitron.hepsiburada:id/product_detail_add_to_cart_text" )
    public MobileElement addtocart;

    @AndroidFindBy(id= "com.pozitron.hepsiburada:id/goBasketTxt" )
    public MobileElement gotoBasket;



    @AndroidFindBy(id= "btnLogin" )
    public MobileElement login;








}
