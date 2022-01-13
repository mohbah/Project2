package runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import poms.*;

import java.io.File;
import java.util.concurrent.TimeUnit;

@RunWith(Cucumber.class)
@CucumberOptions(features = "classpath:features", glue = "steps")
public class TestRunner {
    public static WebDriver driver;
    public static LoginPage loginPage;
    public static ShopperLoginPage shopperLoginPage;
    public static ShopperRegisterPage shopperRegisterPage;
    public static CustomerRegister customerRegister;
    public static CustomerDashboardPage customerDashboardPage;
    public static  OrderCompleted orderCompleted;
    public static WebDriverWait explicitWait;
    public static IncompletedList incompletedList;

    @BeforeClass
    public static void setup(){
        File file = new File("src/test/resources/chromedriver.exe");
        System.setProperty("webdriver.chrome.driver", file.getAbsolutePath());
        driver = new ChromeDriver();
        loginPage = new LoginPage(driver);
        shopperLoginPage = new ShopperLoginPage(driver);
        shopperRegisterPage = new ShopperRegisterPage(driver);
        customerDashboardPage = new CustomerDashboardPage(driver);
        orderCompleted = new OrderCompleted(driver);
        customerRegister = new CustomerRegister(driver);

        System.out.println("The setup is completed");
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        // this determines the time of the implicit wait
        explicitWait = new WebDriverWait(driver, 5);
    }

    @AfterClass
    public static void teardown(){
        driver.quit();
        System.out.println("Teardown is completed");
    }

}
