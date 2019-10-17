import javax.swing.JOptionPane;
//Used to run the game
public class GameTester {
	static int totalNumPlayers;
	static Gameboard game;
	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		
		String numberOfPlayersString = JOptionPane.showInputDialog("How Many Players?");
		
		int numberOfPlayers = Integer.parseInt(numberOfPlayersString); 
		
		game = new Gameboard(numberOfPlayers);
		
		totalNumPlayers = numberOfPlayers;
		
		printStatus();
		
		while (true) {
			
		}
		
		
		
	}
	
	public static void printStatus() {
		for (int i = 0; i < totalNumPlayers; i++) {
			System.out.println(game.players.get(i));
		}
	}

}
