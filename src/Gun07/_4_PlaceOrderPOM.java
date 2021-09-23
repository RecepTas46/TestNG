package Gun07;

import Utils.GenelWebDriver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

public class _4_PlaceOrderPOM extends GenelWebDriver {
  /* POM (Page Object Model) avantajları
   1- Bütün sayfalada isimleri aynı olan elemanlar için 1 tanımlama yeterli oluyor.
      Böylece tanımlanan elemanlar tekrar kullanılabilir yani Reusable oluyor.
   2- Kodun içerisinden HTML kodları ayrıldığından kod okunabilirliği artıyor.
   3- Developer locatorlarda bir değişiklik yaptığı zaman, asıl kodla hiç bir şekilde
      uğraşmak zorunda kalmıyoruz, sadece gidip locator ı değiştiriyoruz.
    */

    @Test
    void ProceedToCheckout() {

        _03_PlaceOrderElements elements = new _03_PlaceOrderElements(driver);
        elements.textArea.sendKeys("ipod");
        elements.srchBtn.click();
        elements.secim1Cart.click();
        elements.shoppingCart.click();
        elements.checkout.click();

        WebDriverWait wait = new WebDriverWait(driver, 10);

        wait.until(ExpectedConditions.elementToBeClickable(elements.cont1)).click();
        wait.until(ExpectedConditions.elementToBeClickable(elements.cont2)).click();
        wait.until(ExpectedConditions.elementToBeClickable(elements.cont3)).click();

//        wait.until(ExpectedConditions.elementToBeClickable(elements.agree)).click();
//        clickElementJs(elements.agree);
        elements.agree.click();

        wait.until(ExpectedConditions.elementToBeClickable(elements.cont4)).click();
        elements.confirm.click();
        wait.until(ExpectedConditions.urlContains("success"));
        Assert.assertEquals(elements.mesaj.getText(), "Your order has been placed!");


    }

}
