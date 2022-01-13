package poms;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WaitPage {
    WebDriver driver;

    /*
    public static WebElement waitForPageToLoad(WebDriver driver, WebElement webElement, int seconds){
        WebDriverWait wait =new WebDriverWait(driver, seconds);
        WebElement element = wait.until(ExpectedConditions.titleIs("Customer Dashboard"));
        return element;
    }

     */
    WebDriverWait wait = new WebDriverWait(driver, 20);
}
