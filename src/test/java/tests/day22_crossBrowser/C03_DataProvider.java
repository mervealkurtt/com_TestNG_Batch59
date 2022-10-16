package tests.day22_crossBrowser;

import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.AmazonPage;
import utilities.ConfigReader;
import utilities.Driver;

public class C03_DataProvider {

    @Test
    public void test01() {

        AmazonPage amazonPage = new AmazonPage();


        // amazon anasayfaya gidelim
        Driver.getDriver().get(ConfigReader.getProperty("amazonUrl"));

        // nutella icin arama yapalim
        amazonPage.aramaKutusu.sendKeys("Nutella" + Keys.ENTER);

        // sonuclarin nutella icerdigini test edelim
        String expectedKelime = "Nutella";
        String actualSonucYazisi = amazonPage.aramaSonucElementi.getText();

        Assert.assertTrue(actualSonucYazisi.contains(expectedKelime));

        // sayfayi kapatalim
        Driver.closeDriver();
    }

    @DataProvider
    public static Object[][] AranacakKelimeler() {
        Object[][] arananKelimeArrayi = {{"Nutella"}, {"Java"}, {"cigdem"}, {"Netherlands"}};
        return arananKelimeArrayi;
    }

    @Test(dataProvider = "AranacakKelimeler")
    /*
        Arayacagimiz kelimeleri bir liste gibi tutup, geri
        yollayacak bir veri saglayici olusturacagiz.
    */
    public void testdataProviderTesti(String arananKelime) {

        AmazonPage amazonPage = new AmazonPage();

        // amazon anasayfaya gidelim
        Driver.getDriver().get(ConfigReader.getProperty("amazonUrl"));

        // Nutella, Java, cigdem ve Netherlands icin arama yapalim
        amazonPage.aramaKutusu.sendKeys(arananKelime + Keys.ENTER);

        // Sonuclarin aradigimiz kelime icerdigini test edelim
        String expectedKelime = arananKelime;
        String actualSonucYazisi = amazonPage.aramaSonucElementi.getText();

        Assert.assertTrue(actualSonucYazisi.contains(expectedKelime));

        // sayfayi kapatalim
        Driver.closeDriver();
    }
}
