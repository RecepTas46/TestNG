package Gun02;

import Utils.GenelWebDriver;
import Utils.Tools;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

/*
      1- Siteyi açınız.
      2- Edit Account a tıklatınız.
      3- Yeni isim ve soyisim göndererek Continue yapınız.
      4- İşlem sonucunu kontrol ediniz.
      5- Bu işlemi 2 kez çalıştırarak eski haline getiriniz.
     */
public class _03_editAccount extends GenelWebDriver {


    @Test
    void EditAccount() {
        editAccount("Recep", "Tas");
        Tools.Bekle(2);
        editAccount("ali", "veli");
    }

    void editAccount(String ad, String soyad) {
        WebElement edit = driver.findElement(By.linkText("Edit Account"));
        edit.click();

        WebElement firsName = driver.findElement(By.id("input-firstname"));
        firsName.clear();
        firsName.sendKeys(ad);

        WebElement lastName = driver.findElement(By.id("input-lastname"));
        lastName.clear();
        lastName.sendKeys(soyad);

        WebElement continueBtn = driver.findElement(By.cssSelector("input[value='Continue']"));
        continueBtn.click();

        Tools.successMessageValidation(driver);

    }

}
