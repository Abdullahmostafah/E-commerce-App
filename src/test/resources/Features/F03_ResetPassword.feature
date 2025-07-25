@smoke
Feature: F03_ResetPassword | Users can reset their password

  Scenario Outline: User can reset password
    Given user go to login page
    When user select forgot password
    And user enter the email "<email>"
    And user click on recover button
    Then email sent message is displayed

    Examples:
      | email               |
      | test60@example.com  |
