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
		myProperties = new ArrayList<Property>();
	}
	
	public String getSymbol() {
		return mySymbol;
	}
	
	public int getNetWorth() {
		return myNetWorth;
	}
	
	public RollResult rollDice() {
		boolean rollAgain = false;
		int firstDice = (int) (Math.random() * 6) + 1;
		int secondDice = (int) (Math.random() * 6) + 1;
		
		int rollTotal = firstDice + secondDice;
		
		if (firstDice == secondDice) {
			rollAgain = true;
		}
		return new RollResult(rollAgain, rollTotal);
	}
	
	public void updateLocation(int newX, int newY) {
		lastX = x;
		lastY = y;
		x = newX;
		y = newY;
	}
	
	public static boolean canPay(Player player, int amount) {
		if (player.myNetWorth - amount < 0) {
			return false;
		}
		return true;
	}
	
	/*public boolean passedGo(int lastX, int lastY, int x, int y) {
		if ((lastY <= y && lastX < x) || (x == 0 && y == 0) || )
	}*/
	
	public String toString() {
		String toReturn = "";
		
		toReturn += "Symbol: " + mySymbol + "\n" +
					"Order Number: " + myOrderNumber + "\n" +
					"Net Worth: " + myNetWorth + "\n" +
					"Num of Properties: " + myProperties.size() + "\n" +
					"My X Position: " + x + "\n" + 
					"My Y Position: " + y;
		
		return toReturn;
	}
}
