package techproed.tests.day23_Annotation;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeGroups;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import java.time.Duration;

public class C02_BeforeGroupsAfterGroups {

    WebDriver driver;

    @BeforeSuite
    public void beforeSuite() {
        System.out.println("En basta beforeSuir calisir.");
    }

    @BeforeGroups("gp1")
    public void beforeGroups(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

    }

    @Test(groups ={"gp1","gp2"})
    public void test01() throws InterruptedException {
        driver.get("https://amazon.com");
        Thread.sleep(10);

    }

    @Test(groups = "gp1")
    public void test02() {
        driver.get("https://youtube.com");
    }
/*
//groups yapmasakta calisir cunku webdriver acildigi icin calismaya devam ediyor
//fakat usttekinde cloes ile kapatsaydik bu sefer calismiyacaskti.
    @Test
    public void test03() {
        driver.get("https://facebook.com");
    }

 */

    @Test(groups = "gp2")
    public void test04() {
        driver.get("https://facebook.com");
    }
}
