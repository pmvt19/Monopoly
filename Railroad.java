import javax.swing.JOptionPane;

public class Railroad extends Property{

	public Railroad(String name, int x , int y) {
		super(name, 200, 25, 100, x, y);		
	}
	
	public void invoke(Player player) {
		if (!isOwned) {
			String userAnswer = JOptionPane.showInputDialog("Would " + player.mySymbol +  " Like to Buy " + myName + "? - Yes or No");
			if (userAnswer.equals("Yes")) {
				player.myNetWorth -= myPrice;
				player.myProperties.add(this);
				isOwned = true;
				player.numRailroads++;
				checkRent(player);
			}
		} else {
			if (player != myOwner) {
				player.myNetWorth -= myRentAmount;
			}
		}
	}
	
	public void checkRent(Player player) {
		int numRails = player.numRailroads;
		if (numRails == 1) {
			myRentAmount = 25;
		} else if (numRails == 2) {
			myRentAmount = 50;
		} else if (numRails == 3) {
			myRentAmount = 100;
		} else if (numRails == 4) {
			myRentAmount = 200;
		}
	}
}
