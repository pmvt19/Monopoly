
public class WaterWorks extends Property {
	
	int multi = 4;
	
	public WaterWorks(int price, int rent, int mortgage, int x, int y) {
		super("Water Works", price, rent, mortgage, x, y);
	}
	
	public void invoke(Player player, int roll, Gameboard game) {
		
		if (((WaterWorks) game.plot[10][2]).myOwner != player) {
			player.myNetWorth -= (multi * roll);
			Player owner = ((WaterWorks) game.plot[10][2]).myOwner;
			owner.myNetWorth += (multi * roll);
		}
		
		
	}

}
