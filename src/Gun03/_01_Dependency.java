package Gun03;

import org.testng.Assert;
import org.testng.annotations.Test;
/*
      interviewlarda sorulan bir konu imis, test ederken nasil önceligin olmalidir seklinde.. depency,priority vs
      dependsOnMethods ve priority ile sağlarım, aksi hale alfabetik sıra ile çalışır.
      todo:-->dependsOnMethods : bununla kendinden önce hangi metod çalışması gerekiyor ise onu belirtirim.
     todo:--> priority : bununla çalışma sırasını belirtirim.

      *** Metoddan run yapıldığında bağımlılık seviyesi 1 ise bağımlı olduğu metoduna çağırarak çalışır.
          fakat 2 adımlım bir bağımlılık var ise yani 2 metoda bağımlı ise geriye doğru , direk run yapılamaz.
     */
public class _01_Dependency {
    @Test
    void startCar() {
        System.out.println("Car startCar");
      //  Assert.fail();//burda direk hata olusturduk
    }

    //dependsOnMethods----->>>bu onceki metoda baglamayi sagliyor..
    @Test(dependsOnMethods = {"startCar"})
//onceki metodun calismasi halinde bu calisacak,onceki method da hata varsa calismayacak, methodlari bagladik
    void driverCar() {
        System.out.println("Car driverCar");//Bagimlilik tek ise method calisir..birden fazla ise calismaz
    }

    @Test(dependsOnMethods = {"driverCar"})
    void stopCar() {
        System.out.println("Car stopCar");
    }

    @Test(dependsOnMethods = {"stopCar"}, alwaysRun = true)
//bagimli olsa bile alwaysRun=true sayesinde , onceki methodlarda hata olsada calisacak.
    void parkCar() {
        System.out.println("Car parkCar");

    }
}
