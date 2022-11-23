@smoke
Feature:  F09_Wishlist| users could open followUs links
  Scenario: user could add product to the wishlist
    When user click on wishlist button
    Then success message is displayed with background color is green

  Scenario: user opens twitter link
    When user click on wishlist button
    And click on Wishlist Tab on the top of the page
    Then product is added to wish list with quantity one