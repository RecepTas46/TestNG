package Utils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import java.util.List;
import java.util.Random;

public class Tools {

    public static void compareToList(List<String> menuExpectedList, List<WebElement> menuActualList) {
        //1.yontem
        for (int i = 0; i < menuActualList.size(); i++) {
            Assert.assertEquals(menuExpectedList.get(i), menuActualList.get(i).getText());
        }
        //2.yontem
        int i = 0;//sirali gitmesi icin
        for (WebElement listItem : menuActualList) {//foreach li yazim
            Assert.assertEquals(menuExpectedList.get(i++), listItem.getText());
        }

    }

    public static void successMessageValidation(WebDriver driver) {
        WebElement msj = driver.findElement(By.cssSelector("div[class='alert alert-success alert-dismissible']"));
        Assert.assertTrue(msj.getText().contains("successfully"));

    }

    public static void Bekle(int saniye) {
        try {
            Thread.sleep(saniye * 1000);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void selectByRandomIndex(WebElement element) {
        Select select = new Select(element);
        select.selectByIndex(RandomNumberGenarator(select.getOptions().size()));

    }

    public static int RandomNumberGenarator(int max) {
        return (int) (Math.random() * max) + 1;
        //-->>10-->0   1 2 3...9
        //-->>10-->+1  1 2 3...10


    }

    public static void LisContainsString(List<WebElement> list, String arananKelime) {
        boolean bulundu = false;
        for (WebElement e : list) {
            if (e.getText().equalsIgnoreCase(arananKelime)) {
                bulundu = true;
                break;
            }
        }
        if (!bulundu)
            Assert.fail();

    }

}
