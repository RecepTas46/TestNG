package Gun06;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class _03_DateProvider_Iterator {

    @Test(dataProvider = "getData")
    void UserNameTest(String username) {
        System.out.println("username = " + username);

    }

    @DataProvider
    public Iterator<Object> getData() {

        List<Object> data = new ArrayList<>();
        data.add("ayse");
        data.add("hakan");
        data.add("esra");
        data.add("ersin");
        data.add("recep");

        return data.iterator();
    }
    /***********************************************************/

    @Test(dataProvider = "getData2")
    void UserNameTest2(String username ,String password) {
        System.out.println( username+" "+password);

    }

    @DataProvider
    public Iterator<Object[]> getData2() {

        List<Object[]> data = new ArrayList<>();
        data.add(new Object[]{"ayse","123"});
        data.add(new Object[]{"hakan","234dgd"});
        data.add(new Object[]{"esra","fsfgs324"});
        data.add(new Object[]{"ersin","34353fdsg"});
        data.add(new Object[]{"recep","ftr453"});

        return data.iterator();
    }


}
