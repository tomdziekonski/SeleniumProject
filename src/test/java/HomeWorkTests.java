import BaseClass.Base;
import HomePageElements.HomePage;
import HomePageElements.RegisterSection;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class HomeWorkTests extends Base {

    @BeforeTest
    public void setup() {
        WebDriverManager.firefoxdriver().setup();
        tester = new FirefoxDriver();
        tester.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        tester.manage().window().maximize();
    }

    @Test
    public void womanSectionPricesAreGreaterThanZero() throws Exception {
        tester.get("http://automationpractice.pl/index.php");
        HomePage.getWomanSection(tester).click();
        List<WebElement> womanSectionPriceWebElements = tester.findElements(By.xpath("//div[@class='content_price']"));
        ArrayList<Double> convertedPriceElements = new ArrayList<>();

        for (WebElement womanSectionPricesWebElement : womanSectionPriceWebElements) {
            String price = womanSectionPricesWebElement.getText();

            if (!price.equals("")) {
                String sub = price.substring(1, 6);
                convertedPriceElements.add(Double.parseDouble(sub));
            }

            for (double convertedPrice : convertedPriceElements) {
                if (convertedPrice <= 0) {
                    throw new Exception("Price test failed");
                }
            }
        }
    }

    @Test
    public void womanSectionBlouseIsFound() {
        tester.get("http://automationpractice.pl/index.php");
        HomePage.searchBar(tester).click();
        HomePage.searchBar(tester).sendKeys("Blouse");
        HomePage.findButton(tester).click();
        Assert.assertEquals(HomePage.howManyResultsFound(tester).getText(), "1 result has been found.");
        List<WebElement> blouseWebElements = tester.findElements(By.xpath("//div[@class='content_price']"));
        ArrayList<String> convertedBlouseWebElements = new ArrayList<>();
        for (WebElement blousePrice : blouseWebElements) {
            String price = blousePrice.getText();

            if (!price.equals("")) {
                convertedBlouseWebElements.add(price);
            }
        }

        Assert.assertEquals(convertedBlouseWebElements.get(0), "$27.00");
    }

    @Test
    public void registerTest() {
        tester.get("http://automationpractice.pl/index.php");
        RegisterSection.getSignInPage(tester).click();
        RegisterSection.getEmailAddressInputField(tester).sendKeys("just5@testing.pl");
        RegisterSection.getCreateAccountButton(tester).click();
        RegisterSection.getGenderSelector(tester).click();
        RegisterSection.getFirstNameInputField(tester).sendKeys("Tom");
        RegisterSection.getLastNameInputField(tester).sendKeys("Dziekonski");
        RegisterSection.getEmailInputField(tester).click();
        RegisterSection.getDaySelector(tester, 1).click();
        RegisterSection.getMonthSelector(tester, 10).click();
        RegisterSection.getYearSelector(tester, 1990).click();
        RegisterSection.getSpecialOffers(tester).click();
        RegisterSection.getPasswordInputField(tester).sendKeys("password");
        RegisterSection.getSRegisterButton(tester).click();
        Assert.assertEquals(RegisterSection.getSuccessfulRegistrationInfo(tester).getText(), "Your account has been created.");
    }

    @AfterTest
    public void quit() {
        tester.quit();
    }
}
