package steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import runner.TestRunner;

public class ShopperRegistrationSteps {
    @Given(": Shopper is on registration page")
    public void shopper_is_on_registration_page() {
        TestRunner.driver.get("file:///G:/Project2-_FrontEnd/Project2-%20FrontEnd/Shopper-Register.html");
    }
    @When(": Shopper enters username")
    public void shopper_enters_username() {
        TestRunner.shopperRegisterPage.usernameInput.sendKeys("Braddy");
    }
    @When(": Shopper enters password")
    public void shopper_enters_password() {
        TestRunner.shopperRegisterPage.passwordInput.sendKeys("chilly");
    }
    @When(": Shopper enters name")
    public void shopper_enters_name() {
        TestRunner.shopperRegisterPage.nameInput.sendKeys("Jimmy");
    }
    @When(": Shopper enters zipcode")
    public void shopper_enters_zipcode() {
        TestRunner.shopperRegisterPage.zipcodeInput.sendKeys("11111");
    }
    @When(": Shopper enters age")
    public void shopper_enters_age() {
        TestRunner.shopperRegisterPage.age.sendKeys("32");
    }
    @When("The shopper clicks the shopper register button")
    public void the_shopper_clicks_the_shopper_register_button() {
        TestRunner.shopperRegisterPage.registerButton.click();
    }
    @Then(": Shopper get alert that account creation was successful")
    public void shopper_get_alert_that_account_creation_was_successful() {
        String title = TestRunner.driver.getTitle();
        Assert.assertEquals(title, "ShoppingList Application");
    }
}
