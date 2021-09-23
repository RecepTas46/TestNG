package Gun01;

import org.testng.Assert;
import org.testng.annotations.Test;

public class _03_Assertions {
    // JUnit -> bu daha önce proje testlerimizde kullandığımız java nın kendi kütüphane testi
    //          paralel ve grup çalışmalarında yetersiz.

    // testNG-> bu Yeni nesil TEST -> test New Generation -> yani tesllerimizi kontrol edip
    //          istediğimiz gibi çalıştırabileceğimiz Selenium Kullanma TOOL u


    // Yeşil tik : test te hata yok.
    // Sarı çarpi: test te hata çıktı.
    // Beyaz     : test çalıştırılmadı.

    @Test
    void EqualOrnek() {
        String s1 = "Merhaba";
        String s2 = "Merhaba";

         Assert.assertEquals(s1,s2,"Yapilan islemin sonucu");//2 veriyi karsilastirir .
       // Assert.assertNotEquals(s1, s2, "yapilan islemin sonucu");
        //Actual:Olusan
        // Expected: Beklenen.
    }
    @Test
    void notOrnek()
    {
        int s1=23;
        int s2=24;
        Assert.assertNotEquals(s1,s2,"S1 ve S2 esit degildir ");
    }

    @Test
    void TrueOrnek() {
        int s1 = 55;
        int s2 = 55;

        Assert.assertTrue(s1 == s2);//2 veriyi karsilastirir .
        //Actual:Olusan
        // Expected: Beklenen.
    }

    @Test
    void NULLOrnek() {
        String s1 = null;
        String s2 = null;


        Assert.assertNull(s1);
        Assert.assertNull(s2);
        //Actual:Olusan
        // Expected: Beklenen.
    }

}
