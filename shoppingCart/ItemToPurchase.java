public class ItemToPurchase {

	//private feild declarations
	private String itemName;
	private int    itemPrice;
	private int    itemQuantity;
	private String itemDescription;

	//constructor
	public ItemToPurchase(){
		this.itemName     = "none";
		this.itemPrice    = 0;
		this.itemQuantity = 0;
		this.itemDescription = "none";
	}
	public ItemToPurchase(String itemName, String itemDescription, int itemPrice, int itemQuantity){
		this.itemName = itemName;
		this.itemPrice = itemPrice;
		this.itemQuantity = itemQuantity;
		this.itemDescription = itemDescription;
	}

	//setters
	public void setName(String itemName){
		this.itemName = itemName;

	}

	public void setPrice(int itemPrice){
		this.itemPrice = itemPrice;

	}

	public void setQuantity(int itemQuantity){
		this.itemQuantity = itemQuantity;
	}

	public void setDescription(String itemDescription){
		this.itemDescription = itemDescription;
	}

	//getters
	public String getName(){
		return itemName;
	}

	public int getPrice(){
		return itemPrice;
	}

	public int getQuantity(){
		return itemQuantity;
	}

	public String getDescription(){
		return itemDescription;
	}

	//print methods for info about the item
	public String printItemCost(){
		String cost = ("\n" + itemName + " " + itemQuantity + " @ $" + itemPrice + " = $" + (itemQuantity * itemPrice));
		return cost;
	}

	public String printItemDescription(){
		String description = (itemName + ": " + itemDescription);
		return description;
	}

}
