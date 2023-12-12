package Utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.function.Function;

public class ElementUtils {
    private final WebDriver driver;

    public ElementUtils(WebDriver driver) {
        this.driver = driver;
    }

    private WebElement waitForElement(WebElement element, long durationInSeconds) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(durationInSeconds));
        return wait.until(ExpectedConditions.elementToBeClickable(element));
    }

    public void waitAndClickOnElement(WebElement element, long durationInSeconds) {
        WebElement webElement = waitForElement(element, durationInSeconds);
        webElement.click();
    }

    public boolean elementIsDisplayed(WebElement element, long durationInSeconds) {
        WebElement webElement = waitForElement(element, durationInSeconds);

        return webElement.isDisplayed();

    }


    public void waitAndTypeIntoAnElement(WebElement element, String text, long durationInSeconds) {
        WebElement webElement = waitForElement(element, durationInSeconds);
        webElement.clear();
        webElement.sendKeys(text);
    }

    public WebElement explicitlyWaitForanElement(WebElement element, long durationInSeconds) {

        Wait<WebDriver> wait = configureFluentWait(driver, durationInSeconds);

        return wait.until(new Function<WebDriver, WebElement>() {
            public WebElement apply(WebDriver driver) {
                return element;
            }
        });
    }


    private Wait<WebDriver> configureFluentWait(WebDriver driver, long durationInSeconds) {
        return new FluentWait<>(driver)
                .withTimeout(Duration.ofSeconds(durationInSeconds))
                .pollingEvery(Duration.ofSeconds(durationInSeconds))
                .ignoring(Exception.class);
    }

}
