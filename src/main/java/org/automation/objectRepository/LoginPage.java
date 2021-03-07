package org.automation.objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
    WebDriver driver;

    public void LoginPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    @FindBy(xpath = "//div[@class='content-box']/h1")
    WebElement pageHeader;

    @FindBy(css = "label[for='user_email']")
    WebElement emailLabel;

    @FindBy(css = "label[for='user_password']")
    WebElement passwordLabel;

    @FindBy(id = "user_email")
    WebElement emailTextbox;

    @FindBy(id = "user_password")
    WebElement passwordTextbox;

    @FindBy(name = "commit")
    WebElement loginButton;

    @FindBy(css = "a[href*='password']")
    WebElement forgotPasswordLink;

    @FindBy(css = "a[href*='sign_up']")
    WebElement createAccountLink;


    public WebElement getpageHeader(){
        return pageHeader;
    }

    public WebElement getEmailLabel(){
        return emailLabel;
    }

    public WebElement getEmailTextbox(){
        return emailTextbox;
    }

    public WebElement getPasswordLabel(){
        return passwordLabel;
    }

    public WebElement getPasswordTextbox(){
        return passwordTextbox;
    }

    public WebElement getLoginButton(){
        return loginButton;
    }

    public WebElement getForgotPasswordLink() {
        return forgotPasswordLink;
    }

    public WebElement getCreateAccountLink(){
        return createAccountLink;
    }
}
