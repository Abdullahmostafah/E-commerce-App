@smoke
Feature: F01_Register | Users can register with new accounts

  Scenario Outline: Guest user can register with valid data
    Given user go to register page
    When user select gender type
    And user enter first name "<firstName>" and last name "<lastName>"
    And user enter email "<email>" field
    And user fills Password fields "<password>" "<confirmPassword>"
    And user clicks on register button
    Then success message is displayed

    Examples:
      | firstName   | lastName | email               | password  | confirmPassword |
      | automation  | tester   | test61@example.com  | P@ssw0rd  | P@ssw0rd        |