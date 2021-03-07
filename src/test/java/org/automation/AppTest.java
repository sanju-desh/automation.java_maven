package org.automation;

import static org.junit.Assert.assertTrue;

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
        driver.get("https://google.com");
        Thread.sleep(3000);
        driver.close();
    }
}
