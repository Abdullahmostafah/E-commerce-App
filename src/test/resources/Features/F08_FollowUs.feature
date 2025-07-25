@smoke
Feature: F08_FollowUs | Users can open social media links

  Scenario Outline: User opens social media links
    When user opens "<socialMedia>" link
    Then "<expectedUrl>" is opened in new tab

    Examples:
      | socialMedia | expectedUrl                                     |
      | facebook    | https://www.facebook.com/nopCommerce            |
      | twitter     | https://x.com/nopCommerce                       |
      | instagram   | https://www.instagram.com/nopcommerce_official/ |
      | youtube     | https://www.youtube.com/user/nopCommerce        |