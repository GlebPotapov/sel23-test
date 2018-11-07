package ru.glebpotapov.selenium.test;


import org.junit.Before;
import org.junit.Test;
import org.junit.After;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import java.lang.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.junit.Assert;


/**
 *
 * @author PotapovGA
 */


public class HomeWork8 {

    private WebDriver driver;
    private Actions builder;
    private Select selectCountry;
    private Select selectZone;
    String firstName = "Ivan";
    String lastName = "Ivanov";
    String address = "8986 Cadillac Ave";
    String postcode = "10017";
    String city = "New York";
    String email = DateStamp.now() + "@gmail.com";
    String phone = "+155123455";
    String pass = "qwerty123";
    WebElement noticeSuccess;

@Before
public void init()
{
    System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
    driver=new ChromeDriver();
    builder = new Actions(driver);
}
@Test
public void homeWork8 () throws InterruptedException{

    driver.get("http://localhost/litecart/en/");
    driver.manage().window().maximize();
    driver.findElement(By.cssSelector("form[name='login_form'] table tr:nth-child(5) a")).click();
    WebElement countrySlct = driver.findElement(By.cssSelector("select:nth-child(3)"));
    selectCountry = new Select(countrySlct);
    selectCountry.selectByVisibleText("United States");
    driver.findElement(By.cssSelector("td input[name='firstname']")).sendKeys(firstName);
    driver.findElement(By.cssSelector("td input[name='lastname']")).sendKeys(lastName);
    driver.findElement(By.cssSelector("td input[name='address1']")).sendKeys(address);
    driver.findElement(By.cssSelector("td input[name='postcode']")).sendKeys(postcode);
    driver.findElement(By.cssSelector("td input[name='city']")).sendKeys(city);
    driver.findElement(By.cssSelector("td input[name='email']")).sendKeys(email);
    driver.findElement(By.cssSelector("td input[name='phone']")).sendKeys(phone);
    driver.findElement(By.cssSelector("td input[name='password']")).sendKeys(pass);
    driver.findElement(By.cssSelector("td input[name='confirmed_password']")).sendKeys(pass);
    WebElement zoneSlct = driver.findElement(By.cssSelector("select[name*='zone']"));
    selectZone = new Select(zoneSlct);
    builder
            .click(zoneSlct)
            .sendKeys("New York")
            .sendKeys(Keys.ENTER)
            .perform();
    selectZone.selectByVisibleText("New York");
    driver.findElement(By.cssSelector("button[type='submit']")).click();
    driver.findElement(By.xpath("//*[contains(text(), 'Logout')]")).click();
    driver.findElement(By.cssSelector("input[name='email']")).sendKeys(email);
    driver.findElement(By.cssSelector("input[name='password']")).sendKeys(pass);
    driver.findElement(By.cssSelector("input[name='password']")).click();
    driver.findElement(By.cssSelector("table button[name='login']")).click();
    noticeSuccess = driver.findElement(By.cssSelector("div[class ='notice success']"));
    Assert.assertEquals(noticeSuccess.isDisplayed(), true);

}

@After
public void stop()
{
    driver.quit();
    driver=null;
}
    
    
}
