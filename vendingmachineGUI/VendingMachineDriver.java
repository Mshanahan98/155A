package vending_Machine;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import java.io.FileNotFoundException;
import java.util.Scanner;

public class VendingMachineDriver extends JFrame implements ActionListener{

	private JButton A,B,C,D,E,F;
	private JButton one,two,three,four,five,six;
	private JLabel background;
	private JLabel machineChoice;
	private JLabel inputMoney;
	private JLabel search;
	private JLabel itemInfo;
	private JLabel makeSelection;
	private JLabel moneyLeft;
	private JLabel itemSelection;
	private JComboBox vendChoice;
	private JTextField moneyInput;
	private JTextField itemSearch;
	private JTextField moneyRemain;
	private JTextField itemSelected;
	private double userMoney = 0;
	private JLabel numButs;
	private JLabel letButs;
	private JList items;
	
	public VendingMachineDriver (String title){
		//Set up the window
		this.setSize(1000, 300); //set window size
		this.setTitle(title); //set window title
		this.setResizable(false); //do not allow the user to resize the window
		this.setDefaultCloseOperation(EXIT_ON_CLOSE); //quit the program when the red x is clicked
		//The background label to which all other components will be added
		background = new JLabel();
		this.add(background); //add the background to the JFrame	

		machineChoice = new JLabel("Please Select A Vending Machine.");
		machineChoice.setBounds(50, 20, 500, 100);
		machineChoice.setFont (machineChoice.getFont ().deriveFont (20.0f));
		background.add(machineChoice);
		String[] machines = {"Drinks", "Snacks"};
		vendChoice = new JComboBox(machines);
		vendChoice.setBounds(400, 20, 500, 100);
		vendChoice.setFont (vendChoice.getFont ().deriveFont (20.0f));
		background.add(vendChoice);

		vendChoice.addActionListener(this);
	}



