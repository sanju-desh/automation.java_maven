package org.automation.pageObjects;

import org.openqa.selenium.WebDriver;

public class AllObjects {

    public HomePage homePage;
    public LoginPage loginPage;

    public AllObjects(WebDriver driver) {
        this.homePage = new HomePage(driver);
        this.loginPage = new LoginPage(driver);
    }

}
