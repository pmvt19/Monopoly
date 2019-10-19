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
		
		fillBoard();
	}
	
	public void newPosition(Player player, int movement) {
		//Logic for the movement around the board
		//DO NOT FORGET ABOUT THIS
		
		int curX = player.x;
		int curY = player.y;
		
		for (int i = 0; i < movement; i++) {
			if (curY == 0 && curX != 0) {
				curX -= 1;
			} else if (curY == 10 && curX != 10) {
				curX += 1;
			} else if (curX == 0 && curY != 10) {
				curY += 1;
			} else if (curX == 10 && curY != 0) {
				curY -= 1; 
			}
		}
		
		player.updateLocation(curX, curY);
		
	}
	
	public void checkIfPassedGo(Player player) {
		
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
		plot[2][10] = new ElectricCompany(2, 10); //This is supposed to be electric company but im too lazy to make it now lol
		plot[3][10] = new Property("States Avenue", 140, 10, 70, 3, 10);
		plot[4][10] = new Property("Virginia Avenue", 160, 12, 80, 4, 10);
		plot[5][10] = new Railroad("Pennsylvania Railroad", 5, 10);
		plot[6][10] = new Property("St. James Place", 180, 14, 90, 6, 10);
		plot[7][10] = new CommunityChest(7, 10);
		plot[8][10] = new Property("Tennessee Avenue", 180, 14, 90, 8, 10);
		plot[9][10] = new Property("New York", 200, 16, 100, 9, 10);
		plot[10][10] = new FreeParking(10, 10); //Free parking lollll
		plot[10][9] = new Property("Kentucky Avenue", 220, 18, 110, 10, 9);
		plot[10][8] = new Chance(10, 8);
		plot[10][7] = new Property("Indiana Avenue", 220, 18, 110, 10, 7);
		plot[10][6] = new Property("Illinois Avenue", 240, 20, 120, 10, 6);
		plot[10][5] = new Railroad("B. & O.", 10, 5);
		plot[10][4] = new Property("Atlantic Avenue", 260, 22, 130, 10, 4);
		plot[10][3] = new Property("Ventnor Avenue", 260, 22, 130, 10, 3);
		plot[10][2] = new WaterWorks(10, 2);
		plot[10][1] = new Property("Marvin Gardens", 280, 24, 140, 10, 1);
		plot[10][0] = new Jail(10, 0); //Go to jail lol
		plot[9][0] = new Property("Pacific Avenue", 300, 26, 150, 9, 0);
		plot[8][0] = new Property("North Carolina Avenue", 300, 26, 150, 8, 0);
		plot[7][0] = new CommunityChest(7, 0);
		plot[6][0] = new Property("Pennsylvania Avenue", 320, 28, 160, 6, 0);
		plot[5][0] = new Railroad("Short Line", 5, 0);
		plot[4][0] = new Chance(4, 0);
		plot[3][0] = new Property("Park Place", 350, 35, 175, 3, 0);
		plot[2][0] = new LuxuryTax(2, 0); //Luxury Tax
		plot[1][0] = new Property("Boardwalk", 400, 50, 200, 1, 0);
		
	}
}
