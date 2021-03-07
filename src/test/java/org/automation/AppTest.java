package org.automation;

import static org.junit.Assert.assertTrue;

import org.automation.pageObjects.HomePage;
import org.automation.resources.Base;
import org.junit.Test;
import org.openqa.selenium.WebDriver;

import java.io.IOException;

/**
 * Unit test for simple App.
 */
public class AppTest extends Base
{
    /**
     * Rigorous Test :-)
     */
    @Test
    public void shouldAnswerWithTrue()
    {
        assertTrue( true );
    }

    @Test
    public void test() throws IOException, InterruptedException {
        WebDriver driver = initializeDriver();
        HomePage homePage = new HomePage(driver);
        homePage.clickLogin();
        Thread.sleep(5000);
        driver.close();
    }
}
