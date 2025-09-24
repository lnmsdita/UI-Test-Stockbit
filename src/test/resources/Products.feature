
Feature: Product scenarios


  Scenario Outline: Validate product info on Products page
    Given I'm logged in
    Then the product is listed with title "<title>" and price "<price>"
    Examples:
      | title                   | price |
      | Sauce Lab Back Packs    | $ 29.99 |
#      | Sauce Labs Bolt T-Shirt | $15.99 |
#      | Sauce Labs Onesie       | $7.99  |
#      | Test.allTheThings() T-Shirt (Red) | $15.99 |

  Scenario: Add to Cart Product
    Given I'm logged in
    When Choose the product
    Then Success add product to cart