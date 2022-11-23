@smoke
Feature: F07_HomeSliders| Logged user could select both sliders
  Scenario: user could select first slider
    When user click on slider "1"
    Then user redirect to slider "1"

  Scenario: user could select second slider
    When user click on slider "2"
    Then user redirect to slider "2"