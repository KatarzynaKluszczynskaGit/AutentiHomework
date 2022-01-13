package base;

import config.Config;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.time.Duration;

public class BaseTest {

    protected WebDriver driver;
    protected Config config;

    @BeforeMethod
    public void baseBeforeMethod(){

        config = new Config();
        System.setProperty(config.getChromedriverPropertyName(), config.getChromedriverPath());
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.navigate().to(config.getApplicationUrl());
        driver.manage().deleteAllCookies();
    }

    @AfterMethod
    public void baseAfterMethod(){
        driver.quit();
    }
}