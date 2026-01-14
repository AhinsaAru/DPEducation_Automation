package tests;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import utils.TestListener;

@Listeners(TestListener.class)
public class LoginTest extends BaseTest {

    @Test
    public void openGoogleTest() {
        driver.get("https://www.google.com");
        Assert.assertTrue(driver.getTitle().contains("Google"));
    }

    @Test
    public void failingTest() {
        driver.get("https://www.google.com");
        Assert.assertTrue(driver.getTitle().contains("Yahoo")); // will fail
    }
}
