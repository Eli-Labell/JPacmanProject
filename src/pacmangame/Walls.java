package pacmangame;

public class Walls extends BoardPiece {
	
	private static final boolean[] whatAmI = new boolean[] {true, false, false, false, false};
	private static int points = 0;
	
	public Walls(Position pos) {
		super(whatAmI, pos, points, true);
		BoardState.wallPlacement.add(this);
		BoardState.things.put(pos, this);
	}
	
	
}
