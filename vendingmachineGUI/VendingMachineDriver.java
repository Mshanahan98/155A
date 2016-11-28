package vending_Machine;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class VendingMachineDriver extends JFrame implements ActionListener{

	private JButton A,B,C,D,E,F;
	private JButton one,two,three,four,five,six;
	private JButton getChange;
	private JButton addMoney;
	private JButton vend;
	private JLabel background;
	private JLabel machineChoice;
	private JLabel inputMoney;
	private JLabel search;
	private JLabel itemInfo;
	private JLabel makeSelection;
	private JLabel moneyLeft;
	private JLabel itemSelection;
	private JLabel error;
	private JComboBox<String> vendChoice;
	private JTextField moneyInput;
	private JTextField itemSearch;
	private JTextField moneyRemain;
	private JTextField itemSelected;
	private double userMoney = 0;
	private JList<String> items;
	private JFrame frame2;
	private JFrame frame3;
	public String[] b;
	private VendingMachine drinks = null;// creates a VendingMachine object for the drink machine
	private VendingMachine snacks = null;

	public void setUserMoney(Double money){
		this.userMoney = money;
	}
	public double getUserMoney(){
		return userMoney;
	}
	public void setB(String[] c){
		this.b = c;
	}
	public String[] getB(){
		return b;
	}

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


	public void money(){
		frame2 = new JFrame();
		frame2.setTitle("Input Money");
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
		error = new JLabel();
		error.setBounds(450, 125, 500, 100);
		error.setFont (error.getFont ().deriveFont (30.0f));
		background.add(error);
		moneyInput = new JTextField();
		moneyInput.setBounds(450, 20, 500, 100);
		moneyInput.setFont (moneyInput.getFont ().deriveFont (20.0f));
		background.add(moneyInput);
		moneyInput.addActionListener(this);
		this.setVisible(false);
		frame2.setVisible(true);
	}

	public String getSelectedItem() {
		return (String)vendChoice.getSelectedItem();    
	}

	public void machine(VendingMachine machine){

		try {
			drinks = new VendingMachine("data/drinks.txt");
			snacks = new VendingMachine("data/snacks.txt");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		frame3 = new JFrame(getSelectedItem() + " Vending Machine");
		frame3.setSize(1600, 1600); //set window size
		frame3.setResizable(false); //do not allow the user to resize the window
		frame3.setDefaultCloseOperation(EXIT_ON_CLOSE); //quit the program when the red x is clicked
		background = new JLabel();
		frame3.add(background);
		search = new JLabel("Search for item: ");
		search.setBounds(20, 200, 300, 75);
		search.setFont (search.getFont ().deriveFont (30.0f));
		background.add(search);
		itemSearch = new JTextField();
		itemSearch.setBounds(275, 200, 300, 75);
		itemSearch.setFont (search.getFont ().deriveFont (30.0f));
		background.add(itemSearch);
		makeSelection = new JLabel("Make a selection:");
		makeSelection.setBounds(220, 350, 600, 300);
		makeSelection.setFont (search.getFont ().deriveFont (50.0f));
		background.add(makeSelection);
		itemInfo = new JLabel();
		itemInfo.setBounds(300, 300, 400, 75);
		itemInfo.setFont (itemInfo.getFont ().deriveFont (30.0f));
		background.add(itemInfo);

		A = new JButton("A");
		A.setBounds(200, 600, 75, 75);
		A.setFont (A.getFont ().deriveFont (45.0f));
		background.add(A);
		B = new JButton("B");
		B.setBounds(300, 600, 75, 75);
		B.setFont (B.getFont ().deriveFont (45.0f));
		background.add(B);
		C = new JButton("C");
		C.setBounds(200, 700, 75, 75);
		C.setFont (C.getFont ().deriveFont (45.0f));
		background.add(C);
		D = new JButton("D");
		D.setBounds(300, 700, 75, 75);
		D.setFont (D.getFont ().deriveFont (45.0f));
		background.add(D);
		E = new JButton("E");
		E.setBounds(200, 800, 75, 75);
		E.setFont (E.getFont ().deriveFont (45.0f));
		background.add(E);
		F = new JButton("F");
		F.setBounds(300, 800, 75, 75);
		F.setFont (F.getFont ().deriveFont (45.0f));
		background.add(F);
		one = new JButton("1");
		one.setBounds(450, 600, 75, 75);
		one.setFont (one.getFont ().deriveFont (45.0f));
		background.add(one);
		two = new JButton("2");
		two.setBounds(550, 600, 75, 75);
		two.setFont (two.getFont ().deriveFont (45.0f));
		background.add(two);
		three = new JButton("3");
		three.setBounds(450, 700, 75, 75);
		three.setFont (three.getFont ().deriveFont (45.0f));
		background.add(three);
		four = new JButton("4");
		four.setBounds(550, 700, 75, 75);
		four.setFont (four.getFont ().deriveFont (45.0f));
		background.add(four);
		five = new JButton("5");
		five.setBounds(450, 800, 75, 75);
		five.setFont (five.getFont ().deriveFont (45.0f));
		background.add(five);
		six = new JButton("6");
		six.setBounds(550, 800, 75, 75);
		six.setFont (six.getFont ().deriveFont (45.0f));
		background.add(six);

		//		String[] choices = {"Tacos", "Cookies", "Sandwich"};
		VendingMachine a = null;
		if(getSelectedItem().equals("Drinks")){
			a = drinks;
		}
		if(getSelectedItem().equals("Snacks")){
			a = snacks;
		}
		setB(a.getMenu(a.getStock()));
		items = new JList<String>(getB());
		items.setBounds(1100,100,500,1250);
		items.setFont(items.getFont().deriveFont((40.0f)));
		background.add(items);
		itemSelection = new JLabel("Item Selection: ");
		itemSelection.setBounds(150, 1000, 300, 75);
		itemSelection.setFont (itemSelection.getFont ().deriveFont (30.0f));
		background.add(itemSelection);
		moneyLeft = new JLabel("Money Remaining: ");
		moneyLeft.setBounds(150, 1200, 300, 75);
		moneyLeft.setFont (moneyLeft.getFont ().deriveFont (30.0f));
		background.add(moneyLeft);
		moneyRemain = new JTextField();
		moneyRemain.setBounds(500, 1200, 500, 100);
		moneyRemain.setFont (moneyRemain.getFont ().deriveFont (30.0f));
		moneyRemain.setEditable(false);
		moneyRemain.setText(String.format("$%.2f", getUserMoney()));
		background.add(moneyRemain);
		itemSelected = new JTextField();
		itemSelected.setBounds(500, 1000, 500, 100);
		itemSelected.setFont (moneyInput.getFont ().deriveFont (30.0f));
		background.add(itemSelected);
		getChange = new JButton("Get Change");
		getChange.setBounds(160, 1400, 200, 100);
		getChange.setFont (getChange.getFont ().deriveFont (20.0f));
		background.add(getChange);
		addMoney = new JButton("Add Money");
		addMoney.setBounds(500, 1400, 200, 100);
		addMoney.setFont (addMoney.getFont ().deriveFont (20.0f));
		background.add(addMoney);
		vend = new JButton("Vend!");
		vend.setBounds(1200, 1400, 200, 100);
		vend.setFont (vend.getFont ().deriveFont (20.0f));
		background.add(vend);

		addMoney.addActionListener(this);
		getChange.addActionListener(this);
		itemSearch.addActionListener(this);
		frame3.setVisible(true);
	}

	public void actionPerformed(ActionEvent event) {
		try {
			drinks = new VendingMachine("data/drinks.txt");
			snacks = new VendingMachine("data/snacks.txt");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

		if(event.getSource() instanceof JComboBox){
			money();	
		}
		if(event.getSource() instanceof JTextField){
			if(event.getSource()==moneyInput){
				try{
					setUserMoney(Double.parseDouble(moneyInput.getText())+ getUserMoney());
				}catch(NumberFormatException x){
					error.setText("Error: Invalid entry.");
				}
				if(getUserMoney()<0){
					error.setText("Error: Invalid amount.");
					setUserMoney(0.0);
				}
				if(getUserMoney()>0){
					if(getSelectedItem().equals("Drinks")){
						machine(drinks);
					frame2.setVisible(false);
					}


					if(getSelectedItem().equals("Snacks")){
						machine(snacks);
					frame2.setVisible(false);
					}
				}
			}
			if(event.getSource()==itemSearch){
				if(getSelectedItem().equals("Drinks")){
					itemInfo.setText(drinks.itemSearch(itemSearch.getText(), getB()));
				}
				if(getSelectedItem().equals("Snacks")){
					itemInfo.setText(snacks.itemSearch(itemSearch.getText(), getB()));
				}
			}
		}
		if(event.getSource() instanceof JButton){
			if(event.getSource()==addMoney){
				money();
				frame3.setVisible(false);
			}
			if(event.getSource()==getChange){
				setUserMoney(0.0);
				moneyRemain.setText(String.format("$%.2f", getUserMoney()));
				this.setVisible(true);
				frame3.setVisible(false);
				frame2.setVisible(false);
			}

		}

	}	

	public static void main(String[] args){
		VendingMachineDriver machineChoice = new VendingMachineDriver("Vending Machine Selection");
		machineChoice.setVisible(true);
	}

}
