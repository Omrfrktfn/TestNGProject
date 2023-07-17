package techproed.tests.day25_POM;

import org.testng.annotations.Test;
import techproed.utilities.ConfigReader;
import techproed.utilities.Driver;

public class C02_PropertiesKullanimi {

    @Test
    public void test01() {

        Driver.getDriver().get(ConfigReader.getProperty("amazonUrl"));

        /*
Eğer çok fazla amazon sayfasına gittiğimizi düşünelim ve
amazon url de bir değişiklik olduğunda bütün testlerden düzeltmek yerine
sadece .properties dosyasından düzelterek tüm testlerdeki url i düzeltmiş oluruz
 */
    }
}
