package Steps;

import Pages.MainPage;
import Pages.YandexMarketPage;
import org.junit.*;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import ru.yandex.qatools.allure.annotations.Attachment;

import java.util.concurrent.TimeUnit;
/**
 * Created by Diana on 06.12.2020.
 */

public class BaseSteps {

    private static WebDriver driver;
   // private MainPage mainPage;
    public static WebDriver getDriver(){
        return driver;
    }



    @Before
    public void setUp() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "drv/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get("https://yandex.ru/");
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        Thread.sleep(10000);

    }



    @AfterClass
    public static void tearDown() {
        driver.quit();

    }


    @Attachment(type = "image/png", value = "Screenshot")
    public static byte[] takeScreenshot() {
        return ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
    }


}
