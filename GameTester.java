import javax.swing.JFrame;
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
	
	public static void startTurnScreen(Player player, int numRolled, boolean doubles) {
		Object[] options1 = {"Roll"};
		
		int result = JOptionPane.showOptionDialog(null,
				"Starting " + player.mySymbol + "'s Turn",
		        "Game",
		        JOptionPane.YES_NO_CANCEL_OPTION,
		        JOptionPane.PLAIN_MESSAGE,
		        null,
		        options1,
		        null);
		
		if (result == 0) {
			JOptionPane.showMessageDialog(new JFrame(), player.mySymbol + " has rolled a " + numRolled + "; Doubles: " + doubles);
			game.newPosition(player, numRolled);
			game.checkIfPassedGo(player);
		}
	}
	
	public static void endingTurnScreen(Player player) {
		Object[] options1 = {"End"};
	
		int result = JOptionPane.showOptionDialog(null,
				"Ending " + player.mySymbol + "'s Turn",
		        "Game",
		        JOptionPane.YES_NO_CANCEL_OPTION,
		        JOptionPane.PLAIN_MESSAGE,
		        null,
		        options1,
		        null);
		
		
		//return result; //Fix this lol
	}
	
	public static void buyAndRentTurn(Player player, Plot currentPlot) {
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
				currentProp.buyProperty(player, game);
				//continue;
			} else if (result == 1) {
				//currentProp.payRent(player);
				//continue;
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
				
			}
		}
	}
	
	public static void runRailroad(Player player, Plot currentPlot) {
		Railroad currentProp = (Railroad) currentPlot;
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
				currentProp.buyProperty(player, game);
				//continue;
			} else if (result == 1) {
				//currentProp.payRent(player);
				//continue;
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
				
			}
		}
	}
	
	public static void runIncomeTax(Player player, Plot currentPlot) {
		JOptionPane.showMessageDialog(new JFrame(), player.mySymbol + " has landed on Income Tax. You will pay $200");
		IncomeTax tax = (IncomeTax) currentPlot;
		tax.invoke(player);
	}
	
	public static void runLuxuryTax(Player player, Plot currentPlot) {
		JOptionPane.showMessageDialog(new JFrame(), player.mySymbol + " has landed on Luxury Tax. You will pay $100");
		LuxuryTax tax = (LuxuryTax) currentPlot;
		tax.invoke(player);
	}
	
	public static void runChance(Player player, Plot currentPlot) {
		JOptionPane.showMessageDialog(new JFrame(), player.mySymbol + " has landed on Chance.");
		Chance chance = (Chance) currentPlot;
		chance.invoke(player);
	}
	
	public static void runCommunityChest(Player player, Plot currentPlot) {
		JOptionPane.showMessageDialog(new JFrame(), player.mySymbol + " has landed on Community Chest.");
		CommunityChest chest = (CommunityChest) currentPlot;
		chest.invoke(player);
	}
	//Fix (See below comment)
	public static void runElectricCompany(Player player, Plot currentPlot, int roll) {
		JOptionPane.showMessageDialog(new JFrame(), player.mySymbol + " has landed on Electric Company.");
		ElectricCompany electric = (ElectricCompany) currentPlot;
		electric.invoke(player, roll, game);
	}
	//Fix need to use the custom buttons here instead of the okay button screen
	public static void runWaterWorks(Player player, Plot currentPlot, int roll) {
		JOptionPane.showMessageDialog(new JFrame(), player.mySymbol + " has landed on Water Works.");
		WaterWorks water = (WaterWorks) currentPlot;
		water.invoke(player, roll, game);
	}
	
	public static void invokeTurn(Player player) {
		RollResult rollResult;
		if (!player.bankrupt) {
			do {
				
				rollResult = player.rollDice();
				int movement = rollResult.totalRollNum;
				startTurnScreen(player, movement, rollResult.canRollAgain);
				/*game.newPosition(player, movement);
				game.checkIfPassedGo(player);*/
				//printStatus(player);
				///System.out.println("Rolled: " + movement);
				/*System.out.println("X: " + player.x + ", Y: " + player.y);
				System.out.println("warp");
				System.out.println(game.plot[player.x][player.y]);*/
				//System.out.println((Property) game.plot[player.x][player.y]);
				Plot currentPlot = game.plot[player.x][player.y];
				if (currentPlot instanceof Property) {
					buyAndRentTurn(player, currentPlot);
				} else if (currentPlot instanceof IncomeTax) {
					runIncomeTax(player, currentPlot);
				} else if (currentPlot instanceof LuxuryTax) {
					runLuxuryTax(player, currentPlot);
				} else if (currentPlot instanceof Railroad) {
					runRailroad(player, currentPlot);
				} else if (currentPlot instanceof Chance) {
					runChance(player, currentPlot);
				} else if (currentPlot instanceof CommunityChest) {
					runCommunityChest(player, currentPlot);
				} else if (currentPlot instanceof ElectricCompany) {
					runElectricCompany(player, currentPlot, movement);
				} else if (currentPlot instanceof WaterWorks) {
					runWaterWorks(player, currentPlot, movement);
				}
				endingTurnScreen(player);
				//(game.plot[player.x][player.y]).invoke(player);
				//printStatus(player);
				//cSystem.out.println("FINISHED");
				
				
			} while(rollResult.canRollAgain);
			
		
		}
	}

}
