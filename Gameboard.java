import java.util.ArrayList;

public class Gameboard {
	Plot[][] plot;
	ArrayList<Player> players;
	
	public Gameboard(int amountOfPlayers) {
		players = new ArrayList<Player>();
		for(int x = 0; x < amountOfPlayers; x++) {
			players.add(new Player(1500, x + 1));
		}
		
		
		
		
		
		plot = new Plot[11][11];
		
		
	}
}
