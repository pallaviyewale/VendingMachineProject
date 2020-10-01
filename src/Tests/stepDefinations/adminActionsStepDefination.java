package Tests.stepDefinations;

import java.util.HashMap;
import java.util.Map.Entry;

import org.junit.runner.RunWith;
import org.testng.Assert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.junit.Cucumber;
import main.DataObjects.Item;
import main.DataObjects.Products;
import main.VendingMachineMethods.VendingMachineAdminActions;

@RunWith(Cucumber.class)
public class adminActionsStepDefination 
{
	VendingMachineAdminActions adminactions = new VendingMachineAdminActions();
	HashMap<String, Item> productList;

@Given ("^Admin has loaded product details$")
public void loadProducts()
{
	adminactions.loadProducts();
}
	 
@When ("^Get the product details$")
public HashMap<String, Item> getProductDetails()
{
	  productList = Products.Instance().getProducts();
	  return productList;
}

@Then ("^All products price should be as expected$")
public void verifyProductPrice()
{
	  boolean status = false;
	  for(Entry<String, Item> item : productList.entrySet())
	  {
		  if(item.getKey().equals("Coke") && item.getValue().getPrice()==25)
		  {
			  status = true;
		  }
				  
		  if(item.getKey().equals("Pepsi") && item.getValue().getPrice()==35)
		  {
			  status = true;
		  }
		  
		  if(item.getKey().equals("Soda") && item.getValue().getPrice()==45)
		  {
			  status = true;
		  }
	  }
	  Assert.assertTrue(status);
}

@Then ("^All valid products should be in Inventory$")
public void verifyProducts()
{
	  boolean status = false;
	  for(Entry<String, Item> item : productList.entrySet())
	  {
		  if(item.getKey().equals("Coke") || item.getKey().equals("Pepsi") || item.getKey().equals("Soda")) 
		  {
			  status = true;
		  }
	  }
	  Assert.assertTrue(status);
}

@Given ("^Admin has loaded product \"([^\"]*)\" in Inventory with Quantity \"([^\"]*)\"$")
public void loadProductsInInventory(String name, int quantity)
{
	  int price =0;
	  if(name.equals("Coke"))
		  price = 25;
	  else if(name.equals("Pepsi"))
		  price = 35;
	  else if(name.equals("Soda"))
		  price = 45;
	  
	  Products.Instance().setProductInventory(name,0);
	  Item item = new Item(name,price);
	  adminactions.loadInventory(item, quantity);
}
	 
@When ("^Get the product \"([^\"]*)\" details from Inventory$")
public int getProductDetailsFromInventory(String name)
{
	 return Products.Instance().getProductInventory(name);
}

@Then ("^Quanity of products for \"([^\"]*)\" should be \"([^\"]*)\"$")
public void verifyQuanityOfProducts(String name, int quantity)
{
	int actualquantity = getProductDetailsFromInventory(name);
	Assert.assertEquals(actualquantity, quantity);
}

@Given ("^\"([^\"]*)\" products for \"([^\"]*)\" removed from Inventory$")
public void removeProductsInInventory(int quantity,String name)
{
	  int price =0;
	  if(name.equals("Coke"))
		  price = 25;
	  else if(name.equals("Pepsi"))
		  price = 35;
	  else if(name.equals("Soda"))
		  price = 45;
	  Item item = new Item(name,price);
	  Products.Instance().removeProductFromInventory(item, 15);
}

}
