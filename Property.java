import javax.swing.JOptionPane;

public class Property extends Plot {
	
	
	int myPrice;
	int myRentAmount;
	int myMortgageAmount;
	boolean isOwned;
	Player myOwner;
	
	public Property(String name, int price, int rent, int mortgage, int x, int y) {
		super(name, x, y);
		myPrice = price;
		myRentAmount = rent;
		myMortgageAmount = mortgage;
		isOwned = false;
	}
	
	public String getName() {
		return myName;
	}
	
	public int getPrice() {
		return myPrice;
	}
	
	public int getRent() {
		return myRentAmount;
	}

	public int getMortgage() {
		return myMortgageAmount;
	}
	
	public String toString() {
		return myName;
	}
	
	public void invoke(Player player) {
		if (!isOwned) {
			String userAnswer = JOptionPane.showInputDialog("Would " + player.mySymbol +  " Like to Buy " + myName + "? - Yes or No");
			if (userAnswer.equals("Yes") && Player.canPay(player, myPrice)) {
				System.out.println("ENTERED");
				player.myNetWorth -= myPrice;
				player.myProperties.add(this);
				isOwned = true;
			}
		} else {
			if (player != myOwner) { 
				player.myNetWorth -= myRentAmount;
				if (Player.isNegative(player)) {
					player.bankrupt = true;
				}
			}
		}
	}
	
	public void buyProperty(Player player, Gameboard game) {
		if (!isOwned) {
			//String userAnswer = JOptionPane.showInputDialog("Would " + player.mySymbol +  " Like to Buy " + myName + "? - Yes or No");
			//if (userAnswer.equals("Yes") && Player.canPay(player, myPrice)) {
				//System.out.println("ENTERED");
				player.myNetWorth -= myPrice;
				player.myProperties.add(this);
				myOwner = player;
				isOwned = true;
				if (utilityOwnerCheck(player, game)) {
					((ElectricCompany) game.plot[2][10]).multi = 10;
					((WaterWorks) game.plot[10][2]).multi = 10;
				}
			//}
		}
	}
	
	public void payRent(Player player) {
		if (player != myOwner) { 
			player.myNetWorth -= myRentAmount;
			myOwner.myNetWorth += myRentAmount;
			if (Player.isNegative(player)) {
				player.bankrupt = true;
			}
		}
	}
	
	public boolean utilityOwnerCheck(Player player, Gameboard game) {
		return ((ElectricCompany) game.plot[2][10]).myOwner == player && ((WaterWorks) game.plot[10][2]).myOwner == player;
	}
	
	
}
