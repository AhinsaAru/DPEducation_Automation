package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CoursesPage {

    WebDriver driver;

    public CoursesPage(WebDriver driver) {
        this.driver = driver;
    }

    private By courseCards = By.cssSelector(".course-card");
    private By enrollButton = By.cssSelector(".enroll-btn");

    public boolean areCoursesDisplayed() {
        return driver.findElements(courseCards).size() > 0;
    }

    public boolean isEnrollButtonPresent() {
        return driver.findElement(enrollButton).isDisplayed();
    }
}
