package HomePageElements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePage {

    public static WebElement getWomanSection(WebDriver driver) {
        return driver.findElement(By.linkText("Women"));
    }

    public static WebElement searchBar(WebDriver driver) {
        return driver.findElement(By.xpath("//input[@id='search_query_top']"));
    }

    public static WebElement findButton(WebDriver driver) {
        return driver.findElement(By.cssSelector("button.btn.btn-default.button-search"));
    }

    public static WebElement howManyResultsFound(WebDriver driver) {
        return driver.findElement(By.xpath("//div[@id='center_column']//span[@class='heading-counter']"));
    }
}
