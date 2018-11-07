package ru.glebpotapov.selenium.test;


import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import org.openqa.selenium.support.ui.ExpectedConditions;


/**
 *
 * @author PotapovGA
 */


public class HomeWork9 {
    private WebDriver driver;
    private WebDriverWait wait;
    private List<WebElement> checkbox;
    String path;
    private WebElement select;
    private String productName;
    public void waitSendString(String target, String send, WebDriver driver){
        WebElement dynamicElement = (new WebDriverWait(driver, 10))
                .until(ExpectedConditions.presenceOfElementLocated(By.name(target)));
        dynamicElement.sendKeys(send);
    }
    public void findClick(String target, WebDriver driver){
        driver.findElement(By.name(target)).click();
    }

@Before
public void init()
{
    System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
    driver=new ChromeDriver();
    wait = new WebDriverWait(driver, 20);
    checkbox = new ArrayList();
    path = new File("src/main/resources/image.jpg").getAbsolutePath();
    productName = "test_product";
}
@Test
public void homeWork9 () {

    driver.get("https://localhost/litecart/admin");
    driver.manage().window().maximize();
    waitSendString("username","admin",driver);
    waitSendString("password","admin",driver);
    findClick("login",driver);
    driver.findElement(By.cssSelector("li#app-:nth-child(2)")).click();
    driver.findElement(By.cssSelector("a.button:nth-child(2)")).click();
    driver.findElement(By.cssSelector("input[type='radio']")).click();
    driver.findElement(By.name("name[en]")).sendKeys(productName);
    driver.findElement(By.name("code")).sendKeys("757575");
    checkbox = driver.findElements(By.cssSelector("input[type='checkbox']"));
    checkbox.get(5).click();
    driver.findElement(By.name("quantity")).clear();
    driver.findElement(By.name("quantity")).sendKeys("100");
    driver.findElement(By.cssSelector("input[type='file']")).sendKeys(path);
    driver.findElement((By.name("date_valid_from"))).click();
    driver.findElement((By.name("date_valid_from"))).sendKeys("07112018");

    driver.findElement((By.name("date_valid_to"))).click();
    driver.findElement((By.name("date_valid_to"))).sendKeys("07112019");

    driver.findElement(By.cssSelector("ul.index li:nth-child(2)")).click();
    select = driver.findElement(By.name("manufacturer_id"));
    Select menu = new Select(select);
    menu.selectByIndex(1);
    driver.findElement((By.name("keywords"))).sendKeys("admin");
    driver.findElement((By.name("short_description[en]"))).sendKeys("admin");
    driver.findElement((By.name("head_title[en]"))).sendKeys("admin");
    driver.findElement((By.name("meta_description[en]"))).sendKeys("admin");
    driver.findElement(By.cssSelector("a[href='#tab-prices']")).click();
    driver.findElement(By.cssSelector("input[name='purchase_price']")).clear();
    driver.findElement(By.cssSelector("input[name='purchase_price']")).sendKeys("20,00");
    select = driver.findElement(By.name("purchase_price_currency_code"));
    menu = new Select(select);
    menu.selectByIndex(1);
    driver.findElement((By.name("prices[USD]"))).sendKeys("20,00");
    driver.findElement((By.name("gross_prices[USD]"))).sendKeys("20,00");
    driver.findElement((By.name("prices[EUR]"))).sendKeys("20,00");
    driver.findElement((By.name("gross_prices[EUR]"))).sendKeys("20,00");
    driver.findElement(By.cssSelector("button[name='save']")).click();

    List<WebElement> list = driver.findElements(By.xpath("//*[contains(text(),'" + productName + "')]"));
    Assert.assertEquals(list.size() > 0, true);

}

@After
public void stop()
{
    driver.quit();
    driver=null;
}
    
    
}
