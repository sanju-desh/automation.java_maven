package org.automation.pageObjects;

import org.openqa.selenium.WebDriver;
import org.automation.objectRepository.HomePageRepo;

public class HomePage {
    WebDriver driver;
    HomePageRepo homePage;
    public HomePage(WebDriver driver){
        this.driver = driver;
        this.homePage = new HomePageRepo(driver);
    }

    public void clickLogin(){
        homePage.getLogin().click();
    }
}
