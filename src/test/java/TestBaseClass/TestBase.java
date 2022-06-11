package TestBaseClass;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

public class TestBase {
    private WebDriver driver;

    @BeforeTest
    public void setup() {
        WebDriverManager.firefoxdriver().setup();
        driver = new FirefoxDriver();
        driver.manage().window().maximize();
        driver.get("http://automationpractice.pl/index.php");
    }

    @AfterTest
    public void quit() {
        driver.quit();
    }

    public WebDriver getDriver() {
        return this.driver;
    }
}
