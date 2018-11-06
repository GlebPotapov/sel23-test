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
public class HomeWork5 {
    private WebDriver driver;


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
}

@Test
public void homeWork5 () {

    driver.get("http://localhost/litecart/admin/?app=countries&doc=countries");
    driver.manage().window().maximize();
    waitSendString("username","admin",driver);
    waitSendString("password","admin",driver);
    findClick("login",driver);

    List<WebElement> countryList = driver.findElements(By.cssSelector("tr[class*=row]"));
    String [] unsortCountryList = new String[countryList.size()];

    for (int i=0; i< countryList.size(); i++) {
String flag =driver.findElement(By.cssSelector("#content > form > table > tbody > tr:nth-child(" + String.valueOf(i + 2) + ") > td:nth-child(6)")).getText();
        if(!flag.equals("0"))
        {
            driver.findElement(By.cssSelector("#content > form > table > tbody > tr:nth-child(" + String.valueOf(i+2) + ") > td:nth-child(5) > a")).click();
            List<WebElement> zoneList=driver.findElements(By.cssSelector("#table-zones > tbody > tr"));
            String [] unsortZoneList = new String[zoneList.size()-2];
            for(int j=0; j< zoneList.size()-2; j++){
                unsortZoneList[j] = driver.findElement(By.cssSelector("#table-zones > tbody > tr:nth-child("+ String.valueOf(j+2) +") > td:nth-child(3)")).getText();
            }
            String [] sortZoneList;
            sortZoneList = Arrays.copyOf(unsortZoneList,unsortZoneList.length);
            Arrays.sort(sortZoneList);
            assertEquals((Arrays.equals(sortZoneList,unsortZoneList)),true);
            driver.navigate().back();
        }
        unsortCountryList[i]=driver.findElement(By.cssSelector("#content > form > table > tbody > tr:nth-child(" + String.valueOf(i+2) + ") > td:nth-child(5)")).getText();
    }
    String [] sortCountryList = Arrays.copyOf(unsortCountryList,unsortCountryList.length);
    Arrays.sort(sortCountryList);
    assertEquals((Arrays.equals(sortCountryList,unsortCountryList)),true);

}

@After
public void stop()
{
    driver.quit();
    driver=null;
}
    
    
}
