package tests.day16_notations;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import utilities.TestBase;

public class C06_SoftAssert extends TestBase {

    /*
        SoftAssertion, baslangic ve ve bitis satirlari arasindaki
        tum assertion'lari yapip bitis satirina geldiginde bize
        buldugu tum hatalari rapor eder.

        - SoftAssert'in baslangici bir obje olusturmadir.
          (Cunku SoftAssert, Assert class'i gibi static degildir.)

        - Sonrasinda tum assert'lerin yerine olusturdugumuz objeyi kullaniriz

        - SoftAssert'e bitis satirini soylemek icin softAssert.assertAll();
          kullanilir.
     */

    @Test(groups = "grup2")
    public void test01() {

        SoftAssert softAssert = new SoftAssert();

        // Amazon anasafaya gidin
        driver.get("https://www.amazon.com");

        // Title'in "Amazon" icerdigini test edin
        String expectedTitle = "Amazon";
        String actualTitle = driver.getTitle();
        softAssert.assertTrue(actualTitle.contains(expectedTitle),"title amazon icermiyor");

        // Arama kutusunun erisilebilir oldugunu test edin
        WebElement aramaKutusu = driver.findElement(By.id("twotabsearchtextbox"));
        softAssert.assertTrue(aramaKutusu.isEnabled(),"arama ktusuna erisilemiyor");

        // Arama kutusuna "Nutella" yazip aratin
        aramaKutusu.sendKeys("Nutella" + Keys.ENTER);

        // Arama yapildigini test edin
        WebElement sonucYaziElementi = driver.findElement(By.xpath("//div[@class='a-section a-spacing-small a-spacing-top-small']"));
        softAssert.assertTrue(sonucYaziElementi.isDisplayed(), "arama yapilamadi");

        // Arama sonucunun "Nutella" icerdigini test edin
        softAssert.assertTrue(sonucYaziElementi.getText().contains("Nutella"), "sonuc yazisi Kutella icermiyor");

        // bu satir yazilmazsa assertion gorevi yapilmamis olur
        softAssert.assertAll();

        /*
            SoftAssert'un hata bulsa bile calismaya devam etme ozelligi assertAll()'e kadardir.
            Eger assertAll()'da failed rapor edilirsa calisma durur ve class'in kalan kismi calistirilmaz.
            (Yani assertAll() hardAssert'deki her bir assert gibidir, hatayi yakalarsa calisma durur.)
         */
        System.out.println("assertion'lardan fail olan olursa, burasi calismaz");
    }
}
