package tests.day19_smokeTest;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.BrcPage;
import utilities.ConfigReader;
import utilities.Driver;

public class C01_PozitifLoginTest {

    BrcPage brcPage = new BrcPage();

    @Test
    public void positiveLoginTest() {
        // https://www.bluerentalcars.com adresine git
        Driver.getDriver().get(ConfigReader.getProperty("brcUrl"));

        // login butonuna bas
        brcPage.ilkLoginButonu.click();

        // test data email : customer@bluerentalcar.com
        brcPage.emailTextBox.sendKeys(ConfigReader.getProperty("brcValidEmail"));

        // test data password : 12345
        brcPage.passwordTextBox.sendKeys(ConfigReader.getProperty("brcValidPassword"));

        // login butonuna bas
        brcPage.ikinciLoginButonu.click();

        // Degerleri girdildiginde sayfaya basarili bir sekilde girilebildigini test et
        String actualUsername = brcPage.kullaniciProfilIsmi.getText();
        String expectedUsername = ConfigReader.getProperty("brcValidUsername");

        Assert.assertEquals(actualUsername,expectedUsername);

        Driver.closeDriver();
    }
}