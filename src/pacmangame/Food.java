package pacmangame;

public class Food extends BoardPiece {
	
	private static int points = 10;
	private boolean powers;
	
	public Food(Position pos, boolean powers) {
		super(pos, points, true);
		this.powers = powers;
		BoardState.foodPlacement.add(this);
		BoardState.things.put(pos, this);
	}

}
