package steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
import runner.TestRunner;

public class CompletedListSteps {
    @Given("A Customer is on the Customer Dashboard Page.")
    public void a_customer_is_on_the_customer_dashboard_page() {
        TestRunner.driver.get("file:///G:/Project2-_FrontEnd/Project2-%20FrontEnd/Customer-Dashboard.html");
    }
    @When("The Customer clicks on the Completed Lists button.")
    public void the_customer_clicks_on_the_completed_lists_button() {
        TestRunner.customerDashboardPage.completedList.click();
    }
    @Then("The Customer should be able to view his completed lists.")
    public void the_customer_should_be_able_to_view_his_completed_lists() {
        String title = TestRunner.driver.getTitle();
        Assert.assertEquals(title, "Customer Dashboard");
    }
}
