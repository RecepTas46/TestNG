package Gun05;

import Utils.GenelWebDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
/*
  1- ContactUs a tıklayınız
  2- Mesaj kutusuna en az 10 karakterlik bir mesaj yazınız.
  3- Submit ettikten sonra Contact US yazısını doğrulayınız.
 */
public class _02_contactUs extends GenelWebDriver {

    @Test
    @Parameters("mesaj")//XML den alacagi parametrenin adi buraya yazildi,name ismi ile ayni olmali
    void contactUs(String GelenMesaj){//paarametre alabilir hale geldi
        WebElement contactUs= driver.findElement(By.linkText("Contact Us"));
        contactUs.click();

        WebElement textArea= driver.findElement(By.id("input-enquiry"));
        textArea.sendKeys(GelenMesaj);

        WebElement submitBtn= driver.findElement(By.cssSelector("input[value='Submit']"));
        submitBtn.click();

        WebElement contactUsText= driver.findElement(By.cssSelector("div[id='content']>h1"));

        Assert.assertEquals("Contact Us",contactUsText.getText());
    }
}
