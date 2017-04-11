package pacmangame;

/**
 * This class creates wall objects and adds them to the data structures that keep track of board piece objects<br>
 * 
 * @author Eliezer Labell
 *
 */
public class Walls extends BoardPiece {
	
	private static int points = 0;
	
	public Walls(Position pos) {
		super(pos, points, true);
		BoardState.wallPlacement.add(this);
		BoardState.things.put(pos, this);
	}
	
	
	
}
