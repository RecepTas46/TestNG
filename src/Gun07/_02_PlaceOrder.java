package Gun07;

import Utils.GenelWebDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

/*
    Senaryo :
    1- Siteyi açınız.
    2- Sitede "ipod" kelimesini aratınız
    3- Çıkan sonuçlardan ilkini sepete atınız.
    4- Shopping Chart a tıklatınız.
    5- Checkout yapınız.
    6- Continue butonalarına tıklatıp bilgileri giriniz.
    7- En confirm ile siparişi verdiğinizi doğrulayınız.
       doğrulamayı çıkan sayfadaki "Your order has been placed" yazısı ile yapınız.
 */
public class _02_PlaceOrder extends GenelWebDriver {

    @Test
    void ProceedToCheckout() {

        WebElement textArea = driver.findElement(By.cssSelector("input[class='form-control input-lg']"));
        textArea.sendKeys("ipod");

        WebElement srchBtn = driver.findElement(By.cssSelector("button[class='btn btn-default btn-lg']"));
        srchBtn.click();
        WebElement secim1Cart = driver.findElement(By.xpath("//span[text()='Add to Cart']"));
        secim1Cart.click();
        WebElement shoppingCart = driver.findElement(By.cssSelector("a[title='Shopping Cart']"));
        shoppingCart.click();

        WebElement checkout = driver.findElement(By.xpath("//a[text()='Checkout']"));
        checkout.click();

        WebDriverWait wait=new WebDriverWait(driver,10);

        WebElement cont1 = wait.until(ExpectedConditions.elementToBeClickable(By.id("button-payment-address")));
        cont1.click();
        WebElement cont2= wait.until(ExpectedConditions.elementToBeClickable(By.id("button-shipping-address")));
        cont2.click();
        WebElement cont3= wait.until(ExpectedConditions.elementToBeClickable(By.id("button-shipping-method")));
        cont3.click();

        WebElement agree=driver.findElement(By.cssSelector("input[type='checkbox']"));
        agree.click();

        WebElement cont4= wait.until(ExpectedConditions.elementToBeClickable(By.id("button-payment-method")));
        cont4.click();

        WebElement confirm=driver.findElement(By.id("button-confirm"));
        confirm.click();
        wait.until(ExpectedConditions.urlContains("success"));

        WebElement mesaj=driver.findElement(By.cssSelector("div[id='content']>h1"));
        Assert.assertEquals(mesaj.getText(),"Your order has been placed!");

    }


}
