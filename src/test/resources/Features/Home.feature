Feature: to check the Home page

  Background:Launch application
    Given user launches browser and enter url

  @RegisterAccount
  Scenario Outline: Register Functionality

    Then user selects option from myaccount dropdown
    When user enters the following details
      | firstname | lastname | email                | telephone | password | passwordconfirm |
      | vivek     | hiremath | vivekanand@gmail.com | 666788999 | vivek    | vivek           |
    Then click on continue button
    Examples:
      | myaccountoption |
      | Register        |

  @LoginToAccount
  Scenario Outline: Login Functionality

    Then user selects Login option from myaccount dropdown
    And user enters the username and password
      | email                | password |
      | vivekanand@gmail.com | vivek    |
    Then click on Login button
    Examples:
      | myaccountoption |
      | Login           |

