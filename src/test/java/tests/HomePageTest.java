package tests;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;

public class HomePageTest extends BaseTest {

    @Test
    public void verifyHomePageLoads() {
        HomePage homePage = new HomePage(driver);
        Assert.assertTrue(homePage.isLogoDisplayed(), "Logo is not displayed");
    }

    @Test
    public void verifyNavigationToCourses() {
        HomePage homePage = new HomePage(driver);
        homePage.clickCourses();
        Assert.assertTrue(driver.getCurrentUrl().contains("courses"));
    }

    @Test
    public void verifyNavigationToContact() {
        HomePage homePage = new HomePage(driver);
        homePage.clickContact();
        Assert.assertTrue(driver.getCurrentUrl().contains("contact"));
    }
}
