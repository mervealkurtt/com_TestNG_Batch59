package utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

import java.time.Duration;

public class Driver {

        /*
        POM'de Driver icin TestBase class'ini extdens etmek yerine
        Driver class'indan static method'lar kullanarak driver
        olusturup, ilgili ayarlarin yapilmasi ve en sonda driver'in
        kapatilmasi tercih edilmistir.

        POM'de Driver Class'indaki getDriver()'nin obje olusturularak
        kullanimini engellemek icin
        Singelton Pattern kullanimi benimsenmistir.

        Singelton Pattern : Tekli kullanim, bir class'in farkli class'lardan
        obje olusturularak kullanimini engellemek icin kullanilir.

        Bunu sağlamak icin;
        Obje olusturmak icin kullanilan constructor'i private yaptiginizda
        baska class'larda Driver class'indan obje olusturulmasi mumkun OLAMAZ.
    */

    private Driver() {

    }

    static WebDriver driver;

    public static WebDriver getDriver(){

        if(driver == null){

            switch (ConfigReader.getProperty("browser")){
                case "chrome" :
                    WebDriverManager.chromedriver().setup();
                    driver = new ChromeDriver();
                    break;
                case "safari" :
                    WebDriverManager.safaridriver().setup();
                    driver = new SafariDriver();
                    break;
                case "firefox" :
                    WebDriverManager.firefoxdriver().setup();
                    driver = new FirefoxDriver();
                    break;
                case "edge" :
                    WebDriverManager.edgedriver().setup();
                    driver = new EdgeDriver();
                    break;
                case "headless-chrome" :
                    WebDriverManager.chromedriver().setup();
                    driver = new ChromeDriver(new ChromeOptions().setHeadless(true));
                    break;
                default :
                    WebDriverManager.chromedriver().setup();
                    driver = new ChromeDriver();
            }

            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        }

        return driver;
    }

    public static void closeDriver(){
        if (driver != null){   // driver'a deger atanmissa
            driver.close();
            driver = null;   // sonraki acmalarda sorun olmasin diye driver'a null degeri ata
        }
    }
}
