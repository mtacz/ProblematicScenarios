package tests.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class IFramePage {

    private By bodyLocator = By.xpath("//body");

    WebDriver webDriver;

    public IFramePage(WebDriver webDriver) {
        this.webDriver = webDriver;
    }

    public IFramePage openPage() {
        webDriver.navigate().to("https://theinternet.przyklady.javastart.pl/nested_frames");
        return this;
    }

    public IFramePage openTopFrame() {
        webDriver.switchTo().frame("frame-top");
        return this;
    }

    public IFramePage openLeftFrame() {
        webDriver.switchTo().frame("frame-left");
        return this;
    }

    public String getText() {
        String text = webDriver.findElement(bodyLocator).getText();
        webDriver.switchTo().defaultContent();
        return text;
    }

    public IFramePage openBottomFrame() {
        webDriver.switchTo().frame("frame-bottom");
        return this;
    }
}