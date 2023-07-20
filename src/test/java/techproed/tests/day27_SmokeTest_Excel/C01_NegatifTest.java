package techproed.tests.day27_SmokeTest_Excel;

import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.Test;
import techproed.pages.BlueRentalPage;
import techproed.utilities.ConfigReader;
import techproed.utilities.Driver;
import techproed.utilities.ReusableMethods;

public class C01_NegatifTest {


    @Test
    public void test01() {
        //Description:
//Kullanimda olmayan kullanıcı adi ve şifre ile giriş yapilamamali
//Acceptance Criteria
//Customer email: fake@bluerentalcars.com
//Customer password: fakepass
//Error:
//User with email fake@bluerentalcars.com not found


        Driver.getDriver().get(ConfigReader.getProperty("blueRentalUrl"));
        ReusableMethods.wait(1);

        BlueRentalPage blueRentalPage = new BlueRentalPage();
        blueRentalPage.login.click();
        ReusableMethods.wait(1);
        blueRentalPage.email.sendKeys(ConfigReader.getProperty("fakeEmail"), Keys.TAB,
                ConfigReader.getProperty("fakePassword"), Keys.ENTER);
        ReusableMethods.wait(1);
        Assert.assertTrue(blueRentalPage.wrongVerify.isDisplayed());
    }
}