	@Override
	public void actionPerformed(ActionEvent event) {

		VendingMachine drinks = null;// creates a VendingMachine object for the drink machine
		VendingMachine snacks = null;// creates a VendingMachine object for the snacks machine
		boolean drinkMachine = false;
		JFrame frame2 = new JFrame();
		frame2.setSize(1000, 300); //set window size
		frame2.setResizable(false); //do not allow the user to resize the window
		frame2.setDefaultCloseOperation(EXIT_ON_CLOSE); //quit the program when the red x is clicked
		//The background label to which all other components will be added
		background = new JLabel();
		frame2.add(background); //add the background to the JFrame
		inputMoney = new JLabel("Please enter money into the machine: ");
		inputMoney.setBounds(50, 20, 500, 100);
		inputMoney.setFont (machineChoice.getFont ().deriveFont (20.0f));
		background.add(inputMoney);
		moneyInput = new JTextField();
		moneyInput.setBounds(450, 20, 500, 100);
		moneyInput.setFont (moneyInput.getFont ().deriveFont (20.0f));
		background.add(moneyInput);

		//reads in the correct file and sends it to VendingMachine constructor to create a stock[] 
		//of each file
		try {
			drinks = new VendingMachine("data/drinks.txt");
			snacks = new VendingMachine("data/snacks.txt");
		} catch (FileNotFoundException e) {
		}

		if(event.getSource() instanceof JComboBox){ 
			frame2.setTitle("Input Money");
			if(getSelectedItem().equals("Drinks")){
				frame2.setVisible(true);
				moneyInput.addActionListener(new ActionListener(){

					public void actionPerformed(ActionEvent e) {
						double userMoney = 0;
						try{
							userMoney = Double.parseDouble(moneyInput.getText());
						}catch(NumberFormatException h){
							System.out.println("Error");
						}
						System.out.printf("%.2f", userMoney);
					}
				});
				this.dispose();
				drinkMachine = true;
				if(drinkMachine = true & userMoney > 0){
					machine(drinks);
				}	
			}else{
				frame2.setVisible(true);
				moneyInput.addActionListener(this);
				this.dispose();
				moneyInput.addActionListener(new ActionListener(){

					public void actionPerformed(ActionEvent e) {
						try{
							userMoney = Double.parseDouble(moneyInput.getText());
						}catch(NumberFormatException h){
							System.out.println("Error");
						}
						System.out.printf("%.2f", userMoney);
					}
				});
			}
			
				machine(drinks);
			

		}
	}	
	public String getSelectedItem() {
		return (String)vendChoice.getSelectedItem();    
	}
	public void machine(VendingMachine machine){
		JFrame frame3 = new JFrame(getSelectedItem() + " Vending Machine");
		frame3.setSize(1600, 1600); //set window size
		frame3.setResizable(false); //do not allow the user to resize the window
		frame3.setDefaultCloseOperation(EXIT_ON_CLOSE); //quit the program when the red x is clicked
		frame3.setVisible(true);
		background = new JLabel();
		frame3.add(background);
		search = new JLabel("Search for item: ");
		search.setBounds(150, 200, 300, 75);
		search.setFont (search.getFont ().deriveFont (30.0f));
		background.add(search);
		itemSearch = new JTextField();
		itemSearch.setBounds(500, 200, 300, 75);
		itemSearch.setFont (search.getFont ().deriveFont (30.0f));
		background.add(itemSearch);
		itemSelection = new JLabel("Make a selection:");
		itemSelection.setBounds(450, 350, 600, 300);
		itemSelection.setFont (search.getFont ().deriveFont (50.0f));
		background.add(itemSelection);
	
		A = new JButton("A");
		A.setBounds(400, 700, 75, 75);
		A.setFont (A.getFont ().deriveFont (45.0f));
		background.add(A);
		B = new JButton("B");
		B.setBounds(500, 700, 75, 75);
		B.setFont (B.getFont ().deriveFont (45.0f));
		background.add(B);
		C = new JButton("C");
		C.setBounds(400, 800, 75, 75);
		C.setFont (C.getFont ().deriveFont (45.0f));
		background.add(C);
		D = new JButton("D");
		D.setBounds(500, 800, 75, 75);
		D.setFont (D.getFont ().deriveFont (45.0f));
		background.add(D);
		E = new JButton("E");
		E.setBounds(400, 900, 75, 75);
		E.setFont (E.getFont ().deriveFont (45.0f));
		background.add(E);
		F = new JButton("F");
		F.setBounds(500, 900, 75, 75);
		F.setFont (F.getFont ().deriveFont (45.0f));
		background.add(F);
		one = new JButton("1");
		one.setBounds(700, 700, 75, 75);
		one.setFont (one.getFont ().deriveFont (45.0f));
		background.add(one);
		two = new JButton("2");
		two.setBounds(800, 700, 75, 75);
		two.setFont (two.getFont ().deriveFont (45.0f));
		background.add(two);
		three = new JButton("3");
		three.setBounds(700, 800, 75, 75);
		three.setFont (three.getFont ().deriveFont (45.0f));
		background.add(three);
		four = new JButton("4");
		four.setBounds(800, 800, 75, 75);
		four.setFont (four.getFont ().deriveFont (45.0f));
		background.add(four);
		five = new JButton("5");
		five.setBounds(700, 900, 75, 75);
		five.setFont (five.getFont ().deriveFont (45.0f));
		background.add(five);
		six = new JButton("6");
		six.setBounds(800, 900, 75, 75);
		six.setFont (six.getFont ().deriveFont (45.0f));
		background.add(six);
		items = new JList(machine.printMenu(machine.getStock()));
		items.setBounds(1100,100,100,800);
		items.setFont(items.getFont().deriveFont((20.0f)));
		background.add(items);
		
	}


	public static void main(String[] args){
		VendingMachineDriver machineChoice = new VendingMachineDriver("Vending Machine Selection");
		machineChoice.setVisible(true);
	}

}
