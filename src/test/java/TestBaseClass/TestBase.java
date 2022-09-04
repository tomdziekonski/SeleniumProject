package TestBaseClass;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
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

    public void waitUntilVisible(WebElement element) {
        new WebDriverWait(this.driver, 10).until(ExpectedConditions.visibilityOf(element));
    }

    public void waitUntilClickable(WebElement element) {

        new WebDriverWait(this.driver, 10).until(ExpectedConditions.elementToBeClickable(element));
    }

    public void jsExecutor(WebElement element) {
        JavascriptExecutor executor = (JavascriptExecutor) driver;
        executor.executeScript("arguments[0].click();", element);
    }

    public void waitUntilTextIsVisible(WebElement element, String txt) {
        new WebDriverWait(this.driver, 10).until(ExpectedConditions.textToBePresentInElement(element, txt));
    }
}
