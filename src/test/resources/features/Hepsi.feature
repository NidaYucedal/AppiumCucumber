Feature: HepsiBurada Test
  @HB
  Scenario: buy a product
    Given open app
    When  verify page is visible
    And   click searchbox
    And   search a product and add to cart
    And   go to cart and verify product is visible
    And   click login and verify
    And   enter valid data
    Then  verify user profile



