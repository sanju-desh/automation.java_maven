package org.automation;

import org.automation.pageObjects.HomePage;
import org.automation.pageObjects.LoginPage;
import org.automation.resources.Base;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class loginTest extends Base {
    @Parameters({"email","password"})
    @Test
    public void test(String email, String password) throws Exception {
        try {
            WebDriver driver = initializeDriver();
            HomePage homePage = new HomePage(driver);
            LoginPage loginPage = new LoginPage(driver);
            homePage.clickLogin();
            loginPage.setEmail(email);
            loginPage.setPassword(password);
            loginPage.clickLogin();
        } catch (Exception e){
            throw new Exception(e);
        } finally {
            driver.close();
        }
    }
}
