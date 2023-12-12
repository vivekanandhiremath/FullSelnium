package pageObj;

import Utils.Base;
import Utils.ElementUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class HomePageRepo extends Base {
    ElementUtils utils;
    @FindBy(xpath = "//a[.='Qafox.com']")
    private WebElement qafoxTexts;
    @FindBy(xpath = "//span[.='My Account']")
    private WebElement myaccountdropdown;

    @FindBy(xpath = "(//a[contains(.,'Register')])[1]")
    private WebElement registeroption;

    @FindBy(xpath = "(//a[contains(.,'Login')])[1]")
    private WebElement loginoption;

    public HomePageRepo(WebDriver driver) {
        Base.driver = driver;
        PageFactory.initElements(driver, this);
        utils = new ElementUtils(driver);
    }

    public void verifyHomePage() {
        boolean result = utils.elementIsDisplayed(qafoxTexts, EXPLICIT_WAIT_IN_SECONDS);
        System.out.println(result);
        Assert.assertTrue(result, "Qafox.com link is not displayed on the home page.");
    }

    public RegisterPageRepo selectRegisterOptionFromMyAccountDropdown() {

        utils.waitAndClickOnElement(myaccountdropdown, EXPLICIT_WAIT_IN_SECONDS);
        utils.waitAndClickOnElement(registeroption, EXPLICIT_WAIT_IN_SECONDS);
        return new RegisterPageRepo(driver);

    }

    public LoginpageRepo selectLoginOptionFromMyAccountDropdown() {

        utils.waitAndClickOnElement(myaccountdropdown, EXPLICIT_WAIT_IN_SECONDS);
        utils.waitAndClickOnElement(loginoption, EXPLICIT_WAIT_IN_SECONDS);
        return new LoginpageRepo(driver);

    }

}
