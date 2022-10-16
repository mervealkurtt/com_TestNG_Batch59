package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class FacebookPage {

    public FacebookPage() {
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(id = "email")
    public WebElement mailKutusu;

    @FindBy(id = "pass")
    public WebElement sifreKutusu;

    @FindBy(xpath = "//button[@class='_42ft _4jy0 _6lth _4jy6 _4jy1 selected _51sy']")
    public WebElement loginTusu;

    @FindBy(xpath = "//div[@class='_9ay7']")
    public WebElement girilemediYaziElementi;

}
