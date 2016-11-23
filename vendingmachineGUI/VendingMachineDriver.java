package vending_Machine;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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


	public VendingMachineDriver (String title){
		//Set up the window
		this.setSize(1000, 300); //set window size
		this.setTitle(title); //set window title
		this.setResizable(true); //do not allow the user to resize the window
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
		JFrame drink = new JFrame();
		JFrame snack = new JFrame();
		frame2.setSize(1000, 300); //set window size
		frame2.setResizable(true); //do not allow the user to resize the window
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
						double userMoney = Double.parseDouble(moneyInput.getText());
						System.out.printf("%.2f", userMoney);
					}
				});
				this.dispose();
				drinkMachine = true;
			}else{
				frame2.setVisible(true);
				moneyInput.addActionListener(this);
				this.dispose();
				moneyInput.addActionListener(new ActionListener(){

					public void actionPerformed(ActionEvent e) {
						double userMoney = Double.parseDouble(moneyInput.getText());
						System.out.printf("%.2f", userMoney);
					}
				});
			}

		}
	}	
	public String getSelectedItem() {
		return (String)vendChoice.getSelectedItem();    
	}


	public static void main(String[] args){
		VendingMachineDriver machineChoice = new VendingMachineDriver("Vending Machine Selection");
		machineChoice.setVisible(true);
	}

}
