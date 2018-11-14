package ru.glebpotapov.selenium.test;


import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.util.ArrayList;
import java.util.List;
import static org.openqa.selenium.support.ui.ExpectedConditions.titleIs;


/**
 *
 * @author PotapovGA
 */


public class HomeWork11 {
    private WebDriver driver;
    private WebDriverWait wait;
    private List<WebElement> arrows;
    private String mainwindow;
    private ArrayList<String> availableWindows;
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
    wait = new WebDriverWait(driver, 20);
}
@Test
public void homeWork11 () {

    driver.get("https://localhost/litecart/admin");
    driver.manage().window().maximize();
    waitSendString("username","admin",driver);
    waitSendString("password","admin",driver);
    findClick("login",driver);
    wait.until(titleIs("My Store"));
    driver.findElement(By.cssSelector("ul#box-apps-menu li:nth-child(3)")).click();
    driver.findElement(By.cssSelector("a.button")).click();
    mainwindow = driver.getWindowHandle();
    arrows = driver.findElements(By.xpath("//i[contains(@class, 'fa fa-external-link')]/parent::*"));
    for (WebElement element:arrows) {
        element.click();
        availableWindows = new ArrayList<String>(driver.getWindowHandles());
        if (!availableWindows.isEmpty()) {
            driver.switchTo().window(availableWindows.get(1));
        }
        ((JavascriptExecutor) driver).executeScript("window.close()");
        driver.switchTo().window(mainwindow);
    }
}

@After
public void stop()
{
    driver.quit();
    driver=null;
}
    
    
}
