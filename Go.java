
public class Go extends Plot {

	int passAmount;
	
	public Go(String name) {
		super(name, 0, 0);
	}
	
	public void invoke(Player player) {
		player.myNetWorth += 200;
	}
	
	public boolean isPassed(Player player) {
		if (player.x == xCoor && player.y == yCoor) {
			return true;
		}
		return false;
	}
	
	

}
