package techproed.tests.day28_DataProvider;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class C01_DataProviderTest {


    /*
    Dataprovider, bir çok veriyi test caselerde loop kullanmadan aktarmak için kullanılır.
TestNg'den gelen bir özelliktir. 2 boyutlu Object Array return eder.
Kullanımı için @Test notasyonundan sonra parametre olarak (dataprovider="method ismi") yazılır.
Kaç tane veri ile çalışacaksak test methoduna o kadar parametre eklenir.

     Dataprovider, bircok veriyi test caselerde loop kullanmadan aktarmak icin kullanilir.
    TestNG'den gelen bir ozelliktir. 2 boyutlu Object Array return eder.
    Kullanimi icin @Test notasyonundan sonra parametre olarak (dataprovider="method ismi") yazilir.
    Kac tane veri ile calisacaksak test methoduna o kadar parametre eklenir.
    Data driven testing(DDT) de datalarimizi 3 farkli sekilde kullanabiliriz.
        1-.properties dosyasindan datalari alabiliriz. -->ConfigReader.getProperty() ile
        2-Excel dosyasindan datalari alabiliriz.    -->ExcelReader class'i ile
        3-DataProvider kullanarak datalari alabiliriz.  -->DataProvider methodu ile
 */

    @DataProvider(name="test02")
    public static Object[][] isimler() {
        return new Object[][]{{"omer"},
                {"hamit"},
                {"tuba"},
                {"zulfiye"},
                {"fatma"},
                {"tamer"},
                {"emin"},
                {"ahsen"}};
    }

    @DataProvider
    public static Object[][] arbalar() {
        return new Object[][]{{"opel"},
                {"honda"},
                {"Audio"},
                {"BMW"},
                {"Tofas"},
                {"Clio"},
                {"ford"},
                {"mercedes"}};
    }

    /*
    Olusturdugumuz dataProvider methodunu baska bir test methodunda da kullanabiliriz
    Bunun icin @DataProvider notasyonundan sonra yeni olusturdugumuz methodun isminin
    (name="test02") olarak belirtmemiz gerekir.
 */

    @Test(dataProvider = "isimler")
    public void test01(String data) {

        System.out.println(data);

    }

    @Test(dataProvider ="test02" )
    public void test02(String isim) {

        System.out.println(isim);
    }

    @Test(dataProvider = "arbalar" )
    public void test03(String arabalar) {

        System.out.println(arabalar);
    }
}
