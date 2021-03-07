package org.automation.resources;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Locale;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class Base {
    public WebDriver driver;
    public WebDriver initializeDriver() throws IOException {
        Properties properties = new Properties();
        String os = System.getProperty("os.name");
        if(os.toLowerCase().contains("window")) {
            String workspace = System.getProperty("user.dir");
            String propPath = workspace + "\\src\\main\\java\\org\\automation\\resources\\prop.properties";
            FileInputStream fs = new FileInputStream(propPath);
            properties.load(fs);
        } else {
            String workspace = System.getProperty("user.dir");
            String propPath = workspace + "/src/main/java/org/automation/resources/prop.properties";
            FileInputStream fs = new FileInputStream(propPath);
            properties.load(fs);
        }

        String browserName = properties.getProperty("browser");
        if(browserName.toLowerCase().contains("chrome")) {
            String driverPath = properties.getProperty("chromedriver");
            System.setProperty("webdriver.chrome.driver", driverPath);
            driver = new ChromeDriver();
        } else if (browserName.toLowerCase().contains("firefox") || browserName.toLowerCase().contains("gecko")){
            String driverPath = properties.getProperty("geckodriver");
            System.setProperty("webdriver.gecko.driver", driverPath);
            driver = new FirefoxDriver();
        } else if (browserName.toLowerCase().contains("safari")){
            driver = new SafariDriver();
        } else if (browserName.toLowerCase().contains("edge")){
            String driverPath = properties.getProperty("edgedriver");
            System.setProperty("webdriver.edge.driver", driverPath);
            driver = new EdgeDriver();
        }
        driver.get(properties.getProperty("baseUrl"));
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        return driver;
    }
}
