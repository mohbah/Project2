package steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
import runner.TestRunner;

public class CustomerRegisterSteps {
    @Given("The customer is on the registration page")
    public void the_customer_is_on_the_registration_page() {
        TestRunner.driver.get("G:/Project2-_FrontEnd/Project2-%20FrontEnd/Customer-Register.html");
    }
    @When("The customer enters a unique username")
    public void the_customer_enters_a_unique_username() {
        TestRunner.customerRegister.usernameInput.sendKeys("Spawn");
    }
    @When("The customer enters unique password")
    public void the_customer_enters_unique_password() {
        TestRunner.customerRegister.passwordInput.sendKeys("soldier");
    }
    @When("The customer enters their name")
    public void the_customer_enters_their_name() {
        TestRunner.customerRegister.nameInput.sendKeys("Al Simmons");
    }
    @When("The customer enters their zipcode")
    public void the_customer_enters_their_zipcode() {
        TestRunner.customerRegister.zipcodeInput.sendKeys("12345");
    }
    @When("The customer clicks the customer register button")
    public void the_customer_clicks_the_customer_register_button(){
        TestRunner.customerRegister.registerButton.click();
    }
    @Then("The customer is alerted of account creation success")
    public void the_customer_is_alerted_of_account_creation_success() {
        String customerReg = TestRunner.driver.getTitle();
        Assert.assertEquals(customerReg, "ShoppingList Application");
    }

}
