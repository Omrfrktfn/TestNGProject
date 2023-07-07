package techproed.tests.day23_Annotation;

import org.checkerframework.checker.units.qual.A;
import org.testng.annotations.*;

public class C01_Annotation {

    @BeforeSuite
    public void suite(){
        System.out.println("Her seyden once birkez @BeforeSuite calisir.");
    }

    @BeforeTest
    public void beforeTest(){
        System.out.println("Testlerden once birkez calisir.");
    }

    @BeforeClass
    public void beforeClass(){
        System.out.println("Her class'dan once birkez calisir.");
    }

    @BeforeMethod
    public void setUp(){
        System.out.println("Junitteki @Before notasyonu giobi her methoddan once calisir.");
    }

    @Test
    public void test01() {
        System.out.println("Test1 calisti");
    }

    @Test
    public void test02() {
        System.out.println("Test2 calisti");
    }

    @Test
    public void test03() {
        System.out.println("Test3 calisti");
    }

    @AfterSuite
    public void afterSuite() {
        System.out.println("Her seyden sonra 1 kez calisri");
    }

    @AfterTest
    public void afterTest() {
        System.out.println("Testlerden sonra 1 kez calisir");
    }

    @AfterClass
    public void afterClass(){
        System.out.println("Her class'dan sonra 1 kez calisir.");
    }

    @AfterMethod
    public void tearDown(){
        System.out.println("Junitte'ki @After lokasyonu gibi her methoddan sonra calisir.");
    }
}
