package com.stepDefinition;

import io.cucumber.java.en.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class LoginSteps {

    WebDriver driver;

    @Given("the user is on the login page")
    public void the_user_is_on_the_login_page() {
        driver = new ChromeDriver();
        driver.get("https://example.com/login"); // Replace with your login URL
    }

    @When("the user enters a valid username and password")
    public void the_user_enters_a_valid_username_and_password() {
        driver.findElement(By.id("username")).sendKeys("testuser");
        driver.findElement(By.id("password")).sendKeys("password123");
    }

    @When("the user clicks the login button")
    public void the_user_clicks_the_login_button() {
        driver.findElement(By.id("loginButton")).click();
    }

    @Then("the user should be redirected to the dashboard")
    public void the_user_should_be_redirected_to_the_dashboard() {
        String expectedUrl = "https://example.com/dashboard";
        Assert.assertEquals(driver.getCurrentUrl(), expectedUrl, "User was not redirected to the dashboard");
        driver.quit();
    }
}
