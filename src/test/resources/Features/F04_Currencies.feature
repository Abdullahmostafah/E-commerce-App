@smoke
Feature: F04_Currencies | Users can switch between currencies

  Scenario Outline: User can switch between currencies
    When user select "<currency>" currency from the dropdown list
    Then "<symbol>" symbol displayed for all products

    Examples:
      | currency | symbol |
      | Euro     | €      |
      | US Dollar| $      |