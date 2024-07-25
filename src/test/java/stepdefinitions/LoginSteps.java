package stepdefinitions;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.chrome.ChromeOptions;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class LoginSteps {
    private WebDriver driver;
    @Before
    public void initializeDriver() {
        System.setProperty("webdriver.chrome.driver", "E://dev//chromedriver-win64//chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        driver = new ChromeDriver(options);
    }
    @Given("I am on the Sample App login page")
    public void i_am_on_the_sample_app_login_page() {
        driver.get("https://uitestingplayground.com/sampleapp");
    }
    @And("I fill in the User Name as {string}")
    public void i_fill_in_the_user_name_as(String userName) throws InterruptedException {
        Thread.sleep(2000);
        driver.findElement(By.name("UserName")).sendKeys(userName);
    }
    @And("I fill in the Password as {string}")
    public void i_fill_in_the_password_as(String password) throws InterruptedException {
        Thread.sleep(2000);
        driver.findElement(By.name("Password")).sendKeys(password);
    }
    @When("I click on the Log In button")
    public void i_click_on_the_log_in_button() throws InterruptedException {
        Thread.sleep(2000);
        driver.findElement(By.id("login")).click();
    }
    @Then("I see the message {string}")
    public void i_see_the_message(String message) throws InterruptedException {
        Thread.sleep(2000);
        assertEquals(driver.findElement(By.id("loginstatus")).getText(), (message));
    }
    @After
    public void closeBrowser() throws InterruptedException {
        Thread.sleep(2000);
        driver.quit();
    }
}