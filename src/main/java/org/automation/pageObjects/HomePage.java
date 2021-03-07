package org.automation.pageObjects;

import org.openqa.selenium.WebDriver;
import org.automation.objectRepository.HomePageRepo;

public class HomePage {
    WebDriver driver;
    public HomePage(WebDriver driver){
        this.driver = driver;
    }
    HomePageRepo homePage = new HomePageRepo(driver);

    public void clickLogin(){
        homePage.getLogin().click();
    }
}
