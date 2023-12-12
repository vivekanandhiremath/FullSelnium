package pageObj;

import Utils.Base;
import Utils.ElementUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginpageRepo extends Base {
    ElementUtils utils;
    @FindBy(xpath = "//h2[contains(.,'Returning Customer')]")
    private WebElement returningcustomertext;
    @FindBy(xpath = "//input[@id='input-email']")
    private WebElement emailtextfield;
    @FindBy(xpath = "//input[@id='input-password']")
    private WebElement passwordtextfield;
    @FindBy(xpath = "//input[contains(@type,'submit')]")
    private WebElement loginbutton;

    public LoginpageRepo(WebDriver driver) {
        Base.driver = driver;
        PageFactory.initElements(driver, this);
        utils = new ElementUtils(driver);
    }

    public void verifyLoginPage() {
        utils.elementIsDisplayed(returningcustomertext, EXPLICIT_WAIT_IN_SECONDS);
    }

    public void enterEmail(String email) {
        utils.waitAndTypeIntoAnElement(emailtextfield, email, EXPLICIT_WAIT_IN_SECONDS);
    }

    public void enterPassword(String password) {
        utils.waitAndTypeIntoAnElement(passwordtextfield, password, EXPLICIT_WAIT_IN_SECONDS);
    }

    public void clickOnLoginButton() {
        utils.waitAndClickOnElement(loginbutton, EXPLICIT_WAIT_IN_SECONDS);
    }
}
