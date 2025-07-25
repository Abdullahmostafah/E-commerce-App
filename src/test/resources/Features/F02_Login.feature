@smoke
Feature: F02_Login | Users can log in to their accounts

  Background: User navigates to login page
    Given user go to login page

  Scenario Outline: User can log in with valid or invalid credentials
    When user login with "<validation>" "<email>" and "<password>"
    And user press on login button
    Then user should "<expectedResult>"

    Examples:
      | validation | email              | password | expectedResult                   |
      | valid      | test60@example.com | P@ssw0rd | login to the system successfully |
      | invalid    | wrong@example.com  | P@ssw0rd | not login to the system          |