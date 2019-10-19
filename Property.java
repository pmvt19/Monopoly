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
				player.myNetWorth -= myPrice;
				player.myProperties.add(this);
				isOwned = true;
			}
		} else {
			if (player != myOwner) { 
				player.myNetWorth -= myRentAmount;
			}
		}
	}
	
	
}
