package tests.test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import tests.page.IFramePage;

public class IFrameTests {

    private WebDriver webDriver;
    IFramePage iFramePage;

    @BeforeMethod
    void setUp() {
        webDriver = new ChromeDriver();
        webDriver.manage().window().maximize();
        iFramePage = new IFramePage(webDriver);
        iFramePage.openPage();
    }

    @Test
    void checkTextInLeftFrame() {
        iFramePage
                .openTopFrame()
                .openLeftFrame();

        String leftText = iFramePage.getText();

        Assert.assertEquals(leftText, "LEFT");
    }

    @Test
    void checkBottomFrame() {
        iFramePage
                .openBottomFrame();

        String bottomText = iFramePage.getText();

        Assert.assertEquals(bottomText, "BOTTOM");
    }

    @AfterMethod
    public void tearDown() {
        if (webDriver != null) {
            webDriver.quit();
        }
    }
}