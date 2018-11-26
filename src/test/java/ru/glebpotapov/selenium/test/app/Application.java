package ru.glebpotapov.selenium.test.app;

import org.junit.Assert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;
import static org.openqa.selenium.support.ui.ExpectedConditions.titleIs;

//Import from my packages:
import ru.glebpotapov.selenium.test.pages.CartPage;
import ru.glebpotapov.selenium.test.pages.GoodPage;
import ru.glebpotapov.selenium.test.pages.MainPage;


public class Application {

    private WebDriver driverc;
    private WebDriverWait wait;
    private WebElement list;
    private Select size;
    private WebElement quantity;
    private WebElement good;
    private MainPage mainPage;
    private GoodPage goodPage;
    private CartPage cartPage;

    public Application() {
        driverc = new ChromeDriver();
        wait = new WebDriverWait(driverc, 10);
        mainPage = new MainPage(driverc);
        goodPage = new GoodPage(driverc);
        cartPage = new CartPage(driverc);
    }
    public void quit() {driverc.quit(); driverc = null;}

    public void openMainPage() {
        mainPage.open();
    }

    public void addGoodsToCart(int quantity) {
        for (int i = 1; i < quantity+1; i++) {
            mainPage.firstMostPopularGood().click();
            if (goodPage.options().size() != 0) {
                list = goodPage.list();
                size = new Select(list);
                List<WebElement> l = size.getOptions();
                int randomIndex = ThreadLocalRandom.current().nextInt(1, l.size()) ;
                size.selectByIndex(randomIndex);
            }
            goodPage.addToCart_btn().click();
            wait.until(ExpectedConditions.textToBe(goodPage.goodsInCart(), String.valueOf(i)));
            ((JavascriptExecutor) driverc).executeScript("window.history.go(-1)");
            wait.until(titleIs("Online Store | My Store"));
        }
    }

    public void goToCart () { cartPage.cart_btn().click();}

    public void deleteAllGoodsFromCart() {
        do {
            cartPage.removeFromCart_btn().click();
            wait.until(ExpectedConditions.stalenessOf(cartPage.goodInCart()));
        }
        while (cartPage.listOfGoodsInCart().size() > 0);
    }

    public void checkCartIsEmpty() {
        Assert.assertEquals("There are no items in your cart.", cartPage.allRemoved_msg());
    }
}