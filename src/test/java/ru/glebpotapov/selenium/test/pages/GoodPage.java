package ru.glebpotapov.selenium.test.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import java.util.List;


public class GoodPage extends Page {

    public GoodPage (WebDriver driver) {super(driver);}
    public WebElement addToCart_btn () { return driver.findElement(By.name("add_cart_product"));}
    public List<WebElement> options () { return driver.findElements(By.name("options[Size]")); }
    public WebElement list () { return driver.findElement(By.name("options[Size]"));}
    public By goodsInCart () {return By.cssSelector("#cart > a.content > span.quantity");}

}