package tests.day16_notations;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import utilities.TestBase;

import java.util.List;

public class C07_SoftAssert extends TestBase {

    @Test
    public void test01() {

        // http://zero.webappsecurity.com/ adresine gidin
        driver.get("http://zero.webappsecurity.com/");

        // Sign in butonuna basin
        driver.findElement(By.xpath("//button[@id='signin_button']")).click();

        // Login kutusuna "username" yazin
        driver.findElement(By.xpath("//input[@id='user_login']")).sendKeys("username");

        // Password kutusuna "password" yazin
        driver.findElement(By.xpath("//input[@id='user_password']")).sendKeys("password");

        // Sign in tusuna basin
        driver.findElement(By.xpath("//input[@type='submit']")).click();
        driver.navigate().back();

        // Online banking menusu icinde "Pay Bills" sayfasina gidin
        driver.findElement(By.xpath("//strong[text()='Online Banking']")).click();
        driver.findElement(By.xpath("//span[@id='pay_bills_link']")).click();

        // "Purchase Foreign Currency" tusuna basin
        driver.findElement(By.xpath("//*[text()='Purchase Foreign Currency']")).click();

        // "Currency" dropdown menusunden "Eurozone (euro)"u secin
        WebElement ddo = driver.findElement(By.xpath("//select[@id='pc_currency']"));
        Select select = new Select(ddo);
        select.selectByVisibleText("Eurozone (euro)");

        // softAssert kullanarak "Eurozone (Euro)" secildigini test edin
        SoftAssert softAssert = new SoftAssert();
        String secilenOption = select.getFirstSelectedOption().getText();
        String expectedOption = "Eurozone (Euro)";
        softAssert.assertEquals(secilenOption,expectedOption, "secilen option uygun degil");

        // softAssert kullanarak DropDown listesinin su secenekleri oldugunu test edin:
        // "Select One", "Australia (dollar)", "Canada (dollar),
        List<WebElement> optionList = select.getOptions();

    }
}
