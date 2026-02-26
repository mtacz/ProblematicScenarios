package tests.test;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import tests.page.PageObjectStaleElementReferenceException;

import java.util.List;


public class PageObjectStaleElementReferenceExceptionTests {

    private WebDriver driver;
    PageObjectStaleElementReferenceException pageObjectStaleElementReferenceException;

    private final List<String> expectedMessages = List.of(
            "Action unsuccesful, please try again",
            "Action successful",
            "Action unsuccesful, please try again"
    );

    @BeforeMethod
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        pageObjectStaleElementReferenceException = new PageObjectStaleElementReferenceException(driver);
        pageObjectStaleElementReferenceException.openPage();
    }

    @Test
    public void shouldClickUntilExpectedMessageAppears() {

        for (String expectedMessage : expectedMessages) {
            String actualMessage = "";

            while (!actualMessage.contains(expectedMessage)) {
                actualMessage = pageObjectStaleElementReferenceException.clickAndGetMessage();
            }

            Assert.assertTrue(
                    actualMessage.contains(expectedMessage),
                    "Expected message not found: " + expectedMessage
            );
        }
    }

    @AfterMethod
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}