package techproed.tests.day25_POM;

import org.testng.annotations.Test;
import techproed.utilities.Driver;

public class C01_DriverTest {

    @Test
    public void test01() throws InterruptedException {

        Driver.getDriver().get("https://amazon.com");
        Thread.sleep(1000);
        Driver.getDriver().get("http://youtube.com");
        Thread.sleep(1000);
        Driver.getDriver().get("http://facebook.com");
        Thread.sleep(1000);
        Driver.quitDriver();

        /*
        Bu methodda driver'i if blogu icine almadigimizdan dolayi her sayfa icin yeni bir driver actiginin ornegini
        gosterdik.
         */

    }


    @Test
    public void test02() throws InterruptedException {
        Driver.getDriver().get("https://amazon.com");
        Thread.sleep(1000);
        Driver.getDriver().get("http://youtube.com");
        Thread.sleep(1000);
        Driver.closeDriver();
        Driver.getDriver().get("http://facebook.com");
        Thread.sleep(1000);
        Driver.quitDriver();

    }

    @Test
    public void test03() {

        //   Driver driver = new Driver();
        // driver.getDriver().get("http://amazon.com");

        /*
        Bu ornekte Driver class'inda singleton pattern kullanarak obje olusturmanin
         onune gecmis olduk
         */
    }
}
