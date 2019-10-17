import javax.swing.JOptionPane;

public class Property extends Plot {
	
	
	int myPrice;
	int myRentAmount;
	int myMortgageAmount;
	boolean isOwned;
	
	public Property(String name, int price, int rent, int mortgage) {
		super(name);
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
	
	public void invoke(Player player) {
		if (!isOwned) {
			String userAnswer = JOptionPane.showInputDialog("Would You Like to Buy this Property? - Yes or No");
			if (userAnswer.equals("Yes")) {
				player.myNetWorth -= myPrice;
				player.myProperties.add(this);
				isOwned = true;
			}
		} else {
			player.myNetWorth -= myRentAmount;
		}
	}
}
