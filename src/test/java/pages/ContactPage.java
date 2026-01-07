package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ContactPage {

    WebDriver driver;

    public ContactPage(WebDriver driver) {
        this.driver = driver;
    }

    // Locators
    private By nameField = By.id("name");
    private By emailField = By.id("email");
    private By messageField = By.id("message");
    private By submitButton = By.cssSelector("button[type='submit']");
    private By successMessage = By.className("success-message");
    private By errorMessage = By.className("error");

    // Actions
    public void fillForm(String name, String email, String message) {
        driver.findElement(nameField).sendKeys(name);
        driver.findElement(emailField).sendKeys(email);
        driver.findElement(messageField).sendKeys(message);
    }

    public void submitForm() {
        driver.findElement(submitButton).click();
    }

    public String getSuccessMessage() {
        return driver.findElement(successMessage).getText();
    }

    public boolean isErrorDisplayed() {
        return driver.findElement(errorMessage).isDisplayed();
    }
}
