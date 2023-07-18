package techproed.tests.day26_PagesKullanimi;

import org.testng.Assert;
import org.testng.annotations.Test;
import techproed.pages.TechproPage;
import techproed.utilities.ConfigReader;
import techproed.utilities.Driver;
import techproed.utilities.ReusableMethods;

public class C03_PageKullanimi {

    @Test
    public void test01() {

        //https://testcenter.techproeducation.com/index.php?page=form-authentication
        Driver.getDriver().get(ConfigReader.getProperty("testCenterUrl"));
        ReusableMethods.wait(1);

        //Page object Model kullanarak sayfaya giriş yapildigini test edin

        TechproPage techproPage = new TechproPage();
        techproPage.username.sendKeys(ConfigReader.getProperty("techpro_test_username"));
        ReusableMethods.wait(1);
        techproPage.password.sendKeys(ConfigReader.getProperty("techpro_test_password"));
        ReusableMethods.wait(2);
        techproPage.submit.click();
        ReusableMethods.wait(2);
        Assert.assertTrue(techproPage.girisverify.isDisplayed());


        //Sayfadan cikis yap ve cikis yapildigini test et
        techproPage.logout.click();
        ReusableMethods.wait(2);
        Assert.assertTrue(techproPage.loginPageVeriyfy.isDisplayed());
        ReusableMethods.wait(2);


        //sayfayi kapatini
        Driver.closeDriver();
    }
}
