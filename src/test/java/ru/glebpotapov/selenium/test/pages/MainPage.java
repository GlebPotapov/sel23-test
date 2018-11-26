package ru.glebpotapov.selenium.test.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


public class MainPage extends Page {

    public MainPage (WebDriver driver) {super(driver);}
    public void open () {driver.get("http://localhost/litecart/en/");}
    public WebElement firstMostPopularGood () {return driver.findElement(By.cssSelector("#box-most-popular > div > ul > li:nth-child(1)"));}

}