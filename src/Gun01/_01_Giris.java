package Gun01;

import org.testng.annotations.Test;
// https://www.jetbrains.com/help/idea/testing.html
// org.testng:testng:6.14.3
//TestNG yukleme yaptigimiz site ve versiyonu....
//java kutuphanesinin oldugu yerden javanin altindaki mave secildi ve versiyon numarasi girildi bu kadar
public class _01_Giris {
//priority=1---->>>bu sekilde yaparsak ciktiyi istedigimiz sirada aliriz
        @Test(priority=1)//annotation deniyor
            void webSitesiniAc() {
                System.out.println("Driver tanimlandi ve wev sitesi acildi");
            }


        @Test(priority=2)
            void loginTest() {
            System.out.println("Login test islemleri yapildi");
            }


        @Test(priority=3)
            void driverKapat() {
            System.out.println("Driver kapatildi ve cikildi");

            }

}
