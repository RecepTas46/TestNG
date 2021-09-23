package Gun06;

import Utils.GenelWebDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

/*
   Senaryo
   1- Siteye gidiniz
   2- Specials tiklayiniz
   3- Cikan urun sayisi ile indirimli urun sayisi ayni mi dogrulayiniz
   4- Yukarıdaki işlemden sonra her ürünün önceki fiyatının şu andaki fiyattan yüksek olduğunu doğrulayınız.
*/
public class _5_Task_2 extends GenelWebDriver {

    @Test
    void special()
    {
        WebElement specialBtn=driver.findElement(By.cssSelector("a[href='http://opencart.abstracta.us:80/index.php?route=product/special']"));
        specialBtn.click();
       List<WebElement>  oldPriceList=driver.findElements(By.className("price-old"));//eski fiyatlar
       List<WebElement> productList=driver.findElements(By.className("product-thumb"));//urun isimleri

        Assert.assertEquals(oldPriceList.size(),productList.size());

        /*** Eksi fiyat yeni fiyat karşılaştırması *****/
        List<WebElement>newPriceList=driver.findElements(By.cssSelector("span[class='price-new']"));//yeni fiyatlar

        for (int i = 0; i <newPriceList.size() ; i++) {
            Assert.assertTrue(cevir(newPriceList.get(i))<cevir(oldPriceList.get(i)));
        }

    }
    public double cevir(WebElement element){
        String result=element.getText();
        result=result.replaceAll("[^\\d]","");
        return Double.parseDouble(result);
    }
}
