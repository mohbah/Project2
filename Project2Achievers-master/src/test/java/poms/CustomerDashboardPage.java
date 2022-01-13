package poms;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CustomerDashboardPage {
    private WebDriver driver;

    public CustomerDashboardPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(id ="logout-btn")
    public WebElement logoutButton;

    @FindBy(id ="deactivate")
    public WebElement deactivation;

    @FindBy(id ="new")
    public  WebElement newShoppingList;

    @FindBy(id ="all")
    public WebElement allList;

    @FindBy(id ="incompleted")
    public WebElement incompleteList;

    @FindBy(id ="completed")
    public  WebElement completedList;

    @FindBy(id ="delete-btn")
    public WebElement deleteList;


}
