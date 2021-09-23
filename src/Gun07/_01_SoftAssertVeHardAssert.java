package Gun07;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class _01_SoftAssertVeHardAssert {




    @Test
    void hardAssert(){
        String s1="Merhaba";
        System.out.println("Hard assert oncesi");
        Assert.assertEquals("Merhaba 123",s1);//burda fail
        System.out.println("Hard assert sonrasi");//hardassert sonrrasi program kirildigi icn calismiyor
    }

    @Test
    void softAssert(){
        String strHomePage="www.facebook.com/homepage";
        String strCartPage="www.facebook.com/cartpage";
        String strEditAccount="www.facebook.com/editaccountpage";

        SoftAssert _softAssert=new SoftAssert();

        _softAssert.assertEquals("www.facebook.com/homepage",strHomePage);
        System.out.println("assert 1");

         _softAssert.assertEquals("www.facebook.com/profile",strCartPage);//fail(prifile yazarak hata olusturduk)
        System.out.println("assert 2");

         _softAssert.assertEquals("www.facebook.com/settings",strEditAccount);//burda tekrar fail
        System.out.println("assert 3");

        _softAssert.assertAll();//butun assertleri isleme koyuyor
        System.out.println("aktiflik sonrasi");// bu bölüm asserAll dan sonra olduğu için ve
                                               // assertlerinde fail olduğundan yukarıda program kesilir.
    }


}
