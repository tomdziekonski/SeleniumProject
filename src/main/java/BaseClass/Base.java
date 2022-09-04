package BaseClass;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Base {
    protected WebDriver driver;

    public Base(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void waitUntilVisible(WebElement element) {
        new WebDriverWait(this.driver, 10).until(ExpectedConditions.visibilityOf(element));
    }
}