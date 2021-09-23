package Gun01;

import Utils.GenelWebDriver;
import org.testng.annotations.Test;


public class _04_Enable extends GenelWebDriver {

    @Test
    void test1() {
        System.out.println(driver.getCurrentUrl());//sayfa url(WEB) adresi
    }

    @Test(enabled = false)
//enabled = false--->>calismasini istemedigimiz bolumlerde kullanilir
    void test2() {
        System.out.println(driver.getTitle());//sayfanin basligi
    }

    @Test
    void test3() {
        System.out.println(driver.getWindowHandle());//sayfanin ID si alindi
    }


}
