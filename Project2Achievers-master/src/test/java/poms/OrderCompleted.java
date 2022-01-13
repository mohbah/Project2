package poms;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrderCompleted {
    private WebDriver driver;


    public OrderCompleted(WebDriver driver){
        this.driver = driver;
        // the PageFactory handles finding and assigning web elements to the properties we declared below
        PageFactory.initElements(driver,this);
    }

    @FindBy(id = "t")
    public WebElement selectsButton;


    @FindBy(id = "back-btn")
    public WebElement goBackButton;

    @FindBy(id = "delivered-btn")
    public WebElement deliveredButton;

}
