package techproed.tests.day24_Priority_DependsOnMethods;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.security.Key;
import java.time.Duration;

public class C03_DependsOnMethods {

    /*
    Test methodlari birbirinden bagimsiz calisir. Methodlari birbirine bagimli calistirmak istersek DEPENDSONMETHODS
    para metresini @Test notasyonundan sonra baglamak istedigimiz test methodunun adini belirtiriz
 */

    WebDriver driver;

    @Test
    public void test01() {

        //Bu methodda driver ayarlarini yapalim

        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }

    @Test(priority = 1, dependsOnMethods = "test01")
    public void test02() {

        //Amazon sayfasina gidelim

        driver.get("https://amazon.com");
    }

    @Test(priority = 2, dependsOnMethods = "test02")
    public void test03() {

        //Arama kutusnda iphone aratalim
        driver.findElement(By.id("twotabsearchtextbox")).sendKeys("iphone", Keys.ENTER);
    }
}
