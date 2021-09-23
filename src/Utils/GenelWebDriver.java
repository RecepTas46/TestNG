package Utils;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.testng.annotations.*;

import java.util.concurrent.TimeUnit;

public class GenelWebDriver {


    public static WebDriver driver;

    @BeforeClass
    public void BaslangicIslemleri() {
        System.setProperty(ChromeDriverService.CHROME_DRIVER_SILENT_OUTPUT_PROPERTY, "true");
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
        driver = new ChromeDriver();


        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();

        driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

        driver.get("http://opencart.abstracta.us/index.php?route=account/login");


        LoginTest();
    }

    @AfterClass
    public  void BitisIslemleri() throws InterruptedException {
        Thread.sleep(5000);
      //  driver.quit();
    }

     void LoginTest()
     {
        WebElement email = driver.findElement(By.id("input-email"));
        email.sendKeys("asd@gmail.com");

        WebElement password = driver.findElement(By.id("input-password"));
        password.sendKeys("123qweasd");

        WebElement loginBtn = driver.findElement(By.cssSelector("input[class='btn btn-primary']"));
        loginBtn.click();

        WebElement adventec = driver.findElement(By.id("details-button"));
        adventec.click();

        WebElement adventecLink = driver.findElement(By.id("proceed-link"));
        adventecLink.click();
    }

    public void clickElementJs(WebElement webElement){
        JavascriptExecutor executor = (JavascriptExecutor) driver;
        executor.executeScript("arguments[0].click();", webElement);
    }

}
