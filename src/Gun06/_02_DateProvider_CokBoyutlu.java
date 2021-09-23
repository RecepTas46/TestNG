package Gun06;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class _02_DateProvider_CokBoyutlu {
    @Test(dataProvider = "getData")
    void UserNameTest(String username, String password) {
        System.out.println( username+" "+password);
    }

@DataProvider//bu methoda data provider(veri saglayici) gorevi verildi
public Object[][]getData(){
    Object[][]data={
            {"mehmet","123456"} ,
            {"ahmet","12345"},
            {"tuba","1234"},
            {"esra","12345678"},
            {"zehra","1234567"}
    };
    return data;
}
}
