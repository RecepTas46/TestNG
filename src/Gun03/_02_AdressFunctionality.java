package Gun03;

import Utils.GenelWebDriver;
import Utils.Tools;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.util.List;
import java.util.concurrent.TimeUnit;

/*
       Senaryo;
       1- Siteyi açınız.
       2- Adress Ekleyiniz.
       3- En son eklenen adresi edit yaparak ad ve soyadı değiştirip kaydediniz.
       4- En son eklenen adresi siliniz.
     */
public class _02_AdressFunctionality extends GenelWebDriver {
    @Test()
    void AddAdress() {

        WebDriverWait bekle = new WebDriverWait(driver, 20);

        WebElement adressBook = driver.findElement(By.xpath("//a[text()='Address Book']"));
        adressBook.click();

        WebElement newAdress = driver.findElement(By.xpath("//a[text()='New Address']"));
        newAdress.click();

        WebElement firstName = driver.findElement(By.id("input-firstname"));
        firstName.sendKeys("Recep");

        WebElement lastName = driver.findElement(By.id("input-lastname"));
        lastName.sendKeys("T");

        WebElement inputComppany= driver.findElement(By.id("input-company"));
        inputComppany.sendKeys("Techno Study");

        WebElement adress1 = driver.findElement(By.id("input-address-1"));
        adress1.sendKeys("buchener str 24");

        WebElement inputAddress2= driver.findElement(By.id("input-address-2"));
        inputAddress2.sendKeys("Antalya kepez");

        WebElement city = driver.findElement(By.id("input-city"));
        city.sendKeys("Heilbronn");

        WebElement postCode = driver.findElement(By.id("input-postcode"));
        postCode.sendKeys("3465");

        WebElement country = driver.findElement(By.cssSelector("select[id='input-country'][name='country_id']"));
        Tools.selectByRandomIndex(country);

//        Select menu = new Select(country);
//        int random = (int) (Math.random() * menu.getOptions().size());
//        menu.selectByIndex(random); // random yapılacak sonra

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,300)");

        // visibilityOfElementLocated DOM da yer alması
        // presenceOfElementLocated DOM olacak hemde ekranda gözükecek

        WebElement zone = bekle.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("select[id='input-zone']")));

        // regionlar yüklendi mi? yüklenen kadra bekle
        // optionların miktarı 1 den fazla olana kadar bekle : yani : REGION yeniden dolana kadar bekle
         bekle.until(ExpectedConditions.numberOfElementsToBeLessThan(By.cssSelector("select[id='input-zone']>option"),108));
        //optionlarinsayisi 108 den kucuk olana kadar bekle : : yeni durum gelene kadar bekle


//bekle.until(ExpectedConditions.stalenessOf(driver.findElement(By.cssSelector("select[id='input-zone']>option"))));
        //bu da calisiyor ,bayat elaman olana kadar bekle :  ilk durum kaybolana bekle

        // regionlar yüklendikten sonra seçmeliyim
        WebElement regionSelectState = driver.findElement(By.id("input-zone"));
        Tools.selectByRandomIndex(regionSelectState);

        //todo: inceleme wait icin
//        Select select1 = new Select(regionSelectState);
//        select1.selectByIndex(5);
//        System.out.println("options:"+select1.getOptions().size());//inceleyip size ni bulmak lazim ..
//
//        for (WebElement ss : select1.getOptions())
//        {
//            System.out.println("ss listeyi yaz:"+ss.getText());
//        }
//


        WebElement contBtn = driver.findElement(By.cssSelector("input[value='Continue']"));
        contBtn.click();

        Tools.successMessageValidation(driver);

    }

    @Test(dependsOnMethods = {"AddAdress"})//bir onceki kod duzgun calisirsa ,bu da calissin
    void editAdress() {
        WebElement adressBook = driver.findElement(By.xpath("//a[text()='Address Book']"));
        adressBook.click();

        List<WebElement> editBtn = driver.findElements(By.xpath("//a[text()='Edit']"));
        WebElement edit=editBtn.get(editBtn.size()-1);
        edit.click();

        WebElement firstName = driver.findElement(By.id("input-firstname"));
        firstName.clear();
        firstName.sendKeys("Ramazan");

        WebElement lastName = driver.findElement(By.id("input-lastname"));
        lastName.clear();
        lastName.sendKeys("Guner");

        WebElement contBtn = driver.findElement(By.cssSelector("input[value='Continue']"));
        contBtn.click();

        Tools.successMessageValidation(driver);
    }

    @Test(dependsOnMethods = {"editAdress"})//bir onceki kod duzgun calisirsa ,bu da calissin
    void deleteAdress() {
        WebElement adressBook = driver.findElement(By.xpath("//a[text()='Address Book']"));
        adressBook.click();

        List<WebElement> delete = driver.findElements(By.xpath("//a[text()='Delete']"));
        WebElement sonElamaniSil=delete.get(delete.size()-1);
        sonElamaniSil.click();

        Tools.successMessageValidation(driver);
    }


}
