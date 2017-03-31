package pacmangame;

public class Food extends BoardPiece {
	
	private static final boolean[] whatAmI = new boolean[] {false, true, false, false, false};
	private static int points = 10;
	private boolean powers;
	
	public Food(int[][] pos, boolean powers) {
		super(whatAmI, pos, points, true);
		this.powers = powers;
		BoardState.foodPlacement.add(this);
		BoardState.things.put(pos, this);
	}

}
