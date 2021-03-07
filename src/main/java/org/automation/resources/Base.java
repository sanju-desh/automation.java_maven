package org.automation.resources;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class Base {
    //WebDriver driver;

    public void initializeDriver() throws IOException {
        Properties properties = new Properties();
        String propPath = "/src/main/java/org.automation/resources/prop.properties";
        FileInputStream fs = new FileInputStream("user.dir"+propPath);
        properties.load(fs);
        String driverPath = properties.getProperty("chromedriver");
        System.out.println(driverPath);
    }

}
