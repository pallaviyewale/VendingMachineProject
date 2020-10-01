package main.VendingMachineMethods;

import java.util.HashMap;
import java.util.Map;

import main.DataObjects.*;

//This class have all actions admin has to take like reset vending machine.
public class VendingMachineAdminActions
{
	public String resetVendingMachine()
	{
		Products.Instance().clearInventory();
		loadProducts();
		loadInventory();
		Basket.Instance().clearCoinBasket();
		return "Vending machine reset successfully.";
				
	}
	
	public void loadProducts()
	{				
		Products.Instance().setProducts(new Item("Coke",25));
		Products.Instance().setProducts(new Item("Pepsi",35));
		Products.Instance().setProducts(new Item("Soda",45));	
	}
	
	
	public void loadInventory()
	{
		HashMap<String,Item> productList = Products.Instance().getProducts();
		for(Map.Entry<String, Item> list : productList.entrySet())
		{
			Item itemDetail = list.getValue();
			loadInventory(itemDetail,10);
			
		}
	}
	
	public void loadInventory(Item itemDetail, int quantity)
	{
		Products.Instance().addProductToInventory(itemDetail, quantity);
	}
	
	public void printInventory()
	{
		System.out.println("\nAvailable Products: ");
		HashMap<String,Item> productList = Products.Instance().getProducts();
		
		for(Map.Entry<String, Item> list : productList.entrySet())
		{
			Item item = list.getValue();
			int qty = Products.Instance().getProductInventory(item.getName());
			System.out.println( "Name : " + item.getName() + ", Price : " + item.getPrice() + ", Quantity : "+ qty);
		}
	}
	
}
