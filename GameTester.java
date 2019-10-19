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
		if (!player.bankrupt) {
			do {
				
				rollResult = player.rollDice();
				int movement = rollResult.totalRollNum;
				game.newPosition(player, movement);
				game.checkIfPassedGo(player);
				//printStatus(player);
				///System.out.println("Rolled: " + movement);
				/*System.out.println("X: " + player.x + ", Y: " + player.y);
				System.out.println("warp");
				System.out.println(game.plot[player.x][player.y]);*/
				//System.out.println((Property) game.plot[player.x][player.y]);
				Plot currentPlot = game.plot[player.x][player.y];
				if (currentPlot instanceof Property) {
					Property currentProp = (Property) currentPlot;
					printStatus(player);
					if (!currentProp.isOwned) {
						Object[] options1 = {"Buy",
				                 "Pass"};
							
						int result = JOptionPane.showOptionDialog(null,
								"Would " + player.mySymbol +  " Like to Buy " + currentProp.myName + "?",
				                 "Game",
				                 JOptionPane.YES_NO_CANCEL_OPTION,
				                 JOptionPane.PLAIN_MESSAGE,
				                 null,
				                 options1,
				                 null);
						
						if (result == 0) {
							currentProp.buyProperty(player);
							continue;
						} else if (result == 1) {
							//currentProp.payRent(player);
							continue;
						}
					} else {
						Object[] options1 = {"Pay Rent",
				                 "Declare Bankrupcy"};
	
						int result = JOptionPane.showOptionDialog(null,
								"Would " + player.mySymbol +  " Like to Pay Rent at " + currentProp.myName + "?",
				                 "Game",
				                 JOptionPane.YES_NO_CANCEL_OPTION,
				                 JOptionPane.PLAIN_MESSAGE,
				                 null,
				                 options1,
				                 null);
						if (result == 0) {
							currentProp.payRent(player);
						} else if (result == 1) {
							player.bankrupt = true;
							//game.testBankrupcy();
							break;
						}
						
					}
				
				}
				//(game.plot[player.x][player.y]).invoke(player);
				//printStatus(player);
				//cSystem.out.println("FINISHED");
				
				
			} while(rollResult.canRollAgain);
			
		
		}
	}

}
