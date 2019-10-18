import java.util.ArrayList;

import javax.swing.JOptionPane;

public class Player {

	String mySymbol;
	int myOrderNumber;
	int myNetWorth;
	ArrayList<Property> myProperties;
	int lastX = 0;
	int lastY = 0;
	int x = 0;
	int y = 0;
	int numRailroads = 0;
	
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
	
	public void updateLocation(int newX, int newY) {
		lastX = x;
		lastY = y;
		x = newX;
		y = newY;
	}
	
	/*public boolean passedGo(int lastX, int lastY, int x, int y) {
		if ((lastY <= y && lastX < x) || (x == 0 && y == 0) || )
	}*/
	
	public String toString() {
		String toReturn = "";
		
		toReturn += "Symbol: " + mySymbol + "\n" +
					"Order Number: " + myOrderNumber + "\n" +
					"Net Worth: " + myNetWorth + "\n";
		
		return toReturn;
	}
}
