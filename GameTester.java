import java.util.ArrayList;

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
			runStartRoundMessage(game);
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
			boolean passedGo = game.newPosition(player, numRolled);
			if (passedGo) {
				player.myNetWorth += 200;
			}
		}
	}
	
	public static void endingTurnScreen(Player player) {
		Object[] options1 = {"Propose Trade", "End"};
	
		int result = JOptionPane.showOptionDialog(null,
				"Ending " + player.mySymbol + "'s Turn; Cash Left: " + player.myNetWorth,
		        "Game",
		        JOptionPane.YES_NO_CANCEL_OPTION,
		        JOptionPane.PLAIN_MESSAGE,
		        null,
		        options1,
		        null);
		
		if (result == 0) {
			//Place trading function here
			runTrade(player, game);
			endingTurnScreen(player);
		}
		
		
		//return result; //Fix this lol
	}
	
	public static void runTrade(Player player, Gameboard game) {
		
		
		
		Object[] options1 = new Object[game.players.size() - 1];
		ArrayList<Player> holdRefPlayers = new ArrayList<Player>();
		int count = 0;
		for (int i  = 0; i < game.players.size(); i++) {
			if (player != game.players.get(i)) {
				options1[count] = game.players.get(i).mySymbol;
				holdRefPlayers.add(game.players.get(i));
				count++;
			}
		}
		

		
		int result = JOptionPane.showOptionDialog(null,
				"Who would " + player.mySymbol + " like to trade with?",
		        "Game",
		        JOptionPane.YES_NO_CANCEL_OPTION,
		        JOptionPane.PLAIN_MESSAGE,
		        null,
		        options1,
		        null);
		
		switch(result) { 
			case 0:
				tradeWidth(player, holdRefPlayers.get(0));
				break;
			case 1:
				tradeWidth(player, holdRefPlayers.get(1));
				break;
			case 2:
				tradeWidth(player, holdRefPlayers.get(2));
				break;
			case 3:
				tradeWidth(player, holdRefPlayers.get(3));
				break;
			case 4:
				tradeWidth(player, holdRefPlayers.get(4));
				break;
			case 5:
				tradeWidth(player, holdRefPlayers.get(5));
				break;
			case 6:
				tradeWidth(player, holdRefPlayers.get(6));
				break;
			case 7:
				tradeWidth(player, holdRefPlayers.get(7));
				break;
		}
		//JOptionPane.showMessageDialog(new JFrame(), "Trade feature currently unavailable");
	}
	
	public static void tradeWidth(Player player, Player toTradeWith) {
		Object[] options1 = new Object[toTradeWith.myProperties.size() + 1];
		Object[] myProps = new Object[player.myProperties.size() + 1];
		
		ArrayList<Property> holdProps = new ArrayList<Property>();
		for (int i  = 0; i < player.myProperties.size(); i++) {
			holdProps.add(player.myProperties.get(i));
			myProps[i] = player.myProperties.get(i);
			
		}
		
		myProps[player.myProperties.size()] = "Cancel"; 
		
		int myProp = JOptionPane.showOptionDialog(null,
				"Choose " + player.mySymbol + "'s property to trade with",
		        "Game",
		        JOptionPane.YES_NO_CANCEL_OPTION,
		        JOptionPane.PLAIN_MESSAGE,
		        null,
		        myProps,
		        null);
		Property mineToTrade = null;
		if (myProp < player.myProperties.size()) {
			mineToTrade = holdProps.get(myProp);
		} else {
			return;
		}
		
	
		ArrayList<Property> holdRefProp = new ArrayList<Property>();
		for (int i  = 0; i < toTradeWith.myProperties.size(); i++) {
				holdRefProp.add(toTradeWith.myProperties.get(i));
				options1[i] = toTradeWith.myProperties.get(i);
				
		}
		
		options1[toTradeWith.myProperties.size()] = "Cancel";
		

		
		int result = JOptionPane.showOptionDialog(null,
				"Choose " + toTradeWith.mySymbol + "'s property to trade with",
		        "Game",
		        JOptionPane.YES_NO_CANCEL_OPTION,
		        JOptionPane.PLAIN_MESSAGE,
		        null,
		        options1,
		        null);
		Property toTrade = holdRefProp.get(result);
		
		
		if (result != options1.length - 1) {
			Object[] choice = {"Yes", "No"};
			
			int decision = JOptionPane.showOptionDialog(null,
					"Would " + toTradeWith.mySymbol + " Like to accept the trade with " + player.mySymbol + " for " + holdRefProp.get(result).myName,
			        "Trade",
			        JOptionPane.YES_NO_CANCEL_OPTION,
			        JOptionPane.PLAIN_MESSAGE,
			        null,
			        choice,
			        null);
			if (decision == 0) {
				player.myProperties.add(toTrade);
				player.myProperties.remove(mineToTrade);
				toTradeWith.myProperties.add(mineToTrade);
				toTradeWith.myProperties.remove(toTrade);
			}
		}
		
		
		
	}
	
	public static void buyAndRentTurn(Player player, Plot currentPlot) {
		Property currentProp = (Property) currentPlot;
		//printStatus(player);
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
				if (currentPlot instanceof Property) {
					Property prop = (Property) currentPlot;
					Player newOwner = prop.myOwner;
					newOwner.myNetWorth += player.myNetWorth;
					player.myNetWorth = 0;
					for (Property props : player.myProperties) {
						newOwner.myProperties.add(props);
					}
					
					for (int i = player.myProperties.size() - 1; i >= 0; i++) {
						player.myProperties.remove(i);
					}
				}
				//game.testBankrupcy();
				
			}
		}
	}
	
	public static void runRailroad(Player player, Plot currentPlot) {
		Railroad currentProp = (Railroad) currentPlot;
		//printStatus(player);
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
				if (currentPlot instanceof Property) {
					Property prop = (Property) currentPlot;
					Player newOwner = prop.myOwner;
					newOwner.myNetWorth += player.myNetWorth;
					player.myNetWorth = 0;
					for (Property props : player.myProperties) {
						newOwner.myProperties.add(props);
					}
					
					for (int i = player.myProperties.size() - 1; i >= 0; i++) {
						player.myProperties.remove(i);
					}
				}
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
	
	public static void runStartRoundMessage(Gameboard game) {
		String toDisplay = "";
		int totalPlayers = game.players.size();
		
		for (int i = 0; i < totalPlayers; i++) {
			toDisplay += game.players.get(i).toString() + "";
		}
		JOptionPane.showMessageDialog(new JFrame(), toDisplay, "Status Update", 1);
	}
	//Fix (See below comment)
	public static void runElectricCompany(Player player, Plot currentPlot, int roll) {
		
		ElectricCompany currentProp = (ElectricCompany) currentPlot;
		//printStatus(player);
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
				currentProp.invoke(player, roll, game);
			} else if (result == 1) {
				player.bankrupt = true;
				if (currentPlot instanceof Property) {
					Property prop = (Property) currentPlot;
					Player newOwner = prop.myOwner;
					newOwner.myNetWorth += player.myNetWorth;
					player.myNetWorth = 0;
					for (Property props : player.myProperties) {
						newOwner.myProperties.add(props);
					}
					
					for (int i = player.myProperties.size() - 1; i >= 0; i++) {
						player.myProperties.remove(i);
					}
				}
				//game.testBankrupcy();
				
			}
		}
		
		
		/*JOptionPane.showMessageDialog(new JFrame(), player.mySymbol + " has landed on Electric Company.");
		ElectricCompany electric = (ElectricCompany) currentPlot;
		electric.invoke(player, roll, game);*/
	}
	//Fix need to use the custom buttons here instead of the okay button screen
	public static void runWaterWorks(Player player, Plot currentPlot, int roll) {
		
		WaterWorks currentProp = (WaterWorks) currentPlot;
		//printStatus(player);
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
				currentProp.invoke(player, roll, game);
			} else if (result == 1) {
				player.bankrupt = true;
				if (currentPlot instanceof Property) {
					Property prop = (Property) currentPlot;
					Player newOwner = prop.myOwner;
					newOwner.myNetWorth += player.myNetWorth;
					player.myNetWorth = 0;
					for (Property props : player.myProperties) {
						newOwner.myProperties.add(props);
					}
					
					for (int i = player.myProperties.size() - 1; i >= 0; i++) {
						player.myProperties.remove(i);
					}
				}
				//game.testBankrupcy();
				
			}
		}
		
		/*JOptionPane.showMessageDialog(new JFrame(), player.mySymbol + " has landed on Water Works.");
		WaterWorks water = (WaterWorks) currentPlot;
		water.invoke(player, roll, game);*/
	}
	
	public static void sendToJail(Player player) {
		player.updateLocation(0, 10);
		Jail jail = (Jail) game.plot[0][10];
		jail.addPlayerToJail(player);
		
		
	}
	
	public static void invokeTurn(Player player) {
		
		RollResult rollResult;
		int iteration = 0;
		if (!player.bankrupt) {
			do {
				iteration++;
				if (iteration == 3) {
					sendToJail(player);
				}
				rollResult = player.rollDice();
				int movement = rollResult.totalRollNum;
				startTurnScreen(player, movement, rollResult.canRollAgain);
				
				Plot currentPlot = game.plot[player.x][player.y];
				if (currentPlot instanceof IncomeTax) {
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
				} else if (currentPlot instanceof Property) {
					buyAndRentTurn(player, currentPlot);
				}
				endingTurnScreen(player);
				
				
				
			} while(rollResult.canRollAgain);
			
		
		}
	}

}
