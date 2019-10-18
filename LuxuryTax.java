
public class LuxuryTax extends Plot {
	
	public LuxuryTax(int x, int y) {
		super("Luxury Tax", x, y);
	}
	
	public void invoke(Player player) {
		player.myNetWorth -= 100;
	}

}
