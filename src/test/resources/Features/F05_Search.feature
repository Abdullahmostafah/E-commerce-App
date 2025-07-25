@smoke
Feature: F05_Search | Users can search for products

  Scenario Outline: User can search for products by name
    When user click on search field
    And user search with "<ProductName>"
    And user click on search button
    Then user Could find "<ProductName>" relative results

    Examples:
      | ProductName |
      | book        |
      | laptop      |


  Scenario Outline: User can search for product using SKU
    When user click on search field
    And user search with "<sku>"
    And user click on search button
    Then user could find "<sku>" inside product detail page

    Examples:
      | sku        |
      | SCI_FAITH  |
      | APPLE_CAM  |
