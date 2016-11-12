import java.util.ArrayList;
import java.util.Scanner;

public class ShoppingCart {

	//private feild variables
	private String customerName;
	private String currentDate;
	private ArrayList<ItemToPurchase> cartItems = new ArrayList<ItemToPurchase>();

	//default constructor
	public ShoppingCart(){
		this.customerName = "none";
		this.currentDate = "January 1, 2016";


	}

	//parameterized constructor taking name and date as arguments
	public ShoppingCart(String customerName, String currentDate){
		this.customerName = customerName;
		this.currentDate  = currentDate;
	}

	public void setCustomerName(String customerName){
		this.customerName = customerName;
	}

	public void setDate(String currentDate){
		this.currentDate = currentDate;
	}

	//getters to return customer name and the date
	public String getCustomerName(){
		return customerName;
	}

	public String getDate(){
		return currentDate;
	}

	//adds item to the array list
	public void addItem(ItemToPurchase ItemToPurchase){
		this.cartItems.add(cartItems.size(), ItemToPurchase);

	}

	//removes item from array list
	public void removeItem(String ItemToRemove){
		int count = 0;

		for(int i = 0; i < cartItems.size(); ++i){
			if(cartItems.get(i).getName().equalsIgnoreCase(ItemToRemove)){
				cartItems.remove(i);
				++count;

			}

		}
		if(count == 0){
			System.out.print("\nItem not found in cart. Nothing removed.");
		}

	}

	//method to modify an item in the cart
	public void modifyItem(ItemToPurchase itemToPurchase){

		int count = 0;

		for(int i = 0; i < cartItems.size(); ++i){

			if(cartItems.get(i).getName().equals(itemToPurchase.getName())){
				cartItems.get(i).setQuantity(itemToPurchase.getQuantity());
				++count;
			}


		}
		if(count == 0){
			System.out.println("\nItem not found in cart. Nothing modified.");
		}
	}

	//returns total items in cart
	public int getNumItemsInCart(){
		int numItems = 0;
		for(int i = 0; i < cartItems.size(); ++i){
			numItems = numItems + cartItems.get(i).getQuantity();
		}
		return numItems;
	}

	//returns total cost of cart
	public int getCostOfCart(){

		int totalCost = 0;
		for(int i=0; i < cartItems.size(); ++i){
			totalCost = totalCost + (cartItems.get(i).getPrice()*cartItems.get(i).getQuantity());;
		}
		return totalCost;
	}

	//print total shopping cart
	public void printTotal(){

		for(int i = 0; i < cartItems.size(); ++i){
			System.out.print(cartItems.get(i).printItemCost());
		}
		System.out.println();
	}

	//print out description of items
	public void printDescriptions(){
		System.out.println("Item Descriptions");
		for(int i = 0; i< cartItems.size(); ++i){
			System.out.println(cartItems.get(i).printItemDescription());
		}

	}

}
