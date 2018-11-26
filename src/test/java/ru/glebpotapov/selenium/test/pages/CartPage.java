package ru.glebpotapov.selenium.test.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import java.util.List;


public class CartPage extends Page {

    public CartPage (WebDriver driver) { super(driver); }
    public WebElement cart_btn () { return driver.findElement(By.cssSelector("#cart")); }
    public WebElement goodInCart () {
        return driver.findElement(By.cssSelector("table.dataTable.rounded-corners tr:nth-child(2)")); }
    public WebElement removeFromCart_btn () { return driver.findElement(By.name("remove_cart_item")); }
    public List<WebElement> listOfGoodsInCart () {
        return driver.findElements(By.cssSelector("table.dataTable.rounded-corners tr")); }
    public String allRemoved_msg () { return driver.findElement(By.cssSelector("em")).getText(); }
}