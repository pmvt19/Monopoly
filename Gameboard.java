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
	
	public void fillBoard() {
		plot[0][0] = new Go("Go"); //You need to make a different class for each plot that is not a property
		plot[0][1] = new Property("Mediteranean Avenue", 60, 2, 30, 0, 1);
		plot[0][2] = new CommunityChest(0, 2);
		plot[0][3] = new Property("Baltic Avenue", 60, 4, 30, 0, 3);
		plot[0][4] = new IncomeTax(0, 4);
		plot[0][5] = new Railroad("Reading Railroad", 0, 5);
		plot[0][6] = new Property("Oriental Avenue", 100, 6, 50, 0, 6);
		plot[0][7] = new Chance(0,7);
		plot[0][8] = new Property("Vermont Avenue", 100, 6, 50, 0, 8);
		plot[0][9] = new Property("Connecticut Avenue", 120, 8, 60, 0, 9);
		plot[0][10] = new Jail(0, 10);
		plot[1][10] = new Property("St. Charles Place", 140, 10, 70, 1, 10);
		plot[2][10] = null; //This is supposed to be electric company but im too lazy to make it now lol
		plot[3][10] = new Property("States Avenue", 140, 10, 70, 3, 10);
		plot[4][10] = new Property("Virginia Avenue", 160, 12, 80, 4, 10);
		plot[5][10] = new Railroad("Pennsylvania Railroad", 5, 10);
		plot[6][10] = new Property("St. James Place", 180, 14, 90, 6, 10);
		plot[7][10] = new CommunityChest(7, 10);
		plot[8][10] = new Property("Tennessee Avenue", 180, 14, 90, 8, 10);
		plot[9][10] = new Property("New York", 200, 16, 100, 9, 10);
		
	}
}
