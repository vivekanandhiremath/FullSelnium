package pageObj;

import Utils.Base;
import Utils.ElementUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class RegisterPageRepo extends Base {
    ElementUtils utils;
    @FindBy(xpath = "//h1[.='Register Account']")
    private WebElement registeracounttext;
    @FindBy(xpath = "//input[@id='input-firstname']")
    private WebElement firstnametextfield;
    @FindBy(xpath = "//input[@id='input-lastname']")
    private WebElement lastnametextfield;
    @FindBy(xpath = "//input[@id='input-email']")
    private WebElement emailtextfield;
    @FindBy(xpath = "//input[@id='input-telephone']")
    private WebElement telephonetextfield;
    @FindBy(xpath = "//input[@id='input-password']")
    private WebElement passwordtextfield;
    @FindBy(xpath = "//input[@id='input-confirm']")
    private WebElement passwordconfirmtextfield;
    @FindBy(xpath = "//input[@type='checkbox']")
    private WebElement privacypolicycheckbox;
    @FindBy(xpath = "//input[@type='submit']")
    private WebElement continuebutton;
    @FindBy(xpath = "//h1[.='Your Account Has Been Created!']")
    private WebElement successmessage;

    public RegisterPageRepo(WebDriver driver) {
        Base.driver = driver;
        PageFactory.initElements(driver, this);
        utils = new ElementUtils(driver);
    }

    public void verifyRegisterPage() {
        boolean result = utils.elementIsDisplayed(registeracounttext, EXPLICIT_WAIT_IN_SECONDS);
        System.out.println(result);
        Assert.assertTrue(result, "Register Account text is not displayed on the Register page.");

    }

    public void enterFirstName(String firstname) {
        utils.waitAndTypeIntoAnElement(firstnametextfield, firstname, EXPLICIT_WAIT_IN_SECONDS);

    }

    public void enterLastname(String lastname) {
        utils.waitAndTypeIntoAnElement(lastnametextfield, lastname, EXPLICIT_WAIT_IN_SECONDS);

    }

    public void enterEmail(String email) {
        utils.waitAndTypeIntoAnElement(emailtextfield, email, EXPLICIT_WAIT_IN_SECONDS);

    }

    public void enterTelephone(int telephone) {
        utils.waitAndTypeIntoAnElement(telephonetextfield, String.valueOf(telephone), EXPLICIT_WAIT_IN_SECONDS);

    }

    public void enterPassword(String password) {
        utils.waitAndTypeIntoAnElement(passwordtextfield, password, EXPLICIT_WAIT_IN_SECONDS);

    }

    public void enterConfirmPassword(String passwordconfirm) {
        utils.waitAndTypeIntoAnElement(passwordconfirmtextfield, passwordconfirm, EXPLICIT_WAIT_IN_SECONDS);
    }

    public void clickOnPrivacyPolicy() {
        utils.waitAndClickOnElement(privacypolicycheckbox, EXPLICIT_WAIT_IN_SECONDS);
    }

    public void clickOnSubmitButton() {
        utils.waitAndClickOnElement(continuebutton, EXPLICIT_WAIT_IN_SECONDS);
    }

    public void verifyRegisterCompletion() {
        boolean result = utils.elementIsDisplayed(successmessage, EXPLICIT_WAIT_IN_SECONDS);
        System.out.println(result);
        Assert.assertTrue(result, "Registered Failed.");


    }

}
