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
import static org.junit.Assert.assertEquals;


/**
 *
 * @author PotapovGA
 */
public class HomeWork4 {
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
public void homeWork4 ()
{       driver.get("https://localhost/litecart");
        driver.manage().window().maximize();
        List<WebElement> list;
        List<WebElement>  stickers;
        list = driver.findElements(By.cssSelector("li[class*=product]"));
    for (WebElement element:list) {
        stickers = element.findElements((By.cssSelector("div[class*=sticker]")));
        assertEquals("Product №"+(list.indexOf(element)+1)+" without sticker",1, stickers.size());
        System.out.println("Product № "+(list.indexOf(element)+1)+" with sticker");

    }

}

@After
public void stop()
{
    driver.quit();
    driver=null;
}
    
    
}
