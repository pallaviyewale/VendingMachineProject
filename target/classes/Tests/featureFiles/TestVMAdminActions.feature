Feature: Admin Actions Functionality


Scenario: verify price for all products
  Given Admin has loaded product details
  When Get the product details
  Then All products price should be as expected

Scenario Outline: verify all valid products avaiable in Inventory
  Given Admin has loaded product details
  When Get the product details
  Then All valid products should be in Inventory

Scenario Outline: verify quantity of product after admin loads products in Inventory
  Given Admin has loaded product "Pepsi" in Inventory with Quantity "20"
  When Get the product "Pepsi" details from Inventory
  Then Quanity of products for "Pepsi" should be "20" 

Scenario Outline: verify quantity of products after product removed from Inventory
  Given Admin has loaded product "Soda" in Inventory with Quantity "25"
  And "15" products for "Soda" removed from Inventory
  When Get the product "Soda" details from Inventory
  Then Quanity of products for "Soda" should be "10"
