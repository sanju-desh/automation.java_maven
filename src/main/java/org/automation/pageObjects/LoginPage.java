package org.automation.pageObjects;

import org.automation.objectRepository.LoginPageRepo;
import org.openqa.selenium.WebDriver;

public class LoginPage {
    WebDriver driver;
    LoginPageRepo loginPage;
    public LoginPage(WebDriver driver){
        this.driver = driver;
        this.loginPage = new LoginPageRepo(driver);
    }

    public String getLoginPageText(){
        return loginPage.getPageHeader().getText();
    }

    public String getEmailText(){
        return loginPage.getEmailLabel().getText();
    }

    public String getPasswordText(){
        return loginPage.getPasswordLabel().getText();
    }

    public String getLoginButtonText(){
        return loginPage.getLoginButton().getText();
    }

    public String getPasswordLinkText(){
        return loginPage.getForgotPasswordLink().getText();
    }

    public String getCreateAccountLinkText(){
        return loginPage.getCreateAccountLink().getText();
    }

    public void setEmail(String emailAddress){
        loginPage.getEmailTextbox().sendKeys(emailAddress);
    }

    public void setPassword(String password){
        loginPage.getPasswordTextbox().sendKeys(password);
    }

    public void clickLogin(){
        loginPage.getLoginButton().click();
    }

    public void clickForgotPassword(){
        loginPage.getForgotPasswordLink().click();
    }

    public void clickCreateAccount(){
        loginPage.getCreateAccountLink().click();
    }

}
