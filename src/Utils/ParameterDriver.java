package Utils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import java.util.concurrent.TimeUnit;

public class ParameterDriver {


    protected   WebDriver driver;//burdan static yazisini kaldirdik cunku paralel testlerde tek alamanmis gibi algiliyor bir tane olarak goruyor
//protect yaptik sadece extend edenler  kullansin diye
    @BeforeClass
    @Parameters("browser")
    public void BaslangicIslemleri(String browser) {
        if (browser.equalsIgnoreCase("chrome"))
        {
            System.setProperty(ChromeDriverService.CHROME_DRIVER_SILENT_OUTPUT_PROPERTY, "true");
            System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
            driver = new ChromeDriver();
        }else
        if (browser.equalsIgnoreCase("firefox"))
        {
            System.setProperty(FirefoxDriver.SystemProperty.BROWSER_LOGFILE,"/dev/null");
            System.setProperty("webdriver.gecko.driver", "drivers/geckodriver.exe");
            driver = new FirefoxDriver();
        }

        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();

        driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

        driver.get("http://opencart.abstracta.us/index.php?route=account/login");

        LoginTest(browser);
    }


    @AfterClass
    public  void BitisIslemleri() throws InterruptedException {
        Thread.sleep(5000);
        driver.quit();
    }

     void LoginTest(String browser)
     {
        WebElement email = driver.findElement(By.id("input-email"));
        email.sendKeys("asd@gmail.com");

        WebElement password = driver.findElement(By.id("input-password"));
        password.sendKeys("123qweasd");

        WebElement loginBtn = driver.findElement(By.cssSelector("input[class='btn btn-primary']"));
        loginBtn.click();

         if (browser.equalsIgnoreCase("chrome")) {
             WebElement adventec = driver.findElement(By.id("details-button"));
             adventec.click();

             WebElement adventecLink = driver.findElement(By.id("proceed-link"));
             adventecLink.click();
         }
    }

}
