import javax.swing.JOptionPane;

public class GameTester {

	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		
		String temp = JOptionPane.showInputDialog("How Many Players?");
		
		int temp1 = Integer.parseInt(temp); 
		
		Gameboard game = new Gameboard(temp1);
		
		System.out.println(game.players.get(0).getSymbol());
		System.out.println(game.players.get(1).getSymbol());
		System.out.println(game.players.get(0).getNetWorth());
		System.out.println(game.players.get(1).getNetWorth());
	}

}
