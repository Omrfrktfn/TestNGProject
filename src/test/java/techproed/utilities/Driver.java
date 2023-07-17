package techproed.utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class Driver {
    /*

POM(Page Object Model)
    Test senaryolarinin daha az kod ile yazilmasina ve bakiminin daha kolay yapilmasina
olanak saglayan yazilim test yontemidir. TestNG de ve Cucumber'da POM kalibini kullaniriz

 */

    private Driver(){
        /*
        Driver class'indan obje olusturmanin onune gecmek icin default constructor'i private yaparak
        bunun onune gecebiliriz.
        Bu uygulamay singleton patte denir.
         */
    }

    static WebDriver driver ;
    public static WebDriver getDriver(){

        /*
        driver'a deger atanmamissa degeri ata
        sonra da adrese git eger farki bir adrese gideceksen yeni bir driver uzerinden degilde ayni driver
        uzerinde farkli sekmede acmak icin
        Driver'i her cagirdigimizda yeni bir pencere acilmasinin onune gecmek icin if blogu icinde , eger driver'a
        deger atanmamissa deger ata, eger driver'a deger atanmissa driver'i ayni sayfada return et.
         */
        if (driver==null){

            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        }

        return driver;

    }

    public static void closeDriver() {

        if (driver != null) {//driver'a deger atanmissa
            driver.close();
            driver = null;//driver'i kapattiktan sonra bosalt
        }

    }

    public static void quitDriver() {

        if (driver != null) {//driver'a deger atanmissa
            driver.quit();
            driver = null;//driver'i kapattiktan sonra bosalt
        }

    }

}
