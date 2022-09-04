package PageElements;

import BaseClass.Base;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ShippingAddress extends Base {
    public ShippingAddress(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "company")
    WebElement companyField;

    @FindBy(id = "address1")
    WebElement address;

    @FindBy(id = "city")
    WebElement city;

    @FindBy(id = "phone")
    WebElement phone;

    @FindBy(id = "phone_mobile")
    WebElement mobilePhone;

    @FindBy(id = "submitAddress")
    WebElement saveButton;

    @FindBy(id = "postcode")
    WebElement postalCode;

    @FindBy(xpath = "//span[contains(text(), 'My addresses')]")
    WebElement addressPage;

    @FindBy(xpath = "//span[contains(text(), 'Update')]")
    WebElement updateAddress;

    public WebElement getUpdateAddressPage() {
        return updateAddress;
    }

    public WebElement getAddressPage() {
        return addressPage;
    }

    public WebElement getPostalCode() {
        return postalCode;
    }

    public void saveShippingInfo() {
        saveButton.click();
    }

    public WebElement getPhoneField() {
        return phone;
    }

    public WebElement getMobilePhoneField() {
        return mobilePhone;
    }

    public WebElement getCompanyField() {
        return companyField;
    }

    public WebElement getAddressField() {
        return address;
    }

    public WebElement getCityField() {
        return city;
    }

    public WebElement getStateSelector(int value) {
        return driver.findElement(By.xpath("//select[@id='id_state']//option[@value='" + value + "']"));
    }
}
