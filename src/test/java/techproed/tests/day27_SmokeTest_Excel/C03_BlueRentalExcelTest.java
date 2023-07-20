package techproed.tests.day27_SmokeTest_Excel;

import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.Test;
import techproed.pages.BlueRentalPage;
import techproed.utilities.ConfigReader;
import techproed.utilities.Driver;
import techproed.utilities.ExcelReader;
import techproed.utilities.ReusableMethods;

public class C03_BlueRentalExcelTest {

    @Test
    public void test01() {

        /*
         Test yaptığımız sayfadaki dataları .properties yada excel dosyasından alabiliriz.
        .properties dosyasından verileri okuyabilmemiz için ConfigReader class'ı oluşturmuştuk, Aynı şekilde
        excel dosyasındaki verileri okuyabilmek için ExcelReader class'ı oluşturduk. Burdan alacağımız
        email ve password bilgilerini String bir değişkene assing edip login testi yapacağımız sitede
        sendKeys() methodu ile çok rahat kullanabiliriz.
         */

        //  String pathFile = "src/test/java/techproed/resources/mysmoketestdata.xlsx";
        // String fileName="customer_info";
        // ExcelReader reader = new ExcelReader(pathFile,fileName);
        ExcelReader reader = new ExcelReader("src/test/java/techproed/resources/mysmoketestdata.xlsx", "customer_info");


        //BlueRetanCar sayfasina gideim
        Driver.getDriver().get(ConfigReader.getProperty("blueRentalUrl"));
        ReusableMethods.wait(1);

        //mysmoketestdata excel dosyasindan bir kullanici ile login olalim

        String email = reader.getCellData(1, 0);
        String password = reader.getCellData(1, 1);
        // System.out.println("username : " + reader.getCellData(1, 0));
        //System.out.println("password : " + reader.getCellData(1, 1));


        BlueRentalPage blueRentalPage = new BlueRentalPage();
        blueRentalPage.login.click();
        ReusableMethods.wait(1);

        blueRentalPage.email.sendKeys(email, Keys.TAB, password, Keys.ENTER);
        ReusableMethods.wait(1);

        //login oldugumuzu dogrulayalim
        Assert.assertTrue(blueRentalPage.loginVerify.getText().contains("Sam"));

        /*
          Login webelementi login olduktan sonrada ayni locate sahip olabilme ihtimaline karsi daha garantili bir
    dogrulama yapmak icin login olduktan sonra login webelementinin oldugu yerde login oldugumuz yerde kullanici
    ismi cikacaktir. Bu webelementin getText() methodu ile alip kullanici ismini iceriyor mu ? icermiyor mu olarak
    test ederiz
         */


        //sayfayi kapatalim
        ReusableMethods.wait(1);
        Driver.closeDriver();

    }


}
