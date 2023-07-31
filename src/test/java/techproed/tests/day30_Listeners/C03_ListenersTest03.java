package techproed.tests.day30_Listeners;

import org.openqa.selenium.By;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import techproed.utilities.ConfigReader;
import techproed.utilities.Driver;


@Listeners(techproed.utilities.Listeners.class)
public class C03_ListenersTest03 {

    /*
    Eger testimizin basarisiz olmasi durumunda tekrar calismasini istersek @Test notasyonundan
    sonra retryAnalyzer parametresi ile listeners class'inin yolunu belirtiriz.
    Bununla birlikte ItestiListeners arayuzundeki methodlarida kullanabilmek icin yine class'dan once
    @Listeners notasyonu kullaniriz.
     */
    @Test(retryAnalyzer = techproed.utilities.Listeners.class)
    public void amazonTest() {

            Driver.getDriver().get(ConfigReader.getProperty("amazonUrl"));
            Driver.getDriver().findElement(By.id("fajflksafjlsakj")).click();

    }
}
