package Gun07;

import Utils.GenelWebDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;


public class _03_PlaceOrderElements {
    // Bu sayfadaki bütün elemenalrın driverlar bağlantısı gerekiyor
    // bunun için aşağıdaki consructor eklendi ve için PageFatory ile
    // driver üzerinden bu (this) sayfadaki bütün elemnalar ilşkilendirildi.
    // Böylece Sayfada dan nesne türetildiği zaman değil, kullanıldığı
    // anda elemanların bulunması aktif oluyor.Bu yöntemle bütün sayfalarda
    // aynı isimde elemanlar var ise buradaki tanımlama hepsi için geçerli hale
    // gelmiş oluyor. buna yapıya Page Object Model (POM) adı veriliyor.
    public _03_PlaceOrderElements(WebDriver driver) {
        PageFactory.initElements(driver,this);
    }

    @FindBy(css = "input[class='form-control input-lg']")
    public WebElement textArea;

    @FindBy(css = "button[class='btn btn-default btn-lg']")
    public WebElement srchBtn;

    @FindBy(xpath = "//span[text()='Add to Cart']")
    public WebElement secim1Cart;

    @FindBy(css = "a[title='Shopping Cart']")
    public WebElement shoppingCart;

    @FindBy(xpath = "//a[text()='Checkout']")
    public WebElement checkout;

    @FindBy(id = "button-payment-address")
    public WebElement cont1;
    @FindBy(id = "button-shipping-address")
    public WebElement cont2;
    @FindBy(id = "button-shipping-method")
    public WebElement cont3;

    @FindBy(css = "input[type='checkbox']")
    public WebElement agree;
    @FindBy(id = "button-payment-method")
    public WebElement cont4;

    @FindBy(id = "button-confirm")
    public WebElement confirm;

    @FindBy(css = "div[id='content']>h1")
    public WebElement mesaj;


}
