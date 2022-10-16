package tests.day22_crossBrowser;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.TestBase;
import utilities.TestBaseCross;


public class C01_AssertionsCross extends TestBaseCross {

    @Test
    public void test01() {

        // Amazon anasafaya gidin
        driver.get("https://www.amazon.com");

        // Title'in "Amazon" icerdigini test edin
        String expectedTitle = "Amazon";
        String actualTitle = driver.getTitle();
        Assert.assertTrue(actualTitle.contains(expectedTitle));

        // Arama kutusunun erisilebilir oldugunu test edin
        WebElement aramaKutusu = driver.findElement(By.id("twotabsearchtextbox"));
        Assert.assertTrue(aramaKutusu.isEnabled());

        // Arama kutusuna "Nutella" yazip aratin
        aramaKutusu.sendKeys("Nutella" + Keys.ENTER);

        // Arama yapildigini test edin
        WebElement sonucYaziElementi = driver.findElement(By.xpath("//div[@class='a-section a-spacing-small a-spacing-top-small']"));
        Assert.assertTrue(sonucYaziElementi.isDisplayed());

        // Arama sonucunun "Nutella" icerdigini test edin
        Assert.assertTrue(sonucYaziElementi.getText().contains("Nutella"));
    }
}
