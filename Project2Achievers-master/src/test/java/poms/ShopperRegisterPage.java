package poms;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ShopperRegisterPage {
    WebDriver driver;

    public ShopperRegisterPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(id ="username")
    public WebElement usernameInput;

    @FindBy(id ="password")
    public WebElement passwordInput;

    @FindBy(id ="name")
    public  WebElement nameInput;

    @FindBy(id ="zipcode")
    public WebElement zipcodeInput;

    @FindBy(id ="age")
    public WebElement age;

    @FindBy(id ="login-btn")
    public  WebElement registerButton;
}
