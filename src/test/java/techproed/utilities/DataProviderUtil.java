package techproed.utilities;

import org.testng.annotations.DataProvider;

public class DataProviderUtil {

    @DataProvider
    public static Object[][] sehirVerileri() {
        return new Object[][]{{"ankara","anadolu","06"},
                {"istanbul","marmara","34"},
                {"izmir","ege","35"}};
    }
}
