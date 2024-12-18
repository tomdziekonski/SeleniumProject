import PageElements.*;
import TestBaseClass.TestBase;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Random;

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
        Assert.assertEquals(convertedBlouseWebElements.get(0), "$27");
    }

    @Test
    public void isItPossibleToSuccessfullyRegister() {
        RegisterSection register = new RegisterSection(getDriver());
        register.register("Tom", "Dziekonski", "12345");
        Assert.assertEquals(register.getSuccessfulRegistrationInfo().getText(), "Your account has been created.");
    }

    @Test
    public void isItPossibleToFilterProducts() {
        HomePage Home = new HomePage(getDriver());
        Actions Action = new Actions(getDriver());
        Action.moveToElement(Home.getWomenSection()).perform();

        waitUntilVisible(Home.getSummerDresses());
        waitUntilClickable(Home.getSummerDresses());
        Home.getSummerDresses().click();

        Assert.assertEquals(Home.howManyResultsFound().getText(), "There are 3 products.");
        Home.getWhiteColorFilter().click();
        waitUntilTextIsVisible(Home.howManyResultsFound(), "There is 1 product.");
        Assert.assertEquals(Home.howManyResultsFound().getText(), "There is 1 product.");
    }

    @Test
    public void isItPossibleToCompareProducts() {
        HomePage Home = new HomePage(getDriver());
        Actions Action = new Actions(getDriver());
        Action.moveToElement(Home.getWomenSection()).perform();

        waitUntilVisible(Home.getSummerDresses());
        waitUntilClickable(Home.getSummerDresses());
        Home.getSummerDresses().click();

        jsExecutor(Home.getPrintedSummerDress());
        jsExecutor(Home.getPrintedChriffonDress());
        waitUntilVisible(Home.getCompareButton());
        waitUntilVisible(Home.getCompareButton());
        Home.getCompareButton().click();
        Assert.assertEquals(Home.getcompareSection().getText(), "PRODUCT COMPARISON");
    }

    @Test
    public void isItPossibleToSignToTheNewsletter() throws InterruptedException {
        HomePage Home = new HomePage(getDriver());
        Actions Action = new Actions(getDriver());
        Action.sendKeys(Keys.PAGE_DOWN);
        Action.sendKeys(Keys.PAGE_DOWN);
        Action.sendKeys(Keys.PAGE_DOWN);
        Action.sendKeys(Keys.PAGE_DOWN);

        Random emailRandomizer = new Random();
        int randomEmail = emailRandomizer.nextInt();

        waitUntilVisible(Home.getNewsletterInputField());
        Thread.sleep(2000);
        Home.getNewsletterInputField().sendKeys(randomEmail + "@testing.pl");
        Thread.sleep(2000);
        Home.getNewsletterButton().click();
        waitUntilVisible(Home.getNewsletterSaved());

        Assert.assertEquals(Home.getNewsletterSaved().getText(), "Newsletter : You have successfully subscribed to this newsletter.");
    }

    @Test
    public void isItPossibleToBuyAProduct() throws InterruptedException {
        HomePage Home = new HomePage(getDriver());
        Home.signIn("tester@op.pl", "12345");
        SignInSection signSection = new SignInSection(getDriver());
        String whichUserIsLoggedIn = signSection.getWhichUserIsLoggedIn().getText();
        Assert.assertEquals(whichUserIsLoggedIn, "G g");

        ShippingAddress Shipping = new ShippingAddress(getDriver());
        Shipping.getAddressPage().click();
        Shipping.getUpdateAddressPage().click();
        Shipping.getCompanyField().clear();
        Shipping.getCompanyField().sendKeys("companyX");
        Shipping.getAddressField().clear();
        Shipping.getAddressField().sendKeys("Some Street");
        Shipping.getCityField().clear();
        Shipping.getCityField().sendKeys("City in Alabama");
        Shipping.getStateSelector(1).click();
        Shipping.getPhoneField().clear();
        Shipping.getPhoneField().sendKeys("666");
        Shipping.getMobilePhoneField().clear();
        Shipping.getMobilePhoneField().sendKeys("111");
        Shipping.getPostalCode().clear();
        Shipping.getPostalCode().sendKeys("12345");
        Shipping.saveShippingInfo();

        Home.search("Blouse");
        waitUntilVisible(Home.getBlouseDetails());
        Home.getBlouseDetails().click();
        waitUntilVisible(Home.getIFrame());
        getDriver().switchTo().frame(Home.getIFrame());
        Thread.sleep(2000);
        Home.changeColor().click();
        waitUntilVisible(Home.getBuyProduct());
        waitUntilClickable(Home.getBuyProduct());
        Home.getBuyProduct().click();
        getDriver().switchTo().defaultContent();
        waitUntilVisible(Home.getAddToCartConfirmation());
        Assert.assertEquals(Home.getAddToCartConfirmation().getText(), "Product successfully added to your shopping cart");

        getDriver().switchTo().defaultContent();
        jsExecutor(Home.getProceedToCheckout());
        CartSection Cart = new CartSection(getDriver());
        waitUntilClickable(Cart.getCartItemQuantity());
        Cart.getCartItemQuantity().clear();
        Cart.getCartItemQuantity().sendKeys("2");
        waitUntilTextIsVisible(Cart.getTotalPrice(), "$63");
        Cart.proceedToCheckout();
        Cart.getAdditionalCommentForm().sendKeys("Additional Comment");
        Cart.getprocessAddress().click();
        Cart.getAgreeToTermsCheckbox().click();
        Cart.getProcessShipping().click();
        Cart.getBankWirePaymentMethod().click();
        Cart.getprocessAddress().click();
        Assert.assertEquals(Cart.getConfirmOrder().getText(), "Your order on My Shop is complete.");

        OrderHistory Order = new OrderHistory(getDriver());
        Order.getOrderHistory().click();
        Order.getOrderDetails().get(0).click();

        waitUntilVisible(Order.getOrderName());
        Assert.assertEquals(Order.getOrderName().getText(), "G");
        Assert.assertEquals(Order.getOrderLastName().getText(), "g");
        Assert.assertEquals(Order.getOrderCity().getText(), "City in Alabama,");
        Assert.assertEquals(Order.getOrderCountry().getText(), "United States");
        Assert.assertEquals(Order.getOrderTotalPrice().getText(), "$63");
        Assert.assertEquals(Order.getOrderComment().getText(), "Additional Comment");

        Home.getLogout().click();
    }
}