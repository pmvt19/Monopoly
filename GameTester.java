import javax.swing.JOptionPane;
//Used to run the game
public class GameTester {
	
	static int totalNumPlayers;
	static Gameboard game;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String nums = "23456789";
		String numberOfPlayersString;
		do {
			numberOfPlayersString = JOptionPane.showInputDialog("How Many Players? (2 - 9)");
		} while(nums.indexOf(numberOfPlayersString) < 0 || numberOfPlayersString.equals(""));
		
		
		
		
		int numberOfPlayers = Integer.parseInt(numberOfPlayersString); 
		
		game = new Gameboard(numberOfPlayers);
		
		totalNumPlayers = numberOfPlayers;
		
		//printStatus();
		
		
		//invokeTurn(game.players.get(0));
		//invokeTurn(game.players.get(1));
		
		
		
		while (true) {
			for (int i = 0; i < totalNumPlayers; i++) {
				invokeTurn(game.players.get(i));
				printStatus(game.players.get(i));
			}
		}
		
		
		/*while (true) {
			game.players.get(0).rollDice();
		}*/
		
		
		
	}
	
	public static void printStatus() {
		for (int i = 0; i < totalNumPlayers; i++) {
			System.out.println(game.players.get(i));
		}
	}
	
	public static void printStatus(Player player) {
		System.out.println(player);
	}
	
	public static void fillBoard() {
		
	}
	
	public static void firstTurn() {
		game.players.get(0).rollDice();
	}
	
	public static void invokeTurn(Player player) {
		RollResult rollResult;
		
		do {
			rollResult = player.rollDice();
			int movement = rollResult.totalRollNum;
			game.newPosition(player, movement);
			game.checkIfPassedGo(player);
			//printStatus(player);
			/*System.out.println("X: " + player.x + ", Y: " + player.y);
			System.out.println("warp");
			System.out.println(game.plot[player.x][player.y]);*/
			//System.out.println((Property) game.plot[player.x][player.y]);
			(game.plot[player.x][player.y]).invoke(player);
			//printStatus(player);
			//cSystem.out.println("FINISHED");
			
			
		} while(rollResult.canRollAgain);
		
		//printStatus();
		
		//game.newPosition(player, movement);
		
		
	}

}
