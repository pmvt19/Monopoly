
public class CommunityChest extends Plot {

	public CommunityChest(int x, int y) {
		super("Community Chest", x, y);
	}
	
	public void invoke(Player player) {
		System.out.println("Community Chest");
	}
}
