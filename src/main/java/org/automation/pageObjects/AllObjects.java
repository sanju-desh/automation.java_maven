package org.automation.pageObjects;

import org.automation.resources.Base;
import org.openqa.selenium.WebDriver;

import java.io.IOException;

public class AllObjects extends Base {

    public WebDriver driver;
    public HomePage homePage;
    public LoginPage loginPage;

    public AllObjects() throws IOException {
        this.driver = initializeDriver();
        this.homePage = new HomePage(driver);
        this.loginPage = new LoginPage(driver);
    }

    public WebDriver getDriver() {
        return driver;
    }

    public void closeDriver(){
        driver.close();
    }
}
