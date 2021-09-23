package Gun08;

import Utils.ParameterDriver;
import Utils.Tools;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.util.List;


public class _02_WishListElements {
public _02_WishListElements(WebDriver driver){
    PageFactory.initElements(driver,this);
}

    @FindBy(css = "div[class='caption']>h4>a")
    List<WebElement> secimUrunRandom;

    @FindBy(css = "button[data-original-title='Add to Wish List']")
    List<WebElement> wishListBtn;
    @FindBy(id = "wishlist-total")
    WebElement wishlistBtn;
    @FindBy(css = "table[class='table table-bordered table-hover']>tbody>tr>td:nth-child(2)")
    List<WebElement> tableNames;

}
