import java.util.ArrayList;

import javax.swing.JOptionPane;

public class Player 
{

	String mySymbol;
	int myOrderNumber;
	int myNetWorth;
	ArrayList<Property> myProperties;
	
	public Player(int money)
	{
		myNetWorth = money;
		mySymbol = JOptionPane.showInputDialog("What symbol would you like");
	}
	
	public String getSymbol()
	{
		return mySymbol;
	}
	
	public int getNetWorth()
	{
		return myNetWorth;
	}
}
