package techproed.tests.day24_Priority_DependsOnMethods;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.time.Duration;

public class C06_SoftAssert {

    /*
        SoftAssert kullanımında junitteki daha önce kullanıdığımız methodların aynısını kullanırız.
    Daha önceden kullandığımız assertion nerde hata alırsa orda testlerin çalışmasını durdurur.
    SoftAssert'te ne kadar assertion kullansakta nerde assertAll() methodu kullanırsak testlerimiz de
    kullandığımız assertionlar orda sonlanır ve hata varsa bunu bize konsolda belirtir
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
    public void test01() {
        //Amazon sayfasına gidelim
        driver.get("https://amazon.com");

        //Url'in https://www.amazon.com.tr olup olmadığını doğrulayınız
        SoftAssert softAssert = new SoftAssert();//-->SoftAssert kullanabilmek için SoftAssert class'ından obje oluşturmalıyız
        softAssert.assertEquals(driver.getCurrentUrl(),"https://www.amazon.com.tr");//-->bilerek hata alıcaz

        //Başlığın best içerdiğini test edelim
        softAssert.assertTrue(driver.getTitle().contains("best"));//-->Bilerek hata alıcaz

        //Arama kutusunda iphone aratalım
        driver.findElement(By.id("twotabsearchtextbox")).sendKeys("iphone", Keys.ENTER);

        //Sonucun samsung içerip içermediğini test edin
        WebElement sonucYazisi = driver.findElement(By.xpath("(//*[@class='sg-col-inner'])[1]"));
        softAssert.assertTrue(sonucYazisi.getText().contains("samsung"));//-->Bilerek hata alıcaz
        softAssert.assertAll();
        System.out.println("Burası çalışmaz");
    }

    @Test
    public void test02() {
        //Amazon sayfasına gidelim
        driver.get("https://amazon.com");

        //Url'in https://www.amazon.com.tr olup olmadığını doğrulayınız
        SoftAssert softAssert = new SoftAssert();//-->SoftAssert kullanabilmek için SoftAssert class'ından obje oluşturmalıyız
        softAssert.assertEquals(driver.getCurrentUrl(),"https://www.amazon.com.tr");//-->bilerek hata alıcaz

        //Başlığın best içerdiğini test edelim
        softAssert.assertTrue(driver.getTitle().contains("best"));//-->Bilerek hata alıcaz

        //Arama kutusunda iphone aratalım
        driver.findElement(By.id("twotabsearchtextbox")).sendKeys("iphone", Keys.ENTER);

        //Sonucun samsung içerip içermediğini test edin
        WebElement sonucYazisi = driver.findElement(By.xpath("(//*[@class='sg-col-inner'])[1]"));
        softAssert.assertTrue(sonucYazisi.getText().contains("samsung"));//-->Bilerek hata alıcaz
        System.out.println("Burası çalıştı");
        softAssert.assertAll();
    }

    @Test
    public void test03() {
        //Amazon sayfasına gidelim
        driver.get("https://amazon.com");

        //Url'in https://www.amazon.com.tr olup olmadığını doğrulayınız
        SoftAssert softAssert = new SoftAssert();//-->SoftAssert kullanabilmek için SoftAssert class'ından obje oluşturmalıyız
        softAssert.assertNotEquals(driver.getCurrentUrl(),"https://www.amazon.com.tr");

        //Başlığın best içerdiğini test edelim
        softAssert.assertFalse(driver.getTitle().contains("best"));

        //Arama kutusunda iphone aratalım
        driver.findElement(By.id("twotabsearchtextbox")).sendKeys("iphone", Keys.ENTER);

        //Sonucun samsung içerip içermediğini test edin
        WebElement sonucYazisi = driver.findElement(By.xpath("(//*[@class='sg-col-inner'])[1]"));
        softAssert.assertFalse(sonucYazisi.getText().contains("samsung"));
        softAssert.assertAll();
        System.out.println("Burası çalıştı");

    }
}
