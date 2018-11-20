package ru.glebpotapov.selenium.test;


import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.logging.LogEntry;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.util.ArrayList;
import java.util.List;
import static org.openqa.selenium.support.ui.ExpectedConditions.titleIs;

/**
 *
 * @author PotapovGA
 */


public class HomeWork12 {
    private WebDriver driver;
    private WebDriverWait wait;
    private List<WebElement> goods;
    private List<String> tabs;
    private List<String> logs;
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
	logs = new ArrayList<>();
}
@Test
public void homeWork12 () {

    driver.get("https://localhost/litecart/admin");
    driver.manage().window().maximize();
    waitSendString("username","admin",driver);
    waitSendString("password","admin",driver);
    findClick("login",driver);
    wait.until(titleIs("My Store"));
driver.get("http://localhost/litecart/admin/?app=catalog&doc=catalog&category_id=1");
        goods = driver.findElements(By.xpath("//tr//td[not(@id)][3]/a"));
        for (WebElement element:goods) {
            ((JavascriptExecutor) driver).executeScript("window.open('" + element.getAttribute("href") + "', 'new_window')");
            for (LogEntry l : driver.manage().logs().get("browser").getAll()) {
                logs.add(l.toString()+"\n");
            }
            driver.switchTo().window("new_window");
            tabs = new ArrayList<>(driver.getWindowHandles());
            driver.close();
            driver.switchTo().window(tabs.get(0));
        }
        Assert.assertEquals(0,logs.size());
}

@After
public void stop()
{
    driver.quit();
    driver=null;
}
    
    
}
