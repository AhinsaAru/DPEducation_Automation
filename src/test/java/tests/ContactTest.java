package tests;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.ContactPage;
import pages.HomePage;

public class ContactTest extends BaseTest {

    @Test
    public void submitContactFormSuccessfully() {
        HomePage homePage = new HomePage(driver);
        homePage.clickContact();

        ContactPage contactPage = new ContactPage(driver);
        contactPage.fillForm("John Doe", "john@test.com", "I want course details");
        contactPage.submitForm();

        Assert.assertTrue(contactPage.getSuccessMessage().contains("Thank"));
    }

    @Test
    public void submitEmptyContactForm() {
        HomePage homePage = new HomePage(driver);
        homePage.clickContact();

        ContactPage contactPage = new ContactPage(driver);
        contactPage.submitForm();

        Assert.assertTrue(contactPage.isErrorDisplayed(), "Validation message not shown");
    }
}
