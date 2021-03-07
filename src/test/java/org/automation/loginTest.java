package org.automation;

import org.automation.pageObjects.AllObjects;
import org.automation.resources.Base;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.io.IOException;

public class loginTest extends Base {
    WebDriver driver;

    @BeforeTest
    public void startDriver() throws IOException {
        driver = initializeDriver();
    }

    @Parameters({"email","password"})
    @Test
    public void test(String email, String password) throws Exception {
        try {
            AllObjects allObjects = new AllObjects(driver);
            allObjects.homePage.clickLogin();
            allObjects.loginPage.setEmail(email);
            allObjects.loginPage.setPassword(password);
            allObjects.loginPage.clickLogin();
        } catch (Exception e){
            throw new Exception(e);
        } finally {
            driver.close();
        }
    }
}
