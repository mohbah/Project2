package poms;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ShopperLoginPage {
    private WebDriver driver;

    public ShopperLoginPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(id ="login-btn2")
    public WebElement loginButton;

    @FindBy(id ="username2")
    public WebElement inputUsername;

    @FindBy(id ="password2")
    public  WebElement inputPassword;
}
