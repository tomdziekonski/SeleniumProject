import PageElements.HomePage;
import PageElements.RegisterSection;
import PageElements.SignInSection;
import TestBaseClass.TestBase;
import gherkin.lexer.Th;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import java.util.ArrayList;
import java.util.Set;

public class PageTests extends TestBase {
    @Test
    public void areWomanSectionPricesGreaterThanZero() throws Exception {
        HomePage Home = new HomePage(getDriver());
        Home.getWomanSection();
        for (double convertedPrice : Home.womenSectionPrices()) {
            if (convertedPrice <= 0) {
                throw new Exception("Price test failed");
            }
        }
    }

    @Test
    public void isBlouseFoundAndWithASpecificPrice() {
        HomePage Home = new HomePage(getDriver());
        Home.search("Blouse");
        Assert.assertEquals(Home.howManyResultsFound().getText(), "1 result has been found.");
        ArrayList<String> convertedBlouseWebElements = new ArrayList<>();
        for (WebElement blousePrice : Home.getBlouseWebElements()) {
            String price = blousePrice.getText();

            if (!price.equals("")) {
                convertedBlouseWebElements.add(price);
            }
        }
        Assert.assertEquals(convertedBlouseWebElements.get(0), "$27.00");
    }

    @Test
    public void isItPossibletoSuccessfullyRegister() {
        RegisterSection register = new RegisterSection(getDriver());
        register.register("Tom", "Dziekonski", "12345");
        Assert.assertEquals(register.getSuccessfulRegistrationInfo().getText(), "Your account has been created.");
    }

    @Test
    public void isItPossibleToBuyAProduct() throws InterruptedException {
        HomePage Home = new HomePage(getDriver());
        Home.signIn("tester@op.pl", "12345");
        SignInSection signSection = new SignInSection(getDriver());
        String whichUserIsLoggedIn = signSection.getWhichUserIsLoggedIn().getText();
        Assert.assertEquals(whichUserIsLoggedIn, "G g");
        Home.search("Blouse");
        Home.getBlouseDetails();
        waitUntilVisible(Home.getIFrame());
        getDriver().switchTo().frame(Home.getIFrame());
        Home.getBuyProduct();
        getDriver().switchTo().defaultContent();
        waitUntilVisible(Home.getAddToCartConfirmation());
        Assert.assertEquals(Home.getAddToCartConfirmation().getText(), "Product successfully added to your shopping cart");
        getDriver().switchTo().defaultContent();
        waitUntilVisible(Home.getProceedToCheckout());
        waitUntilClickable(Home.getProceedToCheckout());
        Thread.sleep(3000);
        Home.proceedToCheckout();
    }
}
