Feature: Ordering of products


  Scenario Outline: Order a product
  Given I visit Demoblaze

  When User navigates to Laptop section
  And user navigates to <Name> item page
  And user adds product to cart
  Then user navigates to cart page and validates <Name> is on cart

  Examples:
  | Name |
  | "Sony vaio i5" |
  | "Dell i7 8gb" |

  Scenario Outline:Place Order
    Given I visit cart

    When user deletes <Name> from cart
    Then user complete the order with:
#      | Name          | Marta   |
#      | Country       | Spain    |
#      | City          | Zaragoza |
#      | Credit card   | 123     |
#      | Month         | August  |
#      | Year          | 2022    |

    | Name    | Country   | City      | Credit card  | Month    | Year  |
    | Marta   | Spain     | Zaragoza  | 123          | August   | 2022  |

    And capture and log purchase Id and Amount
    And Assert purchase amount equal expected
    And click "ok"

    Examples:
      | Name          |
      | "Dell i7 8gb" |