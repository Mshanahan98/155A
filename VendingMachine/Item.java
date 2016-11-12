package vending_Machine;

//class to set and return item information
public class Item {

	private String description;
	private double price;
	private int quantity;

	public Item(String itemDesc, double itemPrice, int itemQuantity){

		this.description = itemDesc;
		this.price = itemPrice;
		this.quantity = itemQuantity;
	}

	public void setQuantity(int itemQuantity){
		this.quantity = itemQuantity;
	}
	public void setPrice(double itemPrice){
		this.price = itemPrice;
	}
	public void setDescription(String itemDesc){
		this.description = itemDesc;
	}
	public String getDescription(){
		return description;
	}
	public double getPrice(){
		return price;
	}
	public int getQuantity(){
		return quantity;
	}


}
