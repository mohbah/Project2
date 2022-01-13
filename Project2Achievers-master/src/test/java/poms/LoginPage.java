package poms;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage {
    private WebDriver driver;
    //WebDriverWait wait = new WebDriverWait(driver, 5);

    public LoginPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(id ="login-btn")
    public WebElement loginButton;

    @FindBy(id ="username")
    public WebElement inputUsername;

    @FindBy(id ="password")
    public  WebElement inputPassword;

    @FindBy(id ="c")
    public WebElement customerRegister;

    @FindBy(id ="username2")
    public WebElement inputUsernameShopper;

    @FindBy(id ="password2")
    public  WebElement inputPasswordShopper;

    @FindBy(id ="sregister")
    public  WebElement shopperRegister;
}
