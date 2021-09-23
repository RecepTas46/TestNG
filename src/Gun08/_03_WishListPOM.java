package Gun08;

import Gun07._03_PlaceOrderElements;
import Utils.ParameterDriver;
import Utils.Tools;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.util.List;

public class _03_WishListPOM extends ParameterDriver {

    @Test
    @Parameters("itemName")
    void addToWishLis(String arananKelime) {
        Gun07._03_PlaceOrderElements poe=new _03_PlaceOrderElements(driver);
        poe.textArea.sendKeys(arananKelime);
        poe.srchBtn.click();

        Gun08._02_WishListElements wle=new _02_WishListElements(driver);

        int randomNumber = Tools.RandomNumberGenarator(wle.secimUrunRandom.size());
        String wishListItenName = wle.secimUrunRandom.get(randomNumber).getText();
        wle.wishListBtn.get(randomNumber).click();
        wle.wishlistBtn.click();

        Tools.LisContainsString(wle.tableNames,wishListItenName);

    }
    @Test//bu testi biz yaparak hata olusturduk,cunku hata raporunu gormek icin
    void test2(){
        Assert.fail();
    }
}
