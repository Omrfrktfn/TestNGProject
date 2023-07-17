package techproed.tests.day25_POM;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.Test;
import techproed.utilities.ConfigReader;
import techproed.utilities.Driver;

import java.security.Key;

public class C03_PropertiesKullanimi {

    @Test
    public void test01() throws InterruptedException {
        //amazon sayfasına gidelim
        Driver.getDriver().get(ConfigReader.getProperty("amazonUrl"));

//basligin Amazon içerdiğini test edelim
        String actualTitle = Driver.getDriver().getTitle();
        String expectedTitle = ConfigReader.getProperty("expectedTittle");
        Assert.assertTrue(actualTitle.contains(expectedTitle));

//arama kutusunda iphone aratalım
        Driver.getDriver().findElement(By.id("twotabsearchtextbox")).sendKeys(ConfigReader.getProperty("searchBox"), Keys.ENTER);

        Thread.sleep(2000);
        Driver.closeDriver();
    }


    @Test
    public void test02() {

        String amazonUrl= ConfigReader.getProperty("amazonUrl");
        String expectedTittle= ConfigReader.getProperty("expectedTittle");
        String searchBox= ConfigReader.getProperty("searchBox");
        System.out.println(amazonUrl);
        System.out.println(expectedTittle);
        System.out.println(searchBox);

    }
}
