package techproed.tests.day28_DataProvider;

import org.openqa.selenium.Keys;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import techproed.pages.GooglePage;
import techproed.utilities.ConfigReader;
import techproed.utilities.Driver;
import techproed.utilities.ReusableMethods;

public class C02_DataProviderTest {


    /*
    Google sayfasina gidip Dataprovider ile belirtilen arac isimlerini
    aratalim.
     */

    @DataProvider
    public static Object[][] arabalar() {
        return new Object[][]{{"ford"},
                {"volvo"},
                {"mercedes"},
                {"audi"}};
    }

    @Test(dataProvider = "arabalar")
    public void test01(String araclar) {
        //Google sayfasına gidelim
        GooglePage googlePage = new GooglePage();
        Driver.getDriver().get(ConfigReader.getProperty("googleUrl"));
        googlePage.cerez.click();
        //Dataprovider'daki verilerle arama yapalım
        googlePage.searchBox.sendKeys(araclar);
        googlePage.searchBox.submit();
        ReusableMethods.wait(3);
        //Her arama için sayfa resmi alalım
        ReusableMethods.tumSayfaResmi(araclar);
        //Sayfayı kapatalım
        Driver.closeDriver();

    }
}