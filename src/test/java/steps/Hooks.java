package steps;

import Utils.Base;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.io.File;
import java.nio.file.Files;

public class Hooks extends Base {

    @Before
    public void setUp() {
        initializeBrowser("chrome");
    }

    @After
    public void tearDown(Scenario scene) {
        try {
            if (scene.isFailed()) {
                // Print the name of the failed scenario
                System.out.println("Failed Scenario: " + scene.getName());

                // Taking a screenshot if the scenario fails
                byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
                scene.attach(screenshot, "image/png", "Screenshot");

                // Save the screenshot locally
                File screenshotFile = new File("src/Report/" + scene.getName() + ".png");
                Files.write(screenshotFile.toPath(), screenshot);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            closeBrowser();
        }
    }
}
