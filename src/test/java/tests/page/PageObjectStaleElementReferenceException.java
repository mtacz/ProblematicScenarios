package tests.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class PageObjectStaleElementReferenceException {

    private By clickButton = By.linkText("Click here");
    private By flashMessage = By.id("flash");

    WebDriver driver;

    public PageObjectStaleElementReferenceException(WebDriver driver) {
        this.driver = driver;
    }

    public PageObjectStaleElementReferenceException openPage() {
        driver.navigate().to("https://theinternet.przyklady.javastart.pl/notification_message_rendered");
        return this;
    }

    public PageObjectStaleElementReferenceException clickButton() {
        driver.findElement(clickButton).click();
        return this;
    }

    public String getMessage() {
        return driver.findElement(flashMessage).getText();
    }

    public String clickAndGetMessage() {
        clickButton();
        return getMessage();
    }

}