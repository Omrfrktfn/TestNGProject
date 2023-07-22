package techproed.tests.day28_DataProvider;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class C06_DataProviderTest {


    @DataProvider
    public static Object[][] veriler() {
        return new Object[][]{{"omer"},
                {"hamit"},
                {"tuba"},
                {"zulfiye"},
                {"fatma"},
                {"tamer"},
                {"emin"},
                {"ahsen"}};
    }

    @Test(dataProvider = "veriler")
    public void test01(String data) {
        System.out.println(data);
    }

    @Test(dataProvider = "veriler")
    public void test02(String isim) {
        System.out.println(isim);
    }

    @Test(dataProvider = "veriler")
    public void test03(String name) {
        System.out.println(name);
    }

    @Test(dataProvider = "veriler")
    public void test04(String ad) {
        System.out.println(ad);
    }


}
