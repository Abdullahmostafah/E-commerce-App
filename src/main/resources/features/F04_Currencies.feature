@smoke
Feature: F04_ResetPassword| Logged User could switch between currencies US-Euro

  Scenario: User could switch between currencies
    When user select Euro currency from the dropdown list
    Then euro symbol displayed for all products