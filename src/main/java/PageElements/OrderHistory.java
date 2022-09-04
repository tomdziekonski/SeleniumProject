package PageElements;

import BaseClass.Base;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class OrderHistory extends Base {

    public OrderHistory(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//a[@title='Go to your order history page']")
    WebElement orderHistory;

    @FindBy(xpath = "//ul[@class='address alternate_item box']//span[@class='address_firstname']")
    WebElement orderName;

    @FindBy(xpath = "//ul[@class='address alternate_item box']//span[@class='address_lastname']")
    WebElement orderLastName;

    @FindBy(xpath = "//ul[@class='address alternate_item box']//span[@class='address_city']")
    WebElement orderCity;

    @FindBy(xpath = "//ul[@class='address alternate_item box']//span[@class='address_Country:name']")
    WebElement orderCountry;

    @FindBy(xpath = "//tr[@class='totalprice item']//span[@class='price']")
    WebElement orderTotalPrice;

    @FindBy(xpath = "//td[contains(text(), 'Additional Comment')]")
    WebElement orderComment;

    public WebElement getOrderComment() {
        return orderComment;
    }

    public WebElement getOrderTotalPrice() {
        return orderTotalPrice;
    }

    public WebElement getOrderCountry() {
        return orderCountry;
    }

    public WebElement getOrderName() {
        return orderName;
    }

    public WebElement getOrderLastName() {
        return orderLastName;
    }

    public WebElement getOrderCity() {
        return orderCity;
    }

    public WebElement getOrderHistory() {
        return orderHistory;
    }

    public List<WebElement> getOrderDetails() {
        List<WebElement> orders = driver.findElements(By.xpath("//table[@id='order-list']//span[contains(text(), 'Details')]"));
        return orders;
    }
}
