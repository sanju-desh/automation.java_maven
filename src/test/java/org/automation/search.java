package org.automation;

import org.automation.pageObjects.AllObjects;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.*;

public class search {

    @Test
    public void googleSearch() throws IOException {
        WebDriver driver;
        AllObjects allObjects = new AllObjects();
        driver = allObjects.getDriver();
        driver.get("https://google.com");
        ArrayList<String> ele = new ArrayList<>();
        ele.add("input");
        ele.add("a");
        for(int i = 0; i < ele.size(); i++) {
            HashMap<String, String> elements = getElementsList(driver, ele.get(i));
            Set s1 = elements.entrySet();
            Iterator it = s1.iterator();
            while(it.hasNext()) {
                Map.Entry m = (Map.Entry) it.next();
                System.out.println(m.getKey()+" : "+m.getValue());
            }
        }
        allObjects.closeDriver();
    }

    public static HashMap<String, String> getElementsList(WebDriver driver, String item) {
        List<WebElement> el = driver.findElements(By.cssSelector(item));
        HashMap<String, String> object = new HashMap<>();
        for ( WebElement e : el ) {
            if(!e.getAttribute("name").equals(""))
                object.put(e.getAttribute("name"), e.getTagName()+"[name="+e.getAttribute("name")+"]");
            else if(!e.getAttribute("href").equals("")) {
                String[] parts = e.getAttribute("href").split("/");
                String part = parts[3].split("\\?")[0];
                object.put(part, e.getTagName()+"[href*="+part+"]");
            }
        }
        return object;
    }
}
