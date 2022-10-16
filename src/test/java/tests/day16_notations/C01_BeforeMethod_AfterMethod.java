package tests.day16_notations;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utilities.TestBase;

public class C01_BeforeMethod_AfterMethod extends TestBase {

    /*
        @BeforeMethod ve @AfterMethod cnotasyonlari JUnit'deki
        @Before ve @After gibidir.
        Her test method'undan once ve sonra calisirlar.
    */

    @Test
    public void amazonTesti() {
        driver.get("https://www.amazon.com");
    }

    @Test
    public void test02() {
        driver.get("https://www.bestbuy.com");
    }

    @Test
    public void techproedTesti() {
        driver.get("https://www.techproeducation.com");
    }
}
