package org.automation.resources;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class Base {

    public WebDriver driver;
    public WebDriver initializeDriver() throws IOException {
        Properties properties = new Properties();
        String workspace = System.getProperty("user.dir");
        String propPath = workspace + "/src/main/java/org/automation/resources/prop.properties";
        FileInputStream fs = new FileInputStream(propPath);
        properties.load(fs);
        String driverPath = properties.getProperty("chromedriver");
        System.setProperty("webdriver.chrome.driver",driverPath);
        driver = new ChromeDriver();
        return driver;
    }

}
