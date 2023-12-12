package steps;

import Utils.Base;
import Utils.Registerformdetails;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObj.HomePageRepo;
import pageObj.LoginpageRepo;
import pageObj.RegisterPageRepo;

import java.util.List;
import java.util.Map;

public class Stepdefs extends Base {
    HomePageRepo hompage;
    RegisterPageRepo registerpage;
    LoginpageRepo loginpage;

    @Given("^user launches browser and enter url$")
    public void userLaunchesBrowserAndEnterUrl() {

        hompage = new HomePageRepo(driver);
        hompage.verifyHomePage();
    }


    @Then("^user selects option from myaccount dropdown$")
    public void userSelectsRegisterOptionFromMyaccountDropdownMyaccountoption() {
        registerpage = hompage.selectRegisterOptionFromMyAccountDropdown();
        registerpage.verifyRegisterPage();

    }


    @When("user enters the following details")
    public void userEntersTheFollowingDetails(DataTable registerformdetails) {

//

        List<Map<String, Object>> userDetailsList = Registerformdetails.getUserDetails();

        for (Map<String, Object> userDetails : userDetailsList) {
            registerpage.enterFirstName(String.valueOf(userDetails.get("firstname")));
            registerpage.enterLastname(String.valueOf(userDetails.get("lastname")));
            registerpage.enterEmail(String.valueOf(userDetails.get("email")));
            if (userDetails.containsKey("telephone")) {
                int telephonnum = (int) userDetails.get("telephone");
                registerpage.enterTelephone(telephonnum);
            }
            registerpage.enterPassword(String.valueOf(userDetails.get("password")));
            registerpage.enterConfirmPassword(String.valueOf(userDetails.get("passwordconfirm")));

            registerpage.clickOnPrivacyPolicy();
        }
    }


    @Then("click on continue button")
    public void clickOnContinueButton() {
        registerpage.clickOnSubmitButton();
        registerpage.verifyRegisterCompletion();
    }

    ////////////////////////////////////////////////////////////////////////

    @Then("user selects Login option from myaccount dropdown")
    public void userSelectsLoginOptionFromMyaccountDropdown() {
        loginpage = hompage.selectLoginOptionFromMyAccountDropdown();
        loginpage.verifyLoginPage();

    }

    @And("user enters the username and password")
    public void userEntersTheUsernameAndPassword(DataTable userdetails) {
        List<Map<String, String>> userDetailsList = userdetails.asMaps(String.class, String.class);
        for (Map<String, String> userDetails : userDetailsList) {
            loginpage.enterEmail(userDetails.get("email"));
            loginpage.enterPassword(userDetails.get("password"));
        }


    }

    @Then("click on Login button")
    public void clickOnLoginButton() {
        loginpage.clickOnLoginButton();
    }


}
