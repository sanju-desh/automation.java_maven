package org.automation.resources;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.MutableCapabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.safari.SafariOptions;
import org.apache.logging.log4j.*;

import java.io.FileInputStream;
import java.io.IOException;
import java.net.URL;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class Base {

    private static Logger log = LogManager.getLogger(Listeners.class.getName());
    public WebDriver driver;

    private static String SAUCE_USER_ID;
    private static String SAUCE_ACCESS_KEY;
    private static String SAUCE_HUB;

    public String readProperty(String property) throws IOException {
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
        return properties.getProperty(property);
    }

    public WebDriver initializeDriver() throws Exception {
        String browserName = readProperty("browser");
        String remote = readProperty("remote");
        log.info("Browser Property selected: " + browserName);
        log.info("Driver Property selected: " + remote);
        if(remote.equals("Sauce")) {
            SAUCE_USER_ID = readProperty("SAUCE_USER_ID");
            SAUCE_ACCESS_KEY = readProperty("SAUCE_ACCESS_KEY");
            SAUCE_HUB = "https://"+SAUCE_USER_ID+":"+SAUCE_ACCESS_KEY+"@ondemand.us-west-1.saucelabs.com:443/wd/hub";
            MutableCapabilities sauceOptions = new MutableCapabilities();
            if(browserName.toLowerCase().contains("chrome")) {
                ChromeOptions browserOptions = new ChromeOptions();
                browserOptions.setExperimentalOption("w3c", true);
                browserOptions.setCapability("platformName", "macOS 10.15");
                browserOptions.setCapability("browserVersion", "80.0");
                browserOptions.setCapability("sauce:options", sauceOptions);
                driver = new RemoteWebDriver(new URL(SAUCE_HUB), browserOptions);
            } else if (browserName.toLowerCase().contains("firefox")){
                FirefoxOptions browserOptions = new FirefoxOptions();
                browserOptions.setCapability("platformName", "macOS 10.15");
                browserOptions.setCapability("browserVersion", "80.0");
                browserOptions.setCapability("sauce:options", sauceOptions);
                driver = new RemoteWebDriver(new URL(SAUCE_HUB), browserOptions);
            } else if (browserName.toLowerCase().contains("safari")){
                SafariOptions browserOptions = new SafariOptions();
                browserOptions.setCapability("platformName", "macOS 10.15");
                browserOptions.setCapability("browserVersion", "13.1");
                browserOptions.setCapability("sauce:options", sauceOptions);
                driver = new RemoteWebDriver(new URL(SAUCE_HUB), browserOptions);
            } else if (browserName.toLowerCase().contains("edge")){
                EdgeOptions browserOptions = new EdgeOptions();
                browserOptions.setCapability("platformName", "Windows 10");
                browserOptions.setCapability("browserVersion", "80.0");
                browserOptions.setCapability("sauce:options", sauceOptions);
                driver = new RemoteWebDriver(new URL(SAUCE_HUB), browserOptions);
            }
        } else {
            if(browserName.toLowerCase().contains("chrome")) {
                String driverPath = readProperty("chromedriver");
                System.setProperty("webdriver.chrome.driver", driverPath);
                driver = new ChromeDriver();
            } else if (browserName.toLowerCase().contains("firefox") || browserName.toLowerCase().contains("gecko")){
                String driverPath = readProperty("geckodriver");
                System.setProperty("webdriver.gecko.driver", driverPath);
                driver = new FirefoxDriver();
            } else if (browserName.toLowerCase().contains("safari")){
                driver = new SafariDriver();
            } else if (browserName.toLowerCase().contains("edge")){
                String driverPath = readProperty("edgedriver");
                System.setProperty("webdriver.edge.driver", driverPath);
                driver = new EdgeDriver();
            }
        }

        driver.get(readProperty("baseUrl"));
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        return driver;
    }
}
