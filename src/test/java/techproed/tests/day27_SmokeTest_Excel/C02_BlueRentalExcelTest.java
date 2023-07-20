package techproed.tests.day27_SmokeTest_Excel;

import org.testng.annotations.Test;
import techproed.utilities.ExcelReader;

public class C02_BlueRentalExcelTest {


    @Test
    public void test01() {

        //mysmoketestdata excel dosyasindaki 1.satir bilgilerini consola yazdiralim

        String pathFile = "src/test/java/techproed/resources/mysmoketestdata.xlsx";
        String fileName="customer_info";

        ExcelReader reader = new ExcelReader(pathFile,fileName);
        System.out.println("username : "+reader.getCellData(1, 0));
        System.out.println("password : "+reader.getCellData(1, 1));


    }
}
