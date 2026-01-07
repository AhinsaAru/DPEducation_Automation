package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage {

    WebDriver driver;

    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    // Locators
    private By logo = By.cssSelector("img"); // update locator
    private By coursesLink = By.linkText("Courses");
    private By contactLink = By.linkText("Contact");

    // Actions
    public boolean isLogoDisplayed() {
        return driver.findElement(logo).isDisplayed();
    }

    public void clickCourses() {
        driver.findElement(coursesLink).click();
    }

    public void clickContact() {
        driver.findElement(contactLink).click();
    }
}
