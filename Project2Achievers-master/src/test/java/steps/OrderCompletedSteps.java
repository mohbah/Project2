package steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import runner.TestRunner;

public class OrderCompletedSteps {
    @Given("A Shopper is now on the current order page.")
    public void a_shopper_is_now_on_the_current_order_page() {
        TestRunner.driver.get("file:///G:/Project2-_FrontEnd/Project2-%20FrontEnd/Shopper-on-the-list.html");
    }
    @When("The Shopper clicks on the Select List Button.")
    public void the_shopper_clicks_on_the_select_list_button() {
        TestRunner.explicitWait.until(ExpectedConditions.elementToBeClickable(TestRunner.orderCompleted.selectsButton));
        TestRunner.orderCompleted.selectsButton.click();
        TestRunner.driver.switchTo().alert().accept();
    }
    @When("The Shopper clicks on the back button")
    public void the_shopper_clicks_on_the_back_button() {
        TestRunner.explicitWait.until(ExpectedConditions.elementToBeClickable(TestRunner.orderCompleted.goBackButton));
        TestRunner.orderCompleted.goBackButton.click();
    }
    @When("The Shopper clicks on the complete button.")
    public void the_shopper_clicks_on_the_complete_button() {
        TestRunner.explicitWait.until(ExpectedConditions.elementToBeClickable(TestRunner.orderCompleted.deliveredButton));
        TestRunner.orderCompleted.deliveredButton.click();
    }
    @Then("The order should be complete.")
    public void the_order_should_be_complete() {
        TestRunner.explicitWait.until(ExpectedConditions.titleIs("Shopper Dashboard"));
        String title = TestRunner.driver.getTitle();
        Assert.assertEquals(title,"Shopper Dashboard");
    }
}
