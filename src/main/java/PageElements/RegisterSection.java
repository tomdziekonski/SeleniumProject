package PageElements;

import BaseClass.Base;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.Random;

public class RegisterSection extends Base {
    public RegisterSection(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "id_gender1")
    WebElement gender;

    @FindBy(xpath = "//a[@class='login']")
    WebElement signIn;

    @FindBy(xpath = "//input[@id='email_create']")
    WebElement emailAddressInputField;

    @FindBy(xpath = "//i[@class='icon-user left']")
    WebElement createAccountButton;

    @FindBy(xpath = "//input[@id='customer_firstname']")
    WebElement firstNameInputField;

    @FindBy(xpath = "//input[@id='customer_lastname']")
    WebElement lastNameInputField;

    @FindBy(xpath = "//input[@id='email']")
    WebElement emailInputField;

    @FindBy(xpath = "//div[@id='uniform-newsletter']")
    WebElement specialOffers;

    @FindBy(xpath = "//input[@id='passwd']")
    WebElement passwordInputField;

    @FindBy(xpath = "//span[contains(text(), 'Register')]")
    WebElement registerButton;

    @FindBy(xpath = "//p[@class='alert alert-success']")
    WebElement successfulRegistrationInfo;

    public WebElement getDaySelector(int value) {
        return driver.findElement(By.xpath("//select[@id='days']//option[@value='" + value + "']"));
    }

    public WebElement getMonthSelector(int value) {
        return driver.findElement(By.xpath("//select[@id='months']//option[@value='" + value + "']"));
    }

    public WebElement getYearSelector(int value) {
        return driver.findElement(By.xpath("//select[@id='years']//option[@value='" + value + "']"));
    }

    public WebElement getSuccessfulRegistrationInfo() {
        return driver.findElement(By.xpath("//p[@class='alert alert-success']"));
    }

    public void register(String name, String surname, String password) {
        Random emailRandomizer = new Random();
        int randomEmail = emailRandomizer.nextInt();
        signIn.click();
        emailAddressInputField.sendKeys(randomEmail + "@testing.pl");
        createAccountButton.click();
        waitUntilVisible(gender);
        gender.click();
        firstNameInputField.sendKeys(name);
        lastNameInputField.sendKeys(surname);
        emailInputField.click();
        getDaySelector(1).click();
        getMonthSelector(10).click();
        getYearSelector(1990).click();
        specialOffers.click();
        passwordInputField.sendKeys(password);
        registerButton.click();
        waitUntilVisible(successfulRegistrationInfo);
    }
}
