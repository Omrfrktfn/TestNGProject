package techproed.tests.day27_SmokeTest_Excel;

import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.Test;
import techproed.pages.BlueRentalPage;
import techproed.utilities.ConfigReader;
import techproed.utilities.Driver;
import techproed.utilities.ExcelReader;
import techproed.utilities.ReusableMethods;

public class C04_BlueRentalExcelTest {

    @Test
    public void test01() {

        //Excel dosyamızdaki tüm email ve password'ler ile
        //BlueRentalCar sayfasına gidip login olalım

        String pathFile = "src/test/java/techproed/resources/mysmoketestdata.xlsx";
        String fileName = "customer_info";
        ExcelReader reader = new ExcelReader(pathFile, fileName);

        Driver.getDriver().get(ConfigReader.getProperty("blueRentalUrl"));
        ReusableMethods.wait(1);

        BlueRentalPage blueRentalPage = new BlueRentalPage();
        //loop dongusu icinde exceldeki tum veriler ile login olalim
        for (int i = 1; i <= reader.rowCount() ; i++) {

            String email= reader.getCellData(i,0);
            String password= reader.getCellData(i,1);
            System.out.println(email + " <-> " + password);
            blueRentalPage.login.click();
            ReusableMethods.wait(2);
            blueRentalPage.email.sendKeys(email, Keys.TAB,password,Keys.ENTER);
            ReusableMethods.wait(2);
            blueRentalPage.loginVerify.click();
            ReusableMethods.wait(1);
            Assert.assertTrue(blueRentalPage.logOut.isDisplayed());
            ReusableMethods.wait(1);
            blueRentalPage.logOut.click();
            ReusableMethods.wait(2);
            blueRentalPage.okeyButton.click();
            ReusableMethods.wait(1);
        }

        ReusableMethods.wait(1);
        Driver.closeDriver();
    }
}
