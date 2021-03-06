package org.automation.pageObjects;

import org.automation.resources.Base;
import org.openqa.selenium.WebDriver;

public class AllObjects extends Base {

    public WebDriver driver;
    public HomePage homePage;
    public LoginPage loginPage;

    public AllObjects() throws Exception {
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
