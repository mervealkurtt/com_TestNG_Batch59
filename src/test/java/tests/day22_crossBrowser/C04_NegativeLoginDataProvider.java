package tests.day22_crossBrowser;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.BrcPage;
import utilities.ConfigReader;
import utilities.Driver;

public class C04_NegativeLoginDataProvider {

    BrcPage brcPage = new BrcPage();

    @DataProvider
    public static Object[][] kullaniciListesi() {

        Object[][] kullaniciBilgileri = {{"firuze@nehaber.com", "54678"},
                                          {"murat@benbuisibilirim.com", "65874"},
                                         {"ilys@hollandadanselam.com", "85967"}};
        return new Object[][]{};
    }

    @Test(dataProvider = "kullaniciListesi")
    public void yanlisSifre(String userEmail, String password) {

        // https://www.bluerentalcars.com adresine git
        Driver.getDriver().get(ConfigReader.getProperty("brcUrl"));

        // login butonuna bas
        brcPage.ilkLoginButonu.click();

        // test data email : dataprovider'dan alalim
        brcPage.emailTextBox.sendKeys(userEmail);

        // test data password : dataprovider'dan alalim
        brcPage.passwordTextBox.sendKeys(password);

        // login butonuna bas
        brcPage.ikinciLoginButonu.click();

        // Degerleri girdildiginde sayfaya girilemedigini test et
        Assert.assertTrue(brcPage.ikinciLoginButonu.isDisplayed());

        Driver.closeDriver();
    }
}