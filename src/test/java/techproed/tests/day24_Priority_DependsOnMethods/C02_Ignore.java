package techproed.tests.day24_Priority_DependsOnMethods;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Ignore;
import org.testng.annotations.Test;

import java.time.Duration;

public class C02_Ignore {

    /*
      Junitte test methodlarını istediğimiz şekilde sıralamak için method isimlerini alfabetik ve numerik sıralı
 olarak yazmamız gerekiyordu. TestNG frameworkunde bu sıralama için @Test notasyonundan sonra parametre olarak
 (priority = 1 ) gibi öncelik sırası belirterek test methodlarımızı sıralayabiliriz.
 Priority kullanmadığımız methodda priority değerini 0(sıfır) olarak kabul eder.
   */

/*
    Birden fazla test methodu calistirmak istedigimizde o anlik gereksiz gordugumuz test methodunu
    atlamak (ignore) isteyebiliriz.Bunun icin @Test notasyonu ustune ya da yanina @Ignore notasyonu
    eklememiz yeterlidir.@Ignore notasyonu ile atladığımız method konsolda gözükmez raporlamalarda gözükür

    Eger bir method tamamen iptal etmek isterseniz @Test notasyonundan sonra parametre olarak (enablefalse)
kullanabiliriz

     */

    WebDriver driver;
    @BeforeMethod
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }

    @Test
    public void amazonTest() {
        driver.get("https://amazon.com");
    }

    @Ignore
    @Test
    public void youtubeTest() {
        driver.get("https://youtube.com");
    }
    @Test(enabled = false) //bu methodu atlar gormezden gelir ve raporda da gostermez.
    public void facebookTest() {
        driver.get("https://facebook.com");
    }

    @AfterMethod
    public void tearDown() {
        driver.close();
    }
}
