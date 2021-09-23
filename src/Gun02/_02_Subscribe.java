package Gun02;

import Utils.GenelWebDriver;
import Utils.Tools;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

/*
  Senaryo
  1- Siteyi açınız.
  2- Newsletter  Subscribe ve UnSubscribe işlemlerini ayrı ayı testlerde yapınız.
  3- Newsletter  üyelik işlemini, üye ise , üyelikten çıkma, değilse ekleme şeklinde yapınız
 */
public class _02_Subscribe extends GenelWebDriver {
By link=By.linkText("Newsletter");
By yes=By.cssSelector("input[value='1']");
By cntniu=By.cssSelector("input[value='Continue']");
By no=By.cssSelector("input[value='0']");

    @Test(priority = 1)
    void SubscribeFunktionYes() {
        WebElement Newsletter = driver.findElement(link);
        Newsletter.click();

        WebElement SubscribeYes = driver.findElement(yes);
        SubscribeYes.click();

        WebElement countiniu = driver.findElement(cntniu);
       countiniu.click();

        Tools.successMessageValidation(driver);
//method a aldik(Tools)
//WebElement msj=driver.findElement(By.cssSelector("div[class='alert alert-success alert-dismissible']"));
//        Assert.assertTrue(msj.getText().contains("successfully "));

    }

    @Test(priority = 2)
    void SubscribeFunktionNo() {

        WebElement Newsletter = driver.findElement(link);
        Newsletter.click();


        WebElement SubscribeNo = driver.findElement(no);
        SubscribeNo.click();

        WebElement countiniu = driver.findElement(cntniu);
        countiniu.click();

        Tools.successMessageValidation(driver);
    }

    @Test(priority = 3)
    void SubscribeFunktionForBoth() {

        WebElement Newsletter = driver.findElement(link);
        Newsletter.click();

        WebElement SubscribeYes = driver.findElement(yes);
        WebElement SubscribeNo = driver.findElement(no);

        if (SubscribeYes.isSelected()){
            SubscribeNo.click();
        }else SubscribeYes.click();

        WebElement countiniu = driver.findElement(cntniu);
        countiniu.click();

        Tools.successMessageValidation(driver);
    }


}
