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

import java.util.concurrent.TimeUnit;

/**
 *
 * @author PotapovGA
 */
public class HomeWork2 {
    private WebDriver driver;


    public void waitSendString(String target, String send, WebDriver driver)
    {
        WebElement dynamicElement = (new WebDriverWait(driver, 10))
            .until(ExpectedConditions.presenceOfElementLocated(By.name(target)));
        dynamicElement.sendKeys(send);
    }
    public void findClick(String target, WebDriver driver)
    {
        driver.findElement(By.name(target)).click();
    }
    public void waitClick (String target, WebDriver driver)

    {
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
public void homeWork2 ()
{
        driver.get("https://localhost/litecart/admin");
        driver.manage().window().maximize();
        waitSendString("username","admin",driver);
        waitSendString("password","admin",driver);
        findClick("login",driver);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
}

@After
public void stop()
{
    driver.quit();
    driver=null;
}
    
    
}
