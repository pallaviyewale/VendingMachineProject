package Tests.stepDefinations;

import java.io.IOException;

import org.junit.runner.RunWith;
import org.testng.Assert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.junit.Cucumber;
import main.DataObjects.Basket;
import main.VendingMachineMethods.VendingMachineAdminActions;
import main.VendingMachineMethods.VendingMachineConsumerActions;

@RunWith(Cucumber.class)
public class productSelectionStepDefination 
{
	VendingMachineConsumerActions consumerActions = new VendingMachineConsumerActions();
	VendingMachineAdminActions adminActions = new VendingMachineAdminActions();
	String message = "";
	
	@Given ("^User has selected Item (.+)$")
	public void selectItem(String itemname) throws IOException
	{
		 message = consumerActions.selectItem(itemname);
	}
	
	@Then ("^Verify user can not select this item$")
	public void userCantSelectItem()
	{
		Assert.assertEquals(message, "Please enter valid product name");
	}
	
	
	@Given ("^Admin has Loaded Products in Inventory$")
	public void loadProductsInInventory()
	{
		adminActions.loadProducts();
		adminActions.loadInventory();
	}

	@When ("^User inserts valid coins (.+)$")
	public void insertCoins(String coin)
	{
		Basket.Instance().setTotalCoins(0);
		String[] coins = coin.split(",");
		for (String cn : coins) {
			Basket.Instance().addCoins(Integer.parseInt(cn));
		}
	}
	
	@When ("^User selects Item (.+)$")
	public void userSelectsItems(String item) throws IOException
	{
		message = consumerActions.selectItem(item);
	}
	
	@When ("^User Cancel the transaction$")
	public void cancelTransaction()
	{
		 message = consumerActions.cancelAndRefund();
	}
	
	@Then ("^Verify user should get selected item$")
	public void verifySelectedProduct()
	{
		Assert.assertEquals(message, "Please pickup your item and balance amount 0");
	}
	
	@Then ("^Verify user should not get selected item because of insufficient balance \"([^\"]*)\"$")
	public void verifyUserCantGetProduct(String balance)
	{
		String expectedMessage = "Insufficient balance, current balance is " + balance + " Either Insert More Coins or Cancel the transaction";
		Assert.assertEquals(message, expectedMessage);
	}
	
	@Then ("^Verify user should get selected item and refund of balance \"([^\"]*)\"$")
	public void verifyUsetGetsItemAndRefund(String balance)
	{
		String expectedMessage = "Please pickup your item and balance amount " + balance;
		Assert.assertEquals(message, expectedMessage);
	}
	
	@Then ("^Verify user should get the refund \"([^\"]*)\"$")
	public void verifyUserGetsRefund(String balance)
	{
		String expectedMessage = "Transaction Cancelled. Money Refunded: " + balance;
		Assert.assertEquals(message, expectedMessage);
	}
}
