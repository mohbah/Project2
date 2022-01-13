package steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
import runner.TestRunner;

public class DeclineOrdersSteps {
    @Given("The Shopper is on the Current Shopping List Page.")
    public void the_shopper_is_on_the_current_shopping_list_page() {
        TestRunner.driver.get("file:///G:/Project2-_FrontEnd/Project2-%20FrontEnd/Shopper-Dashboard.html");
    }
    @When("The Shopper clicks on the view button")
    public void the_shopper_clicks_on_the_view_button() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }
    @When("The Shopper clicks on the Decline Button.")
    public void the_shopper_clicks_on_the_decline_button() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }
    @Then("The Shopper should be redirected to the Shopper Dashboard Page.")
    public void the_shopper_should_be_redirected_to_the_shopper_dashboard_page() {
        String title = TestRunner.driver.getTitle();
        Assert.assertEquals(title, "Shopper Dashboard");
    }
}
