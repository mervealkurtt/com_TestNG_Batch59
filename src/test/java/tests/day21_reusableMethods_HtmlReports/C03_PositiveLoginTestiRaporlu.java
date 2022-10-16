package tests.day21_reusableMethods_HtmlReports;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.BrcPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.TestBaseRapor;

public class C03_PositiveLoginTestiRaporlu extends TestBaseRapor {

    BrcPage brcPage;


    @Test
    public void test01() {

        brcPage = new BrcPage();

        extentTest = extentReports.createTest("Pozitif Login", "Gecerli username ve sifre ile giris yapabilmeli");
        // bundan sonra bilgi verilmesini istedigimiz her satirda aciklama ekliyoruz

        // https://www.bluerentalcars.com adresine git
        Driver.getDriver().get(ConfigReader.getProperty("brcUrl"));
        extentTest.info("Brc anasayfaya gidildi");

        // login butonuna bas
        brcPage.ilkLoginButonu.click();
        extentTest.info("Login butonuna tiklandi");

        // test data email : customer@bluerentalcar.com
        brcPage.emailTextBox.sendKeys(ConfigReader.getProperty("brcValidEmail"));
        extentTest.info("Gecerli email yazildi");

        // test data password : 12345
        brcPage.passwordTextBox.sendKeys(ConfigReader.getProperty("brcValidPassword"));
        extentTest.info("Gecerli password yazildi");

        // login butonuna bas
        brcPage.ikinciLoginButonu.click();
        extentTest.info("Login butonuna basildi");

        // Degerleri girdildiginde sayfaya basarili bir sekilde girilebildigini test et
        String actualUsername = brcPage.kullaniciProfilIsmi.getText();
        String expectedUsername = ConfigReader.getProperty("brcValidUsername");

        Assert.assertEquals(actualUsername,expectedUsername);
        extentTest.pass("Kullanici basarli sekilde giris yapti");

        Driver.closeDriver();
    }
}
