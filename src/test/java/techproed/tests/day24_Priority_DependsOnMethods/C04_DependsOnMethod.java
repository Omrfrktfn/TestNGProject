package techproed.tests.day24_Priority_DependsOnMethods;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class C04_DependsOnMethod {

    WebDriver driver ;

    @AfterMethod
    public void tearDown() {
      //  driver.close();
    }

    @BeforeClass
    public void setUP() {
        //Bu methodda driver ayarlarini yapalim

        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }



    @Test
    public void test01() {
        driver.get("http://amazon.com");
    }

    @Test(dependsOnMethods = "test01")
    public void test02() {

        driver.findElement(By.id("twotabsearchtextbox")).sendKeys("iphone", Keys.ENTER);
    }


    @Test
    public void test03() {
        System.out.println("Test03");
    }

    @Test(dependsOnMethods = "test03")
    public void test04() {
        System.out.println("Test04");
    }

    //dependsOnMethods parametresini ust uste kullanirsak "No tests were found" (TestNGException atar )hatasi verir
    @Test(dependsOnMethods = "test04")
    public void test05() {
        System.out.println("Test05");
    }
}