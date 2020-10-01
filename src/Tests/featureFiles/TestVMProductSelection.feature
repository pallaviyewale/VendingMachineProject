Feature: Product Selection functionality

@productSelectionTests
Scenario Outline: User can not select Invalid item in Vending Machine
  Given User has selected Item <name>
  Then Verify user can not select this item 

  Examples: 
  | name  |
  | Lime  | 
  | Oreo  |
    
    
@productSelectionTests
Scenario Outline: Verify user got selected item from Vending Machine
  Given Admin has Loaded Products in Inventory
  When User inserts valid coins <coins>
  And User selects Item <name>
  Then Verify user should get selected item 

  Examples: 
  | name  | coins |
  | Coke  | 25    |

    
@productSelectionTests
Scenario Outline: Verify user cant select item because of insufficient balance
  Given Admin has Loaded Products in Inventory
  When User inserts valid coins <coins>
  And User selects Item <name>
  Then Verify user should not get selected item because of insufficient balance "25"

  Examples: 
  | name  | coins |
  | Soda  | 25    |


@productSelectionTests
Scenario Outline: Verify user can select item and refund balance amount
  Given Admin has Loaded Products in Inventory
  When User inserts valid coins <coins>
  And User selects Item <name>
  Then Verify user should get selected item and refund of balance "15"

  Examples: 
  | name  | coins       |
  | Soda  | 25,10,25    |
    
    
@productSelectionTests
Scenario Outline: Verify user can get refund on transaction cancellation
  Given Admin has Loaded Products in Inventory
  When User inserts valid coins <coins>
  And User Cancel the transaction
  Then Verify user should get the refund "36"

  Examples: 
	| coins       |
  | 25,10,1     |