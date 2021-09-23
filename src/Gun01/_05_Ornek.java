package Gun01;

import Utils.GenelWebDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

/*
     Senaryo ;
       1- http://opencart.abstracta.us/index.php?route=account/login  sitesini açınız.
       2- asd@gmail.com  ve 123qweasd   bilgileri ile login olan test metodunu yazınız.
       3- Login olup olmadığınızı assert ile kontrol ediniz.
       4- bir utils paketi açınız ve buraya beforeClass ve afterClass metdolarını yazarak
          genel kullanım için GenelWebDriver isimli test klasını tanımlayınız.
   */
public class _05_Ornek extends GenelWebDriver {


    @Test
    public  static void LoginTest() {
        WebElement email = driver.findElement(By.id("input-email"));
        email.sendKeys("asd@gmail.com");
        WebElement password = driver.findElement(By.id("input-password"));
        password.sendKeys("123qweasd");

        WebElement loginBtn = driver.findElement(By.cssSelector("input[class='btn btn-primary']"));
        loginBtn.click();
        WebElement adventec = driver.findElement(By.id("details-button"));
        adventec.click();
        WebElement adventecLink = driver.findElement(By.id("proceed-link"));
        adventecLink.click();

    }

}
