package techproed.tests.day26_PagesKullanimi;

import org.testng.Assert;
import org.testng.annotations.Test;
import techproed.pages.OpenSourcePage;
import techproed.utilities.ConfigReader;
import techproed.utilities.Driver;
import techproed.utilities.ReusableMethods;

public class C01_PageKullanimi {


    @Test
    public void test01() throws InterruptedException {

        //https://opensource-demo.orangehrmlive.com/web/index.php/auth/login adrese gidelim
        //Driver.getDriver().get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
        Driver.getDriver().get(ConfigReader.getProperty("opensourceUrl"));
        ReusableMethods.wait(1);
        //kullaniciAdi, kullaniciSifre, submitButton elementlerini locate edelim

        /*
        Locateleri olusturdugumuz page class'indaki webelementlere ulasabilmek icin
        asagidaki ornekteki gibi classdaki const. dan obje olusturduk
         */

        OpenSourcePage sourcePage= new OpenSourcePage();
        sourcePage.username.sendKeys(ConfigReader.getProperty("username"));
        ReusableMethods.wait(1);
        sourcePage.password.sendKeys(ConfigReader.getProperty("password"));
        ReusableMethods.wait(3);
        sourcePage.loginButon.click();
        ReusableMethods.wait(3);

        //Login Testinin basarili oldugunu test et
        Assert.assertTrue(sourcePage.verify.isDisplayed());


    }
}
