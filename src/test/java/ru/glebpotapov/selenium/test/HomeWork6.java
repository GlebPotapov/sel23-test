package ru.glebpotapov.selenium.test;


import org.junit.Before;
import org.junit.Test;
import org.junit.After;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.util.List;
import java.util.ArrayList;
import static org.junit.Assert.assertEquals;
import java.util.*;
import java.lang.*;
import java.io.*;


/**
 *
 * @author PotapovGA
 */
public class HomeWork6 {
    private WebDriver driver;
    private List<String> sortZoneList;
    private List<String> unsortZoneList;

    public void waitSendString(String target, String send, WebDriver driver){
        WebElement dynamicElement = (new WebDriverWait(driver, 10))
            .until(ExpectedConditions.presenceOfElementLocated(By.name(target)));
        dynamicElement.sendKeys(send);
    }
    public void findClick(String target, WebDriver driver){
        driver.findElement(By.name(target)).click();
    }
    public void waitClick (String target, WebDriver driver){
        WebElement dynamicElement = (new WebDriverWait(driver, 10))
                .until(ExpectedConditions.presenceOfElementLocated(By.name(target)));
        dynamicElement.click();

    }


@Before 
public void init()
{
    System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
    driver=new ChromeDriver();
    unsortZoneList = new ArrayList();
}

@Test
public void homeWork6 () {

    driver.get("http://localhost/litecart/admin/?app=geo_zones&doc=geo_zones");
    driver.manage().window().maximize();
    waitSendString("username","admin",driver);
    waitSendString("password","admin",driver);
    findClick("login",driver);

    List<WebElement> zoneList;
    List<WebElement> geoZoneList = driver.findElements(By.cssSelector("tr[class*=row]"));
    for (int i=0; i< geoZoneList.size(); i++) {

        driver.findElement(By.cssSelector("#content > form > table > tbody > tr:nth-child(" + String.valueOf(i+2) + ") > td:nth-child(3) > a")).click();
        zoneList = driver.findElements(By.cssSelector("tr td:nth-child(3) option[selected='selected']"));
            for (int j = 1; j < zoneList.size(); j = j + 2) {
                if (zoneList.get(j).isDisplayed()) {
                    unsortZoneList.add(zoneList.get(j).getText());
                }
            }
            sortZoneList = new ArrayList<>(unsortZoneList);
            Collections.sort(sortZoneList);
            assertEquals(sortZoneList, unsortZoneList);
            unsortZoneList.clear();
            sortZoneList.clear();
            driver.navigate().back();
        }

    }



@After
public void stop()
{
    driver.quit();
    driver=null;
}
    
    
}
