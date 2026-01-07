package tests;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.CoursesPage;
import pages.HomePage;

public class CoursesTest extends BaseTest {

    @Test
    public void verifyCoursesPage() {
        HomePage homePage = new HomePage(driver);
        homePage.clickCourses();

        CoursesPage coursesPage = new CoursesPage(driver);
        Assert.assertTrue(coursesPage.areCoursesDisplayed());
    }
}
