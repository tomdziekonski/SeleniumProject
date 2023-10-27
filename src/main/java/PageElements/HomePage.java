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

    @FindAll(@FindBy(how = How.XPATH, using = "//span[@class='price product-price']"))
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

    @FindBy(xpath = "//ul[@class='sf-menu clearfix menu-content sf-js-enabled sf-arrows']//a[@title='Women']")
    WebElement womenSection;

    @FindBy(xpath ="//a[@title='Summer Dresses']")
    WebElement summerDresses;

    @FindBy(id ="layered_id_attribute_group_8")
    WebElement whiteColorFilter;

    @FindBy(xpath ="//a[@data-id-product='6' and contains(text(), 'Add to Compare')]")
    WebElement printedSummerDress;

    @FindBy(xpath ="//a[@data-id-product='7' and contains(text(), 'Add to Compare')]")
    WebElement printeChriffonDress;

    @FindBy(xpath ="//button[@class='btn btn-default button button-medium bt_compare bt_compare']")
    WebElement compareButton;

    @FindBy(xpath ="//h1[@class='page-heading']")
    WebElement compareSection;

    @FindBy(xpath = "//button[@class='btn btn-default button button-small']")
    WebElement newsletterButton;

    @FindBy(how = How.CSS, using = "p[class=\"alert alert-success\"]")
    WebElement newsletterSaved;

    @FindBy(how = How.CSS, using = "input[id='newsletter-input']")
    WebElement newsletterInputField;

    public WebElement getcompareSection() {
        return compareSection;
    }

    public WebElement getPrintedSummerDress() {
        return printedSummerDress;
    }

    public WebElement getCompareButton() {
        return compareButton;
    }

    public WebElement getPrintedChriffonDress() {
        return printeChriffonDress;
    }

    @FindAll(@FindBy(how = How.XPATH, using = "//div[@class='content_price']"))
    List<WebElement> blouseWebElements;

    public WebElement getSummerDresses() {
        return summerDresses;
    }

    public WebElement getWhiteColorFilter() {
        return whiteColorFilter;
    }

    public WebElement getWomenSection() {
        return womenSection;
    }

    public WebElement getLogout() {
        return logout;
    }

    public WebElement getNewsletterButton() {
        return newsletterButton;
    }

    public WebElement getNewsletterSaved() {
        return newsletterSaved;
    }

    public WebElement getNewsletterInputField() {
        return newsletterInputField;
    }

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

    public ArrayList<Integer> womenSectionPrices() {
        ArrayList<Integer> womenSectionPrices = new ArrayList<>();

        for (WebElement womanSectionPricesWebElement : getWomanSectionPriceWebElements()) {
            String price = womanSectionPricesWebElement.getText();

            if (!price.equals("")) {
                String sub = price.substring(1, 3);
                womenSectionPrices.add(Integer.parseInt(sub));
            }
        }
        return womenSectionPrices;
    }
}
