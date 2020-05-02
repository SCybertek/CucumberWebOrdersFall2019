package com.weborders.step_definitions;

import com.weborders.pages.LoginPage;
import com.weborders.utilities.BrowserUtilities;
import com.weborders.utilities.ConfigurationReader;
import com.weborders.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

import io.cucumber.java.en.When;
import org.junit.Assert;

public class LoginStepDefinitions {

    LoginPage login = new LoginPage();

    @Given("user is on the login page")
    public void user_is_on_the_login_page() {
        System.out.println("Open login page");
        String url = ConfigurationReader.getProperty("url");
        Driver.getDriver().get(url);
    }

    @Given("user logs in")
    public void user_logs_in() {
        System.out.println("Login using credentials");
        login.login();
    }

    @When("user navigates to {string} page")
    public void user_navigates_to_page(String string) {
        login.navigateTo(string);
        System.out.println("Navigate to :: " + string);
    }


    @Then("user should verify that title is a Dashboard")
    public void user_should_verify_that_title_is_a_Dashboard() {
        System.out.println("Verify that subtitle is Web Orders");
        BrowserUtilities.waitForPageToLoad(10);
        Assert.assertEquals("Web Orders", login.getSubtitle());
    }
}
