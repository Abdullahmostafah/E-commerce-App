@smoke

Feature: F03_ResetPassword| User could reset his/her password successfully

  Scenario: user could reset password
    Given user go to login page
    When user select forgot password
    And user enter the email "test60@example.com"
    And user click on recover button
    Then email sent message is displayed