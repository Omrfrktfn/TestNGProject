package techproed.tests.day28_DataProvider;

import org.openqa.selenium.Keys;
import org.openqa.selenium.devtools.v85.network.model.DataReceived;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import techproed.pages.BlueRentalPage;
import techproed.utilities.ConfigReader;
import techproed.utilities.Driver;
import techproed.utilities.ReusableMethods;

public class C03_DataProviderTest {


    @DataProvider
    public static Object[][] blueRental() {
        return new Object[][]{{"sam.walker@bluerentalcars.com","c!fas_art"},
                {"kate.brown@bluerentalcars.com","tad1$Fas"},
                {"raj.khan@bluerentalcars.com","v7Hg_va^"},
                {"pam.raymond@bluerentalcars.com","Nga^g6!"}};
    }

    @Test(dataProvider = "blueRental")
    public void test01(String email, String password) {



        Driver.getDriver().get(ConfigReader.getProperty("blueRentalUrl"));
        ReusableMethods.wait(1);

        BlueRentalPage rentalPage=new BlueRentalPage();

        rentalPage.login.click();
        ReusableMethods.wait(1);
        rentalPage.email.sendKeys(email, Keys.TAB,password,Keys.ENTER);
        //ReusableMethods.tumSayfaResmi();
        ReusableMethods.wait(1);

        Driver.closeDriver();


    }
}
