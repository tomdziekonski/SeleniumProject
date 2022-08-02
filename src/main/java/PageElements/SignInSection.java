package PageElements;

import BaseClass.Base;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SignInSection extends Base {
    public SignInSection(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//a[@class='account']//span")
    WebElement whichUserIsLoggedIn;

    public WebElement getWhichUserIsLoggedIn(){
        return whichUserIsLoggedIn;
    }
}
