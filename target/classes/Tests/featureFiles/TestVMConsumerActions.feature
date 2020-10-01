Feature: Vending Machine Consumer Action Functionality


@consumerActionTest
Scenario Outline: Validate all coins can be inserted into Vending Machine
  Given User has inserted coin <coin>
  When Coin gets validated
  Then Coin will get accepted if it is valid


  Examples: 
    | coin  | 
    | 1     |
    | 5     | 
    | 10    |
    | 25    |
    | 15    |
    | 20    |
    
@consumerActionTest
Scenario Outline: Validate and insert valid coin in Vending Machine
  Given User has inserted coin <coin>
  When Coin gets validated
  And Coin will get accepted if it is valid
  Then Verify the amount <coin> in Basket of Vending Machine


  Examples: 
    | coin  | 
    | 1     |
    | 5     | 
    | 10    |


@consumerActionTest
Scenario Outline: Verify the total amount of all inserted coin in Vending Machine
  Given User has inserted multiple coins <coin>
  When Validated and accept all coins
  Then Verify the total amount "31" in Basket of Vending Machine
  
  Examples: 
    | coin       | 
    | 1,5,25     |