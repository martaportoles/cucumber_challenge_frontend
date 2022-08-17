#Feature: Ordering of products on Demoblaze e-commerce
#
#  Scenario Outline:Place Order
#    Given I visit cart
#
#    When user deletes <Name> from cart
#    Then user complete the order with:
#  | Name        | Marta   |
#  |Country      |Spain    |
#  |City         |Zaragoza |
#  |Credit card  | 123     |
#  |Month        | Augost  |
#  |Year         | 2022    |
#
##
##  | Name        | Country   |City    |Credit card  |Month     |Year   |
##  |  Marta      |Spain      |Zaragoza| 123          |Augost   |2022    |
#
#    And capture and log purchase Id and Amount
#    And Assert purchase amount equal expected
#    And click "ok"
#
#    Examples:
#      | Name          |
#      | "Dell i7 8gb" |
