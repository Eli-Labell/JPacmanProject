package pacmangame;

public class Walls extends BoardPiece {
	
	private static int points = 0;
	
	public Walls(Position pos) {
		super(pos, points, true);
		BoardState.wallPlacement.add(this);
		BoardState.things.put(pos, this);
	}
	
	
}
