package vending_Machine;

import java.io.FileNotFoundException;
import java.util.Scanner;

public class VendingMachineDriver {

	public static void main(String[] args){

		boolean exit = false;
		Scanner scnr = new Scanner(System.in);
		VendingMachine drinks = null;// creates a VendingMachine object for the drink machine
		VendingMachine snacks = null;// creates a VendingMachine object for the snacks machine

		//reads in the correct file and sends it to VendingMachine constructor to create a stock[] 
		//of each file
		try {
			drinks = new VendingMachine("data/drinks.txt");
			snacks = new VendingMachine("data/snacks.txt");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		System.out.println("Welcome to Matt's Super Vending Machines!");
		System.out.println("\nI sense that you are hungry or thirsty...");

		// allows user to chose their machine or exit the program
		while(!exit){

			System.out.println("\nPlease select a vending machine:");
			System.out.print("A-Drinks, B-Snacks, X-Exit: ");
			String machineChoice = scnr.next();


			if(machineChoice.equalsIgnoreCase("a")){
				drinks.printMenu(drinks.getStock());
			}
			else if(machineChoice.equalsIgnoreCase("b")){
				snacks.printMenu(snacks.getStock());
			}else if(machineChoice.equalsIgnoreCase("x")){
				exit = true;
				break;
			}
			else{
				System.out.println("Invalid selection try again.");
			}

		}
		//gets the money earned from snack machine and drink machine and displays it for the total earnings
		System.out.printf("\nThe vending machine has made $%.02f.\nThank you for your business!", (snacks.getMoney()+drinks.getMoney()));
		scnr.close();
	}

}
