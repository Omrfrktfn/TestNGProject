package techproed.tests.day24_Priority_DependsOnMethods;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class C01_Priority {
    /*
         Junitte test methodlarını istediğimiz şekilde sıralamak için method isimlerini alfabetik ve numerik sıralı
    olarak yazmamız gerekiyordu. TestNG frameworkunde bu sıralama için @Test notasyonundan sonra parametre olarak
    (priority = 1 ) gibi öncelik sırası belirterek test methodlarımızı sıralayabiliriz.
    Priority kullanmadığımız methodda priority değerini 0(sıfır) olarak kabul eder.
      */
    WebDriver driver;
    @BeforeMethod
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }

    @Test(priority = 1)
    public void amazonTest() {
        driver.get("https://amazon.com");//-->ikinci olarak amazon çalışsın
    }
    @Test
    public void youtubeTest() {
        driver.get("https://youtube.com");//-->youtube önce çalışsın--> Default 0 olduğu için önce bu method çalışır
    }
    @Test(priority = 2)
    public void facebookTest() {
        driver.get("https://facebook.com");//-->Son olarak facebook çalışsın
    }

    @AfterMethod
    public void tearDown() {
        driver.close();
    }

}
