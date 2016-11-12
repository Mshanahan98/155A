package vending_Machine;

import java.io.*;
import java.util.InputMismatchException;
import java.util.Scanner;

/*************************************************************************
 * Simulates a real life vending machine with stock read from a file.
 * 
 * CSCE 155A Fall 2016
 * Assignment 4
 * @file VendingMachine.java
 * @author Jeremy Suing
 * @version 1.0
 * @date March 7, 2016
 *************************************************************************/
public class VendingMachine {

	//data members
	private Item[] stock;  //Array of Item objects in machine
	private double money;  //Amount of revenue earned by machine


	/*********************************************************************
	 * This is the constructor of the VendingMachine class that take a
	 * file name for the items to be loaded into the vending machine.
	 *
	 * It creates objects of the Item class from the information in the 
	 * file to populate into the stock of the vending machine.  It does
	 * this by looping the file to determine the number of items and then
	 * reading the items and populating the array of stock. 
	 * 
	 * @param filename Name of the file containing the items to stock into
	 * this instance of the vending machine. 
	 * @throws FileNotFoundException If issues reading the file.
	 *********************************************************************/
	public VendingMachine(String filename) throws FileNotFoundException{
		//Open the file to read with the scanner
		File file = new File(filename);
		Scanner scan = new Scanner(file);

		//Determine the total number of items listed in the file
		int totalItem = 0;
		while (scan.hasNextLine()){
			scan.nextLine();
			totalItem++;
		} //End while another item in file
		//Create the array of stock with the appropriate number of items
		stock = new Item[totalItem];
		scan.close();

		//Open the file again with a new scanner to read the items
		scan = new Scanner(file);
		int itemQuantity = -1;
		double itemPrice = -1;
		String itemDesc = "";
		int count = 0;
		String line = "";

		//Read through the items in the file to get their information
		//Create the item objects and put them into the array of stock
		while(scan.hasNextLine()){
			line = scan.nextLine();
			String[] tokens = line.split(",");
			try {
				itemDesc = tokens[0];
				itemPrice = Double.parseDouble(tokens[1]);
				itemQuantity = Integer.parseInt(tokens[2]);

				stock[count] = new Item(itemDesc, itemPrice, itemQuantity);
				count++;
			} catch (NumberFormatException nfe) {
				System.out.println("Bad item in file " + filename + 
						" on row " + (count+1) + ".");
			}
		} //End while another item in file
		scan.close();

		//Initialize the money data variable.
		money = 0.0;
	} //End VendingMachine constructor
	public void setMoney(Double money){
		this.money = this.money + money;
	}
	public double getMoney(){
		return money;
	}
	public Item[] getStock(){
		return stock;
	}

	//method to handle the vending transaction
	public void vend(Item[] userMachine){
		Scanner scnr = new Scanner(System.in);
		double userMoney = 0;
		double userChoice = 0;
		int userInput = 0;


		do{
			try{
				System.out.print("\nPlease enter some money into the machine.(Enter -1 to exit.)");
				userChoice = scnr.nextFloat();
			}catch(InputMismatchException e){
				scnr.next();
			}
			userMoney += userChoice;
			//exits the machine if user desires
			if(userChoice == -1){
				System.out.printf("You did not buy anything from this machine. Your change is $%.2f.\n",(userMoney+1));
				break;
			}
			if(userMoney < 0){
				userMoney -= userChoice;
				System.out.println("Please input a proper amount.");
				continue;
			}
			//lets user make a choice of item in the vending machine and handles the transaction appropriately
			else if(userChoice >= 0){
				System.out.printf("\nYou now have $%.02f to spend. Please make a selection (enter 0 to exit)",userMoney );
				try{
					userInput = scnr.nextInt();
				}catch(InputMismatchException e){
					scnr.next();
				}
			}
			if(userInput == 0){
				continue;
			}
			while(userInput > userMachine.length){
				System.out.print("Invalid selection please try again: ");
				userInput = scnr.nextInt();

			}	

			if(userInput != 0){
				if(userMoney < userMachine[userInput-1].getPrice()){
					System.out.print(outputMessage(1));
					continue;

				}
				while(userMachine[userInput-1].getQuantity() == 0){
					System.out.print(outputMessage(2));
					System.out.printf("\nYou now have $%.02f to spend. Please make a selection (enter 0 to exit)",userMoney );
					userInput = scnr.nextInt();

				}

				System.out.printf("You bought %s for $%.02f your change is $%.02f.\n",userMachine[userInput-1].getDescription(),userMachine[userInput-1].getPrice(), (userMoney - userMachine[userInput-1].getPrice()));
				userMachine[userInput-1].setQuantity(userMachine[userInput-1].getQuantity() - 1);
				setMoney(userMachine[userInput-1].getPrice());
				break;
			}


			else{
				System.out.println("Invalid choice. Please try again");
				continue;
			}


		}while(userMoney != -1);
		scnr.nextLine();
	}
	//returns the proper message if vend has an issue
	public String outputMessage(Integer message){
		String msg = "";
		String msg1 = "You do not have enough money. Please add more money or exit.";
		String msg2 = "Sorry the machine is currently out of that item.";
		switch(message){
		case(1):
			msg = msg1;
		break;
		case(2):
			msg = msg2;
		break;

		}
		return msg;
	}
	//Creates and prints the menu of the vending machine
	public void printMenu(Item[] machineChoice){

		System.out.format("Menu:\n%s %5s %10s %5s\n","Item#","Item","Price","Qty");
		for(int i=0; i < machineChoice.length; ++i){
			System.out.printf("  %-4s %-9s %-7.2f %s\n", (i+1), machineChoice[i].getDescription(),machineChoice[i].getPrice(),machineChoice[i].getQuantity());
		}
		vend(machineChoice);

	}

}

