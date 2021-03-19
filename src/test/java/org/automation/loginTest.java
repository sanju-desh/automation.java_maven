package org.automation;

import org.automation.pageObjects.AllObjects;
import org.automation.resources.Base;
import org.openqa.selenium.NoSuchElementException;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.time.LocalDate;

public class loginTest extends Base {
    @Parameters({"email","password"})
    @Test
    public void test(String email, String password) throws Exception {
        try {
            AllObjects  allObjects = new AllObjects();
            allObjects.homePage.clickLogin();
            allObjects.loginPage.setEmail(email);
            allObjects.loginPage.setPassword(password);
            allObjects.loginPage.clickLogin();
            allObjects.homePage.clickLogin();
            String str = allObjects.loginPage.getLoginPageText();
            Assert.assertTrue(str.contains("Academy"));
            allObjects.closeDriver();
        } catch (NoSuchElementException e){
            System.out.println("Exception 1");;
        } catch (Exception e) {
            System.out.println("Exception 2");
        }
    }

    @Test
    public void test2() throws Exception {
        try {
            AllObjects allObjects = new AllObjects();
            allObjects.homePage.clickLogin();
            String str = allObjects.loginPage.getLoginPageText();
            Assert.assertTrue(str.contains("Academy"));
            allObjects.closeDriver();
        } catch (Exception e) {
            throw new Exception(e);
        }
    }

    @Test
    public static void findDay() {
        LocalDate date = LocalDate.of(2021, 03, 10);
        System.out.println(date.getDayOfWeek());
    }
}
