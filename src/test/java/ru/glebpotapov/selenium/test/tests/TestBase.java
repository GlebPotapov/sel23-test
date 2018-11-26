package ru.glebpotapov.selenium.test.tests;

import org.junit.After;
import org.junit.Before;

//Import from my packages:
import ru.glebpotapov.selenium.test.app.Application;


public class TestBase {
    public Application app;

    @Before
    public void start() {
        app = new Application();
    }

    @After
    public  void stop () {
        app.quit();
    }
}