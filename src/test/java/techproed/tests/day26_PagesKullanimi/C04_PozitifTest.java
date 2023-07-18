package techproed.tests.day26_PagesKullanimi;

import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.Test;
import techproed.pages.BlueRentalPage;
import techproed.utilities.ConfigReader;
import techproed.utilities.Driver;
import techproed.utilities.ReusableMethods;

public class C04_PozitifTest {

    @Test
    public void test01() {

      // Acceptance Criteria:
      // Admin olarak, uygulamaya giriş yapabilmeliyim
      // https://www.bluerentalcars.com/
        Driver.getDriver().get(ConfigReader.getProperty("blueRentalUrl"));


      // Admin email: jack@gmail.com
      // Admin password: 12345
        BlueRentalPage blueRentalPage = new BlueRentalPage();
        blueRentalPage.login.click();
        ReusableMethods.wait(1);
        blueRentalPage.email.sendKeys(ConfigReader.getProperty("blueRentalEmail"), Keys.TAB,
                ConfigReader.getProperty("blueRentalPassword"), Keys.ENTER);
        ReusableMethods.wait(1);
        Assert.assertTrue(blueRentalPage.verify.getText().contains("Jack"));
       // Assert.assertTrue(blueRentalPage.verify.isDisplayed());


    }
}
