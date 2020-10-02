# VendingMachineProject

Project Structure -

Main - 

     DataObjects
	       -	Coins                          - Coin enum to validate the coins
		   -	Item                           - Iteam object with name and price
		   -	Basket                         - It contains the Amount user has inserted
		   -	Products                       - It has product inventory like count for each item
		   
	 VendingMachineApp
	       -	It has main method of APP      - It shows the display on console and user can select the option
     VendingMachineMethods 
	 
	       -	VendingMachineAdminActions     - It has all actions which admin has to take to load or reset vending machine
		   -	VendingMachineConsumerActions  - It has all actions which consumer has to take to get the iteam from vending machine                              
     Tests 
		stepDefinations
			-	adminActionsStepDefination     - Step deination file for admin actions
			-	consumerActionsStepDefination  - Step deination file for consumer actions
			-	productSelectionStepDefination - Step deination file for product selection
				
		featureFiles
			-	TestVendingMachineAdminActions     - It has all tests releated to loading items into Vending Machine.
			-	TestVendingMachineConsumerActions  - It has all tests releated to insert coins and validation of coins
			-	TestVendingMachineProductSelection - It has all tests related to selection of product

pom.xml    - All Maven dependecies
		   
How to run  -
App -
Run VendingMachineApp.java file directely from IDE as a JavaApplication.
Tests - 
Need to run TestRunner.java as JUnit Run to run all feature files.
