package Gun08;

import Utils.GenelWebDriver;
import Utils.ParameterDriver;
import Utils.Tools;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.util.List;

/*
    Senaryo ;
    1- Siteye gidiniz..

   1.Test;
   2- "ipod" ürününü aratınız.parameters ile yapiniz
   3- çıkan elamnlardan random bir elelamnı Add Wish butonuna tıklayınız.
   4- Daha sonra WishList e tıklatınız
   5- Burada çıkan ürünle tıklanan ürünün isminin aynı olup olmadığını doğrulayınız.

   2.Test;
   1- WishList i boşaltınız.
 */

public class _01_WishList extends ParameterDriver {

    @Test
    @Parameters("itemName")
    void addToWishLis(String arananKelime) {
        WebElement textArea = driver.findElement(By.cssSelector("input[class='form-control input-lg']"));
        textArea.sendKeys(arananKelime);

        WebElement srchBtn = driver.findElement(By.cssSelector("button[class='btn btn-default btn-lg']"));
        srchBtn.click();
        //arama sonucu ekrana cikan urunlerin listesini aldim
        List<WebElement> secimUrunRandom = driver.findElements(By.cssSelector("div[class='caption']>h4>a"));
        int randomNumber = Tools.RandomNumberGenarator(secimUrunRandom.size());//random bir numara olusturduk
        String wishListItenName = secimUrunRandom.get(randomNumber).getText();//olusan bu numaradaki urunun adini aldim

        List<WebElement> wishListBtn = driver.findElements(By.cssSelector("button[data-original-title='Add to Wish List']"));
        wishListBtn.get(randomNumber).click();//cikan bu listedeki wishListlerin ayni random numaradakini tiklattim
        //boylece wish liste ekledim .

        //cikan wish liste tiklattim
        WebElement wishlistBtn = driver.findElement(By.id("wishlist-total"));
        wishlistBtn.click();

        //cikan wish listi aldim
        List<WebElement> tableNames = driver.findElements(By.cssSelector("table[class='table table-bordered table-hover']>tbody>tr>td:nth-child(2)"));

        //bu listedeki urunlerin isimleri ile daha once ekledigim urunun ismi varmi diye baktim,karsilastirdim
        Tools.LisContainsString(tableNames,wishListItenName);

    }
}
