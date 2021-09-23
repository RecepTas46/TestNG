package Gun06;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.Objects;

public class _01_DateProvider {
    /**
     * Aşağıdaki ikli ile Dataproviderın içindeki bütün veriler tek tek test e gönderilerek
     * data sayısı kadar test çalıştırılı, dataların olduğu yere DataProvider annottion ı konur.
     * çalıştırılacak teste ise dataProvider = "getData"  bölümü eklenir.
     */
    @Test(dataProvider = "getData")
    void UserNameTest(String username) {
        System.out.println("username = " + username);

    }
@DataProvider//bu methoda data provider(veri saglayici) gorevi verildi
    public Object[] getData() {//data provider olarak kullanilan method tipi object olmali

        Object[] data = {"ayse", "hakan", "esra", "ersin", "recep"};

        return data;
    }
/***********************************/
    @Test(dataProvider = "userlar")
    void UserNameTest2(String username) {
        System.out.println("username = " + username);

    }
    @DataProvider(name="userlar")//bu methoda data provider(veri saglayici) gorevi verildi
    public Object[] getData2() {//data provider olarak kullanilan method tipi object olmali

        Object[] data = {"ayse2", "hakan2", "esra2", "ersin2", "recep2"};

        return data;
    }
}
