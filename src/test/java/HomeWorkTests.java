import HomePageElements.HomePage;
import HomePageElements.RegisterSection;
import TestBaseClass.TestBase;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import java.util.ArrayList;

public class HomeWorkTests extends TestBase {
    @Test
    public void womanSectionPricesAreGreaterThanZero() throws Exception {
        HomePage home = new HomePage(getDriver());
        home.getWomanSection();
        for (double convertedPrice : home.womenSectionPrices()) {
            if (convertedPrice <= 0) {
                throw new Exception("Price test failed");
            }
        }
    }

    @Test
    public void womanSectionBlouseIsFound() {
        HomePage home = new HomePage(getDriver());
        home.search("Blouse");
        Assert.assertEquals(home.howManyResultsFound().getText(), "1 result has been found.");
        ArrayList<String> convertedBlouseWebElements = new ArrayList<>();
        for (WebElement blousePrice : home.getBlouseWebElements()) {
            String price = blousePrice.getText();

            if (!price.equals("")) {
                convertedBlouseWebElements.add(price);
            }
        }
        Assert.assertEquals(convertedBlouseWebElements.get(0), "$27.00");
    }

    @Test
    public void registerTest() {
        RegisterSection register = new RegisterSection(getDriver());
        register.register("Tom", "Dziekonski", "12345");
        Assert.assertEquals(register.getSuccessfulRegistrationInfo().getText(), "Your account has been created.");
    }
}
