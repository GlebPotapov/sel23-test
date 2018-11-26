package ru.glebpotapov.selenium.test.tests;

import org.junit.Test;

public class AddToCartTest extends TestBase {

    @Test
    public void test() {
        app.openMainPage();
        app.addGoodsToCart(3);
        app.goToCart();
        app.deleteAllGoodsFromCart();
        app.checkCartIsEmpty();
    }
}