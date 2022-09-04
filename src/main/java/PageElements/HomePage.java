package PageElements;

import BaseClass.Base;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import java.util.ArrayList;
import java.util.List;

public class HomePage extends Base {
    public HomePage(WebDriver driver) {
        super(driver);
    }

    @FindBy(linkText = "Women")
    WebElement womanSection;

    @FindBy(xpath = "//div[@class='header_user_info']//a[@class='login']")
    WebElement signIn;

    @FindBy(xpath = "//a[@title='Proceed to checkout']")
    WebElement proceedToCheckout;

    @FindBy(xpath = "//img[@title='Blouse']")
    WebElement blouseDetails;

    @FindBy(xpath = "//*[text()[contains(.,\"Product successfully added to your shopping cart\")]]")
    WebElement addToCartConfirmation;

    @FindAll(@FindBy(how = How.XPATH, using = "//div[@class='content_price']"))
    List<WebElement> womanSectionPriceWebElements;

    @FindBy(xpath = "//input[@id='search_query_top']")
    WebElement searchBar;

    @FindBy(xpath = "//input[@id='email']")
    WebElement signInEmailField;

    @FindBy(xpath = "//input[@id='passwd']")
    WebElement signInPasswordField;

    @FindBy(xpath = "//button[@id='SubmitLogin']")
    WebElement signInButton;

    @FindBy(css = "button.btn.btn-default.button-search")
    WebElement findButton;

    @FindBy(xpath = "//iframe[contains(@id,'fancybox')]")
    WebElement iFrame;

    @FindBy(xpath = "//p[@id='add_to_cart']//button[@name='Submit']")
    WebElement buyProduct;

    @FindBy(xpath = "//div[@id='center_column']//span[@class='heading-counter']")
    WebElement howManyResultsFound;

    @FindBy(xpath = "//a[@class='logout']")
    WebElement logout;

    public WebElement getLogout() {
        return logout;
    }

    @FindAll(@FindBy(how = How.XPATH, using = "//div[@class='content_price']"))
    List<WebElement> blouseWebElements;

    public void signIn(String email, String password) {
        signIn.click();
        signInEmailField.sendKeys(email);
        signInPasswordField.sendKeys(password);
        signInButton.click();
    }

    public void getWomanSection() {
        womanSection.click();
    }

    public void proceedToCheckout() {
        proceedToCheckout.click();
    }

    public WebElement getProceedToCheckout() {
        return proceedToCheckout;

    }

    public WebElement getAddToCartConfirmation() {
        return addToCartConfirmation;
    }

    public WebElement getIFrame() {
        return iFrame;
    }

    public void getBuyProduct() {
        buyProduct.click();
    }

    public void search(String searchPhrase) {
        searchBar.click();
        searchBar.sendKeys(searchPhrase);
        findButton.click();
    }

    public WebElement howManyResultsFound() {
        return howManyResultsFound;
    }

    public void getBlouseDetails() {
        blouseDetails.click();
    }

    public List<WebElement> getWomanSectionPriceWebElements() {
        return womanSectionPriceWebElements;
    }

    public List<WebElement> getBlouseWebElements() {
        return blouseWebElements;
    }

    public ArrayList<Double> womenSectionPrices() {
        ArrayList<Double> womenSectionPrices = new ArrayList<>();

        for (WebElement womanSectionPricesWebElement : getWomanSectionPriceWebElements()) {
            String price = womanSectionPricesWebElement.getText();

            if (!price.equals("")) {
                String sub = price.substring(1, 6);
                womenSectionPrices.add(Double.parseDouble(sub));
            }
        }
        return womenSectionPrices;
    }
}
