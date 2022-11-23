@smoke
Feature: F06_HoverCategories| Logged user could select different Categories
  Scenario: user could select different Categories
    When  user select random one of the three main categories hover and select random one of the three sub categories
    Then  user could find sub-category title is equal or contains the random selected sub-category