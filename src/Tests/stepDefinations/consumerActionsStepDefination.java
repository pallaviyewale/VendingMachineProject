package Tests.stepDefinations;

import java.util.ArrayList;
import java.util.List;

import org.junit.runner.RunWith;
import org.testng.Assert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.junit.Cucumber;
import main.DataObjects.Basket;
import main.VendingMachineMethods.VendingMachineConsumerActions;

@RunWith(Cucumber.class)
public class consumerActionsStepDefination 
{

	VendingMachineConsumerActions consumerActions = new VendingMachineConsumerActions();
	int insertedCoin =0;
	List<Integer> coinList;
	  
@Given ("^User has inserted coin (.+)$")
public int insertCoin(int coin)
{
	return insertedCoin = coin;
}

@Given ("^User has inserted multiple coins (.+)$")
public List<Integer> insertCoin(String coin)
{
	String[] coins = coin.split(",");
	coinList = new ArrayList<Integer>();
	for (String cn : coins) {
		coinList.add(Integer.parseInt(cn));
	}
	
	return coinList;
}

@When ("^Validated and accept all coins$")
public void validateAndAcceptAllCoins()
{
	boolean status = true;
	Basket.Instance().setTotalCoins(0);
	for(Integer coin : coinList)
	{
		status = consumerActions.validateCoin(coin);
		if(status == false)
		{
			System.out.println("Not a Valid Coin. Coins allowed : PENNY(1), NICKLE(5), DIME(10), QUARTER(25)");
		}
		else
			Basket.Instance().addCoins(coin);
	}
}

@When ("^Coin gets validated$")
public void validateCoin()
{
	boolean status = true;
	status = consumerActions.validateCoin(insertedCoin);
	if(status == false)
	{
		System.out.println("Not a Valid Coin. Coins allowed : PENNY(1), NICKLE(5), DIME(10), QUARTER(25)");
	}
	else
	Assert.assertTrue(status);
}

@Then ("^Coin will get accepted if it is valid$")
public void acceptCoin()
{
	Basket.Instance().setTotalCoins(0);
	if(consumerActions.validateCoin(insertedCoin))
	{
		Basket.Instance().addCoins(insertedCoin);
	}
}


@Then ("^Verify the amount (.+) in Basket of Vending Machine$")
public void verifyAmountInBasket(int amount)
{
	  int totalAmount = Basket.Instance().getTotalValueOfInsertedCoins();
	  Assert.assertEquals(totalAmount, amount);
}

@Then ("^Verify the total amount \"([^\"]*)\" in Basket of Vending Machine$")
public void verifyTotalAmountInBasket(int amount)
{
	  int totalAmount = Basket.Instance().getTotalValueOfInsertedCoins();
	  Assert.assertEquals(totalAmount, amount);
}

}
