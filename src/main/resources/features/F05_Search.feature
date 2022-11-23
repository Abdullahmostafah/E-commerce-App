@smoke
Feature: F05_Search| Logged User could search for any product
  Scenario Outline: User could search for any product
    When user click on search field
    And user search with "<ProductName>"
    And user click on search button
    Then user Could find "<ProductName>" relative results
    Examples:
      |ProductName|
      |book|
      |laptop|
      |nike|

  Scenario Outline: user could search for product using sku
    When user click on search field
    And user search with "<sku>"
    And user click on search button
    Then user could find "<sku>" inside product detail page
    Examples:
      |sku|
      |SCI_FAITH|
      |APPLE_CAM|
      |SF_PRO_11|