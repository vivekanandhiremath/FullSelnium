package Utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.time.Duration;

public class Base {
    public static WebDriver driver;
    public static long IMPLICIT_WAIT_IN_SECONDS = 30;
    public static long PAGE_LOAD_TIME_IN_SECONDS = 30;
    public static long EXPLICIT_WAIT_IN_SECONDS = 30;
    public static long FLUENT_WAIT_IN_SECONDS = 30;
    public static long POLLING_INTERVAL_IN_MILI_SECONDS = 10000;


    public static void initializeBrowser(String browser) {
        if (browser.equalsIgnoreCase("chrome")) {
            driver = new ChromeDriver();
        } else if (browser.equalsIgnoreCase("firefox")) {
            driver = new FirefoxDriver();
        }

        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(PAGE_LOAD_TIME_IN_SECONDS));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(IMPLICIT_WAIT_IN_SECONDS));
        driver.navigate().to("https://tutorialsninja.com/demo/");
    }

    public static void closeBrowser() {
        if (driver != null) {
            driver.close();
            driver.quit();
        }
    }
}
