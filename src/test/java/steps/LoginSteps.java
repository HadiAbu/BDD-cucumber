package steps;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import io.cucumber.java.AfterAll;
import io.cucumber.java.en.*;

public class LoginSteps {
    public static WebDriver driver;

    @Given("the user is on the login page")
    public void the_user_is_on_the_login_page() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login"); // Replace with your login URL
    }

    @When("the user enters valid username and password")
    public void the_user_enters_a_valid_username_and_password() {
        driver.findElement(By.name("username")).sendKeys("Admin");
        driver.findElement(By.name("password")).sendKeys("admin123");
    }

    @When("clicks the login button")
    public void the_user_clicks_the_login_button() {
        driver.findElement(By.cssSelector("button[type='submit']")).click();
    }

    @Then("the user should be redirected to the dashboard")
    public void the_user_should_be_redirected_to_the_dashboard() {
        String expectedUrl = "https://opensource-demo.orangehrmlive.com/web/index.php/dashboard/index";
        Assert.assertEquals(driver.getCurrentUrl(), expectedUrl, "User was not redirected to the dashboard");
        driver.quit();
    }
    @AfterAll
    public static void tearDown() {
        // Code to close the browser after all tests
        // This method can be left empty if each scenario handles its own browser instance
        if(driver != null){
            driver.quit();
        }
    }
}