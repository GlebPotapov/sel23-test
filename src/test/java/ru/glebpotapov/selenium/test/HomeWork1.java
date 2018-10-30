package ru.glebpotapov.selenium.test;


import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

/**
 *
 * @author PotapovGA
 */
public class HomeWork1 {
    private WebDriver driver;




    public void waitSendString(String target, String send, WebDriver driver)
    {
        WebElement dynamicElement = (new WebDriverWait(driver, 10))
            .until(ExpectedConditions.presenceOfElementLocated(By.id(target)));
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
    //System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
    //driver=new ChromeDriver();
    driver=new InternetExplorerDriver();
}

@Test
public void homeWork1 ()
{

        driver.get("https://ya.ru/");
        driver.manage().window().maximize();
        waitSendString("text","Selenium webdriver",driver);
        driver.findElement(By.xpath("//*[@id=\"text\"]")).sendKeys(Keys.RETURN);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
}

@After
public void stop()
{
    driver.quit();
    driver=null;
}
    
    
}
