import java.util.ArrayList;

public class Jail extends Plot {
	
	ArrayList<Player> jailedPlayers = new ArrayList<Player>();
	ArrayList<Integer> numOfTurnsJailed = new ArrayList<Integer>();
	
	public Jail(int x, int y) {
		super("Jail", x, y);
	}
	
	public void addPlayerToJail(Player player) {
		jailedPlayers.add(player);
		numOfTurnsJailed.add(0);
	}
	
	public void updateJailTime(Player player) {
		//if ()
	}

}
