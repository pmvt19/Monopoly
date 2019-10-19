
public class ElectricCompany extends Property implements Multiplier {
	
	int multi = 4;
	
	public ElectricCompany(int price, int rent, int mortgage, int x, int y) {
		super("Electric Company", price, rent, mortgage, x, y);
	}
	
	public void invoke(Player player, int roll, Gameboard game) {
		
		if (((ElectricCompany) game.plot[2][10]).myOwner != player) {
			player.myNetWorth -= (multi * roll);
		}
		
		
	}

}
