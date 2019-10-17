import java.util.ArrayList;

import javax.swing.JOptionPane;

public class Player {

	String mySymbol;
	int myOrderNumber;
	int myNetWorth;

	ArrayList<Property> myProperties;
	
	public Player(int money, int orderNum) {
		myNetWorth = money;
		mySymbol = JOptionPane.showInputDialog("What symbol would you like");
		myOrderNumber = orderNum;
	}
	
	public String getSymbol() {
		return mySymbol;
	}
	
	public int getNetWorth() {
		return myNetWorth;
	}
	
	public int rollDice() {
		return ((int) (Math.random() * 6) + 1) + ((int) (Math.random() * 6) + 1);
	}
	
	public String toString() {
		String toReturn = "";
		
		toReturn += "Symbol: " + mySymbol + "\n" +
					"Order Number: " + myOrderNumber + "\n" +
					"Net Worth: " + myNetWorth + "\n";
		
		return toReturn;
	}
}
