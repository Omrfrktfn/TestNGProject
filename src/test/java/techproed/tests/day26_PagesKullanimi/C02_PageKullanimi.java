package techproed.tests.day26_PagesKullanimi;

import org.testng.Assert;
import org.testng.annotations.Test;
import techproed.pages.OpenSourcePageClass;
import techproed.utilities.ConfigReader;
import techproed.utilities.Driver;
import techproed.utilities.ReusableMethods;

public class C02_PageKullanimi {

    @Test
    public void test01() {
        //https://opensource-demo.orangehrmlive.com/web/index.php/auth/login adrese gidelim
        Driver.getDriver().get(ConfigReader.getProperty("opensourceUrl"));
        ReusableMethods.wait(1);


        OpenSourcePageClass.userName().sendKeys(ConfigReader.getProperty("username"));
        ReusableMethods.wait(1);
        OpenSourcePageClass.password().sendKeys(ConfigReader.getProperty("password"));
        ReusableMethods.wait(1);
        OpenSourcePageClass.loginButton().click();

        Assert.assertTrue(OpenSourcePageClass.verify().isDisplayed());

        Driver.closeDriver();



    }
}
