package PageElements;

import BaseClass.Base;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CartSection extends Base {
    public CartSection(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//input[@class='cart_quantity_input form-control grey']")
    WebElement cartItemQuantity;

    @FindBy(xpath = "//a[@class='button btn btn-default standard-checkout button-medium']")

    WebElement proceedToCheckout;

    @FindBy(xpath = "//textarea[@class='form-control']")
    WebElement additionalComment;

    @FindBy(name = "cgv")
    WebElement agreeToTermsCheckbox;

    @FindBy(xpath = "//button[@class='button btn btn-default button-medium']")
    WebElement processAddress;

    @FindBy(name = "processCarrier")
    WebElement processShipping;

    @FindBy(xpath = "//a[@title='Pay by bank wire']")
    WebElement bankWirePaymentMethod;

    @FindBy(xpath = "//p[@class='alert alert-success']")
    WebElement confirmOrder;

    @FindBy(xpath = "//span[@id='total_price']\n")
    WebElement totalPrice;

    public WebElement getTotalPrice() {
        return totalPrice;
    }

    public WebElement getBankWirePaymentMethod() {
        return bankWirePaymentMethod;
    }

    public WebElement getConfirmOrder() {
        return confirmOrder;
    }

    public WebElement getProcessShipping() {
        return processShipping;
    }

    public WebElement getprocessAddress() {
        return processAddress;
    }

    public WebElement getAgreeToTermsCheckbox() {
        return agreeToTermsCheckbox;
    }

    public WebElement getAdditionalCommentForm() {
        return additionalComment;
    }

    public WebElement getCartItemQuantity() {
        return cartItemQuantity;
    }

    public void proceedToCheckout() {
        proceedToCheckout.click();
    }
}
