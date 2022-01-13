package steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import runner.TestRunner;


public class CustomerLoginSteps {



    @Given("The customer is on the login page")
    public void the_customer_is_on_the_login_page() {
        //insert url from browser
        TestRunner.driver.get("file:///G:/Project2-_FrontEnd/Project2-%20FrontEnd/index.html");
    }
    @When("The customer enters username into username input box")
    public void the_customer_enters_username_into_username_input_box() {
        TestRunner.loginPage.inputUsername.sendKeys("saiyan");
    }
    @When("The customer enters password into password input box")
    public void the_customer_enters_password_into_password_input_box() {
        TestRunner.loginPage.inputPassword.sendKeys("super");
    }
    @When("The customer clicks the login button")
    public void the_customer_clicks_the_login_button() {
        TestRunner.loginPage.loginButton.click();
    }
    @Then("The customer is redirected to the Customer Dashboard")
    public void the_customer_is_redirected_to_the_customer_dashboard() {
        TestRunner.explicitWait.until(ExpectedConditions.titleIs("Customer Dashboard"));
        String title = TestRunner.driver.getTitle();
        Assert.assertEquals(title, "Customer Dashboard");

    }
}
