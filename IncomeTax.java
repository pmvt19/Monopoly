
public class IncomeTax extends Plot{

	public IncomeTax(int x, int y) {
		super("Income Tax", x, y);
	}
	
	public void invoke(Player player) {
		player.myNetWorth -= 200;
	}
	
	

}
