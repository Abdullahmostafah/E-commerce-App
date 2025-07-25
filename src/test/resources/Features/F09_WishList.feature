@smoke
Feature: F09_Wishlist| users could add products to wishlist

  Scenario Outline: user could add product to the wishlist
    When user click on wishlist button for product "<productIndex>"
    Then success message is displayed with background color is "<expectedColor>"
    And click on Wishlist Tab on the top of the page
    Then product is added to wish list with quantity "<expectedQuantity>"

    Examples:
      | productIndex | expectedColor | expectedQuantity |
      | 3           | green         | 1                |

