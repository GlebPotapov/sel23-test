package ru.glebpotapov.selenium.test;


import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import static org.openqa.selenium.support.ui.ExpectedConditions.titleIs;


/**
 *
 * @author PotapovGA
 */


public class HomeWork10 {
    private WebDriver driver;
    private WebDriverWait wait;
    private WebElement list;
    private Select size;
    private WebElement quantity;
    private WebElement good;

@Before
public void init()
{
    System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
    driver=new ChromeDriver();
    wait = new WebDriverWait(driver, 20);
}
@Test
public void homeWork10 () {

    driver.get("http://localhost/litecart/en/");
    driver.manage().window().maximize();
    for (int i = 1; i < 4; i++) {
        driver.findElement(By.cssSelector("#box-most-popular > div > ul > li:nth-child(1)"))
                .click();
        if (driver.findElements(By.name("options[Size]")).size() != 0){
            list = driver.findElement(By.name("options[Size]"));
            size = new Select(list);
            size.selectByIndex(i);}
        driver.findElement(By.name("add_cart_product")).click();
        quantity = driver.findElement(By.cssSelector("#cart > a.content > span.quantity"));
        wait.until(ExpectedConditions.textToBe(By.cssSelector("#cart > a.content > span.quantity"), String.valueOf(i)));
        ((JavascriptExecutor) driver).executeScript("window.history.go(-1)");
        wait.until(titleIs("Online Store | My Store"));}
    driver.findElement(By.cssSelector("#cart")).click();
    do {
        good = driver.findElement(By.cssSelector("table.dataTable.rounded-corners tr:nth-child(2)"));
        driver.findElement(By.name("remove_cart_item")).click();
        wait.until(ExpectedConditions.stalenessOf(good));
    }
    while (driver.findElements(By.cssSelector("table.dataTable.rounded-corners tr")).size() > 0);
    Assert.assertEquals("There are no items in your cart.", driver.findElement(By.cssSelector("em")).getText());

}

@After
public void stop()
{
    driver.quit();
    driver=null;
}
    
    
}
