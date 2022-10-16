package tests.day19_smokeTest;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.BrcPage;
import utilities.ConfigReader;
import utilities.Driver;

public class C02_NegativeLoginTest {

    BrcPage brcPage = new BrcPage();

    @Test
    public void yanlisSifre() {
        // https://www.bluerentalcars.com adresine git
        Driver.getDriver().get(ConfigReader.getProperty("brcUrl"));

        // login butonuna bas
        brcPage.ilkLoginButonu.click();

        // test data email : customer@bluerentalcar.com
        brcPage.emailTextBox.sendKeys(ConfigReader.getProperty("brcValidEmail"));

        // test data password : 54321
        brcPage.passwordTextBox.sendKeys(ConfigReader.getProperty("brcWrongPassword"));

        // login butonuna bas
        brcPage.ikinciLoginButonu.click();

        // Degerleri girdildiginde sayfaya girilemedigini test et
        Assert.assertTrue(brcPage.ikinciLoginButonu.isDisplayed());

        Driver.closeDriver();

        // bu classta 2 test method'u daha olusturun
        // biri yanlisKullanici
        // digeri de yanlis sifre ve kullanici adi
    }
}
