package org.automation.objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePageRepo {
    WebDriver driver;

    public HomePageRepo(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    @FindBy(css = "a[href*='sign_in']")
    WebElement login;

    /**
     * This method returns the login button WebElement
     * @return {WebElement} login button
     */
    public WebElement getLogin(){
        return login;
    }
}
