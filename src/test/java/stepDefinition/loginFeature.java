package stepDefinition;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.automation.pageObjects.AllObjects;
import org.automation.resources.Base;
import org.testng.Assert;

public class loginFeature extends Base {
    private static AllObjects allObjects;

    @Given("^Launch the web application in browser$")
    public void launch_the_web_application_in_browse() throws Exception {
        allObjects = new AllObjects();
        allObjects.homePage.clickLogin();
    }

    @When("^Enter (.+) and (.+)$")
    public void enter_username_and_password(String UserName, String Password) throws Throwable {
        allObjects.loginPage.setEmail(UserName);
        allObjects.loginPage.setPassword(Password);
    }

    @When("^Click login button$")
    public void click_login_button() throws Throwable {
        allObjects.loginPage.clickLogin();
    }

    @Then("^Home page should be displayed$")
    public void home_page_should_be_displayed() throws Throwable {
        String str = allObjects.loginPage.getLoginPageText();
        Assert.assertTrue(str.contains("Academy"));
    }

    @Then("^username should be displayed$")
    public void username_should_be_displayed() throws Throwable {
        allObjects.closeDriver();
    }
}
