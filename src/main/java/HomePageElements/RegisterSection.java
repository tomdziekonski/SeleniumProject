package HomePageElements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class RegisterSection {

    public static WebElement getSignInPage(WebDriver driver) {
        return driver.findElement(By.xpath("//a[@class='login']"));
    }

    public static WebElement getEmailAddressInputField(WebDriver driver) {
        return driver.findElement(By.xpath("//input[@id='email_create']"));
    }

    public static WebElement getCreateAccountButton(WebDriver driver) {
        return driver.findElement(By.xpath("//i[@class='icon-user left']"));
    }

    public static WebElement getGenderSelector(WebDriver driver) {
        return driver.findElement(By.xpath("//input[@id='id_gender1']"));
    }

    public static WebElement getFirstNameInputField(WebDriver driver) {
        return driver.findElement(By.xpath("//input[@id='customer_firstname']"));
    }

    public static WebElement getLastNameInputField(WebDriver driver) {
        return driver.findElement(By.xpath("//input[@id='customer_lastname']"));
    }

    public static WebElement getEmailInputField(WebDriver driver) {
        return driver.findElement(By.xpath("//input[@id='email']"));
    }

    public static WebElement getPasswordInputField(WebDriver driver) {
        return driver.findElement(By.xpath("//input[@id='passwd']"));
    }

    public static WebElement getDaySelector(WebDriver driver, int value) {
        return driver.findElement(By.xpath("//select[@id='days']//option[@value='" + value + "']"));
    }

    public static WebElement getMonthSelector(WebDriver driver, int value) {
        return driver.findElement(By.xpath("//select[@id='months']//option[@value='" + value + "']"));
    }

    public static WebElement getYearSelector(WebDriver driver, int value) {
        return driver.findElement(By.xpath("//select[@id='years']//option[@value='" + value + "']"));
    }

    public static WebElement getSpecialOffers(WebDriver driver) {
        return driver.findElement(By.xpath("//input[@id='optin']"));
    }

    public static WebElement getSRegisterButton(WebDriver driver) {
        return driver.findElement(By.xpath("//span[contains(text(), 'Register')]"));
    }

    public static WebElement getSuccessfulRegistrationInfo(WebDriver driver) {
        return driver.findElement(By.xpath("//p[@class='alert alert-success']"));
    }
}
