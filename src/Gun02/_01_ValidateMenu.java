package Gun02;

import Utils.GenelWebDriver;
import Utils.Tools;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

/*
        Senaryo;
        1- Siteyi açınız
        2- Top Menudeki menu elemanlarının olduğunu doğrulayınız.
     */
public class _01_ValidateMenu extends GenelWebDriver {



    @Test
    void menuValidation() {
        List<String> menuExpectedList = new ArrayList<>();
        menuExpectedList.add("Desktops");
        menuExpectedList.add("Laptops & Notbooks");
        menuExpectedList.add("Components");
        menuExpectedList.add("Tablets");
        menuExpectedList.add("Software");
        menuExpectedList.add("Phone & PDAs");
        menuExpectedList.add("Cameras");
        menuExpectedList.add("MP3 Players");

//        for (String lite:menuExpectedList) {
//
//            System.out.println(lite);
//        }

        By menuFind = By.cssSelector("a[class='nav navbahar-nav']>li");
        List<WebElement> menuActualList = driver.findElements(menuFind);

        Tools.compareToList(menuExpectedList,menuActualList);//burda assert ile listeyi karsilastirdik method da yazarak
    }


}
