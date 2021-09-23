package Gun01;

import org.testng.annotations.*;

public class _02_Annotations {
   /*
     @BeforeClass -> // Her Classdan önce çalışacaklar buraya yazılıyor.
       @BeforeMethod -> //Her metod çalışmadan ONCE yapılacakları buraya yazıyoruz
           @Test -> // testimizin metodları
           @Test -> // testimizin metodları
       @AfterMethod  -> // Her metod çalıştıktan sonra yapılacakları buraya yazıyoruz.
     @AfterClass -> // Her class dan sonra yapılacaklar buraya yazılıyor.
   */
   @BeforeClass
   void beforeClass() {
       System.out.println("Her Clasdan ONCE calisacak:Befor Class");
   }
    @AfterClass
    void afterClass() {
        System.out.println("Her Clasdan SONRA calisacak:After Class");
    }

    @BeforeMethod
    void beforeMethod() {
        System.out.println("Her metotdan ONCE calisacak:Befor metod");
    }

    @AfterMethod
    void afterMethod() {
        System.out.println("Her metotdan SONRA calisacak:After metod");
    }

    @Test
    void test1() {
        System.out.println("Test 1 calisti");
    }

    @Test
    void test2() {
        System.out.println("Test 2 calisti");
    }

}
